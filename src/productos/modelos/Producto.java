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
    private float precio;
    
    private Estado estado;
    private Categoria categoria;
//    private String categoria;
//    private String estado;
    
    public void mostrar() {
        System.out.println("Codigo: " + codigo
                + "\nDescripción: " + descripcion
                + "\nCategoría: " + categoria.toString()
                + "\nPrecio: " + precio
                + "\nEstado: " + estado.toString());
    }
    
    // Constructor de la clase Producto
    public Producto(int codigo, String descripcion, Categoria cat, Estado estado, float precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = cat;
        this.estado = estado;
    }
    
    // Constructor vacío
    public Producto(){}
    
    // método para mostrar un producto (muestra la descripcion)
    @Override
    public String toString(){
        return descripcion;
    }

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

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
    }
    
}
