/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario{
    
   
    // Constructor para la clase Empleado
    public Empleado(String nombre, String apellido, String correo, String contrasenia) {
        super(correo, contrasenia, nombre, apellido);
    }
    
}
