/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public abstract class Usuario {

   
    private String correo;
    private String contrasenia;
    private String nombre;
    private String apellido;
    
     public Usuario(String correo, String contrasenia, String nombre, String apellido) {
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
    
    
}
