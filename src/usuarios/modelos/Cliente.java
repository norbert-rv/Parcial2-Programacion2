/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Cliente {

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente() {}

    public void mostrar() {
        System.out.println("Nombre: " + nombre
                + "\nApellido: " + apellido
                + "\nCorreo: " + correo
                + "\nContraseña: " + contrasenia);
    }

    // Constructor para la clase Cliente
    public Cliente(String nombre, String apellido, String correo, String contrasenia, ArrayList pedidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.pedidos = pedidos;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public String obtenerContrasenia() {
        return contrasenia;
    }

    public void asignarContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
