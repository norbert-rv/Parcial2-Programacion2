/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {

    private int codigo;
    private String descripcion;
    private String categoria;
    private float precio;
    private String estado;

    public void mostrar() {
        System.out.println("Codigo: " + codigo
                + "\nDescripción :" + descripcion
                + "\nCategoría: " + categoria
                + "\nPrecio: " + precio
                + "\nEstado: " + estado);
    }
    
    // Constructor de la clase Producto
    public Producto(int codigo, String descripcion, String categoria, float precio, String estado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
    }
    
    // Constructor vacío
    public Producto(){}
    
    // método para mostrar un producto (muestra la descripcion)
    @Override
    public String toString(){
        return descripcion;
    }

//    Producto(String nombre, String descripcion, String categoria, float precio, String estado) {
//        this.nombre = nombre;
//        this.descripcion = descripcion;
//        this.categoria = categoria;
//        this.precio = precio;
//        this.estado = estado;
//    }

    // getters y setters
    
    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }

}
