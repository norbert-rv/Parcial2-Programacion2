/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Encargado {
    
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;

    public void mostrar() {
        System.out.println("Nombre: " + nombre 
                + "\nApellido: " + apellido 
                + "\nCorreo: " + correo 
                + "\nContraseña: " + contrasenia);
    }
    
    // Constructor para la clase Encargado
    public Encargado(String nombre, String apellido, String correo, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    
//    public Empleado crearEmpleado(){
//        Empleado nuevoEmpleado = new Empleado();
//        
//        return nuevoEmpleado;
//    }

    // vertters y asignarters
    
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public String verContrasenia() {
        return contrasenia;
    }

    public void asignarContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
