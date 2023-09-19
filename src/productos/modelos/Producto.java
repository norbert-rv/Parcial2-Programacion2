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

    String nombre;
    String descripcion;
    String categoria;
    float precio;
    String estado;

    public void show() {
        System.out.println("Nombre: " + nombre
                + "\nDescripción :" + descripcion
                + "\nCategoría: " + categoria
                + "\nPrecio: " + precio
                + "\nEstado: " + estado);
    }

//    Producto(String nombre, String descripcion, String categoria, float precio, String estado) {
//        this.nombre = nombre;
//        this.descripcion = descripcion;
//        this.categoria = categoria;
//        this.precio = precio;
//        this.estado = estado;
//    }

}
