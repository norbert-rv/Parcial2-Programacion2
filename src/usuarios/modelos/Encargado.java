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
    
    String nombre;
    String apellido;
    String correo;
    String contrasenia;

    public void mostrar() {
        System.out.println("Nombre: " + nombre 
                + "\nApellido: " + apellido 
                + "\nCorreo: " + correo 
                + "\nContraseña: " + contrasenia);
    }
    
//    public Empleado crearEmpleado(){
//        Empleado nuevoEmpleado = new Empleado();
//        
//        return nuevoEmpleado;
//    }
    
}
