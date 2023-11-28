/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
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

    private GestorProductos() {
    }

    ;
    
    public static GestorProductos instanciar() {
        if (gestor == null) {
            gestor = new GestorProductos();
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
}
