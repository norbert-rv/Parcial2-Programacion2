/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class GestorProductos {

    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";

    private ArrayList<Producto> productos = new ArrayList<>();

    // Implementación del patrón Singleton
    private static GestorProductos gestor;

    private GestorProductos() {
    }

    ;
    
    public static GestorProductos crearGestorProducto() {
        if (gestor == null) {
            gestor = new GestorProductos();
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

            productos.get(indiceProducto).asignarCodigo(codigo);
            productos.get(indiceProducto).asignarDescripcion(descripcion);
            productos.get(indiceProducto).asignarPrecio(precio);
            productos.get(indiceProducto).asignarCategoria(categoria);
            productos.get(indiceProducto).asignarEstado(estado);

            return EXITO;
        }
    }

    public ArrayList<Producto> menu() {
        return productos;
    }

    public ArrayList<Producto> buscarProductos(String descripcion) {

        ArrayList<Producto> coincidenciasDescripcion = new ArrayList<>();

        // Esta verificacion ahorra recorrer el ArrayList productos innecesariamente
        if (descripcion == null) {
            return coincidenciasDescripcion;
        }

        for (Producto p : productos) {
            if (p.toString().toLowerCase().contains(descripcion.toLowerCase())) {
                coincidenciasDescripcion.add(p);
            }
        }

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
}
