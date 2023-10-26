/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import java.time.LocalDateTime;
import productos.modelos.Producto;
import usuarios.modelos.Encargado;
import usuarios.modelos.Empleado;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import usuarios.modelos.Usuario;


/**
 *
 * @author root
 */
public class ControladorPrincipal  {
    public static void main(String[] args) {
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        ArrayList<Empleado> empleados = new ArrayList<>();
//        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        Usuario unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Usuario unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Usuario unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        Usuario unCliente4 = new Cliente("cliente2@bar.com", "claveCliente4", "ApellidoCliente4", "NombreCliente4");
        Usuario unCliente5 = new Cliente("cliente1@bar.com", "claveCliente5", "ApellidoCliente5", "NombreCliente5");
        Usuario unCliente6 = new Cliente("cliente6@bar.com", "claveCliente6", "ApellidoCliente6", "NombreCliente6");
        
        
        if(!usuarios.contains(unCliente1))
            usuarios.add(unCliente1);
        if(!usuarios.contains(unCliente2))
            usuarios.add(unCliente2);
        if(!usuarios.contains(unCliente3))
            usuarios.add(unCliente3);
        if(!usuarios.contains(unCliente4))
            usuarios.add(unCliente4);
        if(!usuarios.contains(unCliente5))
            usuarios.add(unCliente5);
        if(!usuarios.contains(unCliente6))
            usuarios.add(unCliente6);
        
        
        System.out.println("Clientes");
        System.out.println("========");
        for(Usuario c : usuarios) {
            c.mostrar();
            System.out.println();
        }
        System.out.println();        
        
        Empleado unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");        
        Empleado unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");        
        Empleado unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
                
        if(!usuarios.contains(unEmpleado1))
            usuarios.add(unEmpleado1);
        if(!usuarios.contains(unEmpleado2))
            usuarios.add(unEmpleado2);
        if(!usuarios.contains(unEmpleado3))
            usuarios.add(unEmpleado3);
        
        System.out.println("Empleados");
        System.out.println("=========");
        for(Usuario e : usuarios) {
            e.mostrar();
            System.out.println();
        }
        System.out.println();
        
        Encargado unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        
        if(!usuarios.contains(unEncargado1))
            usuarios.add(unEncargado1);
        if(!usuarios.contains(unEncargado2))
            usuarios.add(unEncargado2);
        if(!usuarios.contains(unEncargado3))
            usuarios.add(unEncargado3);
        
        System.out.println("Encargados");
        System.out.println("==========");
        for(Usuario e : usuarios) {
            e.mostrar();
            System.out.println();
        }
        System.out.println();
        
        Producto unProducto1 = new Producto(1, "Producto1", Categoria.ENTRADA, Estado.DISPONIBLE, 1.0f);        
        Producto unProducto2 = new Producto(2, "Producto2", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 2.0f);
        Producto unProducto3 = new Producto(3, "Producto3", Categoria.POSTRE, Estado.DISPONIBLE, 3.0f);

        // Agregando verificaciones para no añadir productos repetidos PUNTO 2
        if(!productos.contains(unProducto1))
            productos.add(unProducto1);
        
        if(!productos.contains(unProducto2))
            productos.add(unProducto2);
        
        if(!productos.contains(unProducto3))
            productos.add(unProducto3);
        
        System.out.println("Productos");
        System.out.println("=========");
        for(Producto p : productos) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
        
        
        unCliente1.asignarCorreo("cliente10@bar.com");
        System.out.println("Clientes");
        System.out.println("========");
        for(Usuario c : usuarios) {
            c.mostrar();
            System.out.println();
        }
        System.out.println();
        
        System.out.println(unProducto1);
        
        // Verificando que no se repitan productos en un pedido PUNTO 2
        
        ArrayList<ProductoDelPedido> pdp1 = new ArrayList<>();
        
        if(!pdp1.contains(new ProductoDelPedido(unProducto1, 1)))
            pdp1.add(new ProductoDelPedido(unProducto1, 1));
        
        if(!pdp1.contains(new ProductoDelPedido(unProducto2, 2)))
            pdp1.add(new ProductoDelPedido(unProducto2, 2));
        
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), pdp1, (Cliente)unCliente1);        
        
        ArrayList<ProductoDelPedido> pdp2 = new ArrayList<>();
        
        if(!pdp2.contains(new ProductoDelPedido(unProducto1, 10)))
            pdp2.add(new ProductoDelPedido(unProducto1, 10));
        
        if(!pdp2.contains(new ProductoDelPedido(unProducto2, 20)))
            pdp2.add(new ProductoDelPedido(unProducto2, 20));
        
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), pdp2, (Cliente)unCliente2);        
        
        ArrayList<ProductoDelPedido> pdp3 = new ArrayList<>();
        pdp3.add(new ProductoDelPedido(unProducto1, 100));
        pdp3.add(new ProductoDelPedido(unProducto2, 200));
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), pdp3, (Cliente)unCliente3);        
        
        // Agregando verificaciones para no añadir pedidos repetidos PUNTO 2
        if(!pedidos.contains(unPedido1))
            pedidos.add(unPedido1);
        if(!pedidos.contains(unPedido2))
            pedidos.add(unPedido2);
        if(!pedidos.contains(unPedido3))
            pedidos.add(unPedido3);
        
        System.out.println("Pedidos");
        System.out.println("=======");
        for(Pedido p : pedidos) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
        
    }   
}