/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author estudiante
 */
public class GestorProductos implements IGestorProductos {

    private List<Producto> productos = new ArrayList<>();

    //nombre del archivo que guarda los productos
    private String archivoproductos;
    private static final String REGEX_ARCHIVO_USUARIOS = ",";

    // Implementación del patrón Singleton
    private static GestorProductos gestor;

    private GestorProductos(String archivoproductos) {
        this.archivoproductos = archivoproductos;
        this.leer(archivoproductos);
    }

    public static GestorProductos instanciar(String archivoproductos) {
        if (gestor == null) {
            gestor = new GestorProductos(archivoproductos);
        }
        return gestor;
    }

    // Fin patrón Singleton
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (!this.validarDatos(codigo, descripcion, precio, categoria, estado).equals(VALIDACION_EXITO)) {
            return this.validarDatos(codigo, descripcion, precio, categoria, estado);
        }

        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);

        if (!productos.contains(p)) {
            productos.add(p);
            this.escribir();
            return EXITO;
        } else {
            return PRODUCTOS_DUPLICADOS;
        }
    }

    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (!this.validarDatos(codigo, descripcion, precio, categoria, estado).equals(VALIDACION_EXITO)) {
            return this.validarDatos(codigo, descripcion, precio, categoria, estado);
        }

        if (!productos.contains(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        } else {
            int indiceProducto = productos.indexOf(productoAModificar);

//            productos.get(indiceProducto).asignarCodigo(codigo);
            productos.get(indiceProducto).asignarDescripcion(descripcion);
            productos.get(indiceProducto).asignarPrecio(precio);
            productos.get(indiceProducto).asignarCategoria(categoria);
            productos.get(indiceProducto).asignarEstado(estado);
            this.escribir();
            return EXITO;
        }
    }

    public List<Producto> menu() {

        Collections.sort(productos, new CompProductoCatYDesc());

        return productos;
    }

    public List<Producto> buscarProductos(String descripcion) {

        List<Producto> coincidenciasDescripcion = new ArrayList<>();

        // Esta verificacion ahorra recorrer el ArrayList productos innecesariamente
        if (descripcion == null) {
            return coincidenciasDescripcion;
        }

        for (Producto p : productos) {
            if (p.toString().toLowerCase().contains(descripcion.toLowerCase())) {
                coincidenciasDescripcion.add(p);
            }
        }

        Collections.sort(coincidenciasDescripcion, new CompProductoCatYDesc());

        return coincidenciasDescripcion;
    }

    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {

        ArrayList<Producto> productosCategoriaCoincidente = new ArrayList<>();

        if (categoria == null) {
            return productosCategoriaCoincidente;
        }

        for (Producto p : productos) {
            if (p.verCategoria().equals(categoria)) {
                productosCategoriaCoincidente.add(p);
            }
        }

        Collections.sort(productos, new CompProductoDesc());

        return productosCategoriaCoincidente;
    }

    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    private String validarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }

        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }

        if (precio <= 0) {
            return ERROR_PRECIO;
        }

        if (categoria == null) {
            return ERROR_CATEGORIA;
        }

        if (estado == null) {
            return ERROR_ESTADO;
        }

        return VALIDACION_EXITO;
    }

    public String borrarProducto(Producto producto) {

        GestorPedidos gp = GestorPedidos.crearGestorPedidos();

        if (!productos.contains(producto)) {
            return PRODUCTO_INEXISTENTE;
        }

        if (!gp.hayPedidosConEsteProducto(producto)) {
            productos.remove(producto);
            this.escribir();
            return EXITO;
        } else {
            return ERROR_BORRAR_PRODUCTO;
        }
    }
    //creado metodo para escribir los productos creados en el archivo de texto
    // queda el método publico??
    public void escribir() {
        BufferedWriter bw = null;
        File f = new File(this.archivoproductos);
        try {
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            //for(Producto p : this.productos) { 
            //cambio del for anterior por el actual para poder agregar el salto de linea
            for (int i = 0; i < this.productos.size(); i++) {
                Producto unProducto = this.productos.get(i);
                String linea;
                linea = Integer.toString(unProducto.verCodigo()) + REGEX_ARCHIVO_USUARIOS;
                linea += unProducto.verDescripcion() + REGEX_ARCHIVO_USUARIOS;
                linea += unProducto.verCategoria() + REGEX_ARCHIVO_USUARIOS;
                linea += unProducto.verEstado() + REGEX_ARCHIVO_USUARIOS;
                linea += Float.toString(unProducto.verPrecio());

                bw.write(linea);
                if (i < this.productos.size() - 1) {
                    bw.newLine();
                }
            }
             // está repetido el bw.close() avisar tomi ???
            bw.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error de entrada o salida de datos");
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    //metodo para leer el archivo de texto, lee los elementos separados por coma, falta corregir el finally
    private void leer(String nombreArchivo) {
        BufferedReader br = null;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                FileReader fr = new FileReader(f);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] vector = linea.split(REGEX_ARCHIVO_USUARIOS);
                    int codigo = Integer.parseInt(vector[0]);
                    String descripcion = vector[1];
                    Categoria categoria = Categoria.valueOf(vector[2]);
                    Estado estado = Estado.valueOf(vector[3]);
                    float precio = Float.parseFloat(vector[4]);
                    Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
                    this.productos.add(p);
                }

            } catch (FileNotFoundException fr) {
                System.out.println("No se pudo encontrar el archivo para abrirlo");
            } catch (IOException fr) {
                System.out.println("No se pudo leer el archivo.");
            } catch (IllegalArgumentException fnf) {
                System.out.println("El argumento que ha ingresado no es válido");
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException fr) {
                        fr.printStackTrace();
                    }
                }
            }
        }
    }

}
