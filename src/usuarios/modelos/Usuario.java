/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public abstract class Usuario {

    private String correo;
    private String contrasenia;
    private String nombre;
    private String apellido;

    public Usuario(String correo, String contrasenia, String apellido, String nombre) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre
                + "\nApellido: " + apellido
                + "\nCorreo: " + correo
                + "\nContraseña: " + contrasenia);
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.correo);
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }

    public abstract ArrayList<Pedido> verPedidos();
    
    /*
    Métodos verNombre() y verApellido() para coincidir con los nombres del
    controlador principal del tp4 de los profes. Durante los primeros tp dijeron
    que get => obtener y set => asignar. Por lo tanto dejaremos los métodos
    get/set por el momento y agrego los nuevos métodos para que funcione el main
    subido.
    */
    
    public String verNombre(){
        return nombre;
    }
    
    public String verApellido(){
        return apellido;
    }
}
