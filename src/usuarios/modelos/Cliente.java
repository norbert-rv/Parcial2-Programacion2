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
public class Cliente extends Usuario{
   
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    // Constructor para la clase Cliente
    // un cliente puede existir sin haber hecho aún un pedido
    public Cliente(String correo, String contrasenia, String nombre, String apellido) {
    super(correo, contrasenia, nombre, apellido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
