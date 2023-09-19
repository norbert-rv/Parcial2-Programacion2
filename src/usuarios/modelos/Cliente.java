/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */

public class Cliente {

    String correo;
    String contrasenia;
    String nombre;
    String apellido;

    public void mostrar() {
        System.out.println("Nombre: " + nombre 
                + "\nApellido: " + apellido 
                + "\nCorreo: " + correo 
                + "\nContraseña: " + contrasenia);
    }

//    Cliente(String mail, String nombre, String apellido, String contraseña) {
//        this.correo = mail;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.contrasenia = contraseña;
//    }

}
