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
import static java.lang.String.valueOf;
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

    // Implementación del patrón Singleton
    private static GestorProductos gestor;

    //constructor vacio
//    private GestorProductos() {
//    }
//    ;
    //nombre del archivo que guarda los productos
     private String archivoproductos;
     
     private GestorProductos(String archivoproductos ) {
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
    @Override
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

    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {

        if (!this.validarDatos(codigo, descripcion, precio, categoria, estado).equals(VALIDACION_EXITO)) {
            return this.validarDatos(codigo, descripcion, precio, categoria, estado);
        }

        if (!productos.contains(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        } else {
            int indiceProducto = productos.indexOf(productoAModificar);

            productos.get(indiceProducto).asignarCodigo(codigo);
            productos.get(indiceProducto).asignarDescripcion(descripcion);
            productos.get(indiceProducto).asignarPrecio(precio);
            productos.get(indiceProducto).asignarCategoria(categoria);
            productos.get(indiceProducto).asignarEstado(estado);

            return EXITO;
        }
    }

    @Override
    public List<Producto> menu() {
        
        Collections.sort(productos, new CompProductoCatYDesc());
        
        return productos;
    }

    @Override
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

    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    @Override
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

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    private String validarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo < 0) {
            return ERROR_CODIGO;
        }

        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }

        if (precio < 0) {
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

    @Override
    public String borrarProducto(Producto producto) {

        GestorPedidos gp = GestorPedidos.crearGestorPedidos();
        
        if(!productos.contains(producto))
            return PRODUCTO_INEXISTENTE;

        if (!gp.hayPedidosConEsteProducto(producto)) {
            productos.remove(producto);
            return EXITO;
        } else {
            // ver esto. No hay un mensaje para este caso en las constantes
            return "No se puede borrar el producto porque existe un pedido con el mismo.";
        }
    }
     //creado metodo para escribir los productos creados en el archivo de texto
    public void escribir() {
        File f = new File(this.archivoproductos);
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Producto p : this.productos) {
                String linea;
                linea = Integer.toString(p.verCodigo()) + ",";
                linea += p.verDescripcion() + ",";
                linea += p.verCategoria() + ",";
                linea += p.verEstado()+ ",";
                linea += Float.toString(p.verPrecio()) ;
                
                bw.write(linea);
                bw.newLine();
            }
            
            bw.close();
        }
        catch(IOException e) {
            
        }}
    //metodo para leer el archivo de texto, lee los elementos separados por coma
    private void leer(String nombreArchivo) {
        File f = new File(nombreArchivo);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null) {
                String [] vector = linea.split(",");
                int codigo = Integer.parseInt(vector[0]);
                String descripcion = vector[1];
                Categoria categoria = Categoria.valueOf(vector[2]); 
                Estado estado = Estado.valueOf(vector[3]);
                float precio = Float.parseFloat(vector[4]);
                Producto p = new Producto(codigo,descripcion,categoria,estado,precio);
                this.productos.add(p);
            }
            
            br.close();
        }
        catch(FileNotFoundException fnf ) {
            
        }
        catch(IOException fnf ) {
            
        }}
}
