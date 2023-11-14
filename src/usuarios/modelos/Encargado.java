/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Encargado extends Usuario {

    // Constructor para la clase Encargado
    public Encargado(String correo, String contrasenia, String apellido, String nombre) {
        super(correo, contrasenia, apellido, nombre);
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        
        GestorPedidos gp = GestorPedidos.crearGestorPedidos();
        
        return gp.verPedidos();
    }
}
