/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado {
    
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
}
