/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

/**
 *
 * @author estudiante
 */
import usuarios.modelos.*;
import productos.modelos.Producto;
import java.util.ArrayList;

public class ControladorPrincipal {

    public static void main(String[] args) {
        // Creamos ArrayLists para cada tipo de dato
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();

        // creo 3 objetos de cada clase y los añado a la corresponiente lista
        listaClientes.add(new Cliente("Tomas", "Cabrera", "tomascabrera@gmail.com", "clave1"));
        listaClientes.add(new Cliente("Ivana", "Romano", "ivana@gmail.com", "clave2"));
        listaClientes.add(new Cliente("Antonio", "Vargas", "tonio@hotmail.com", "toniotonio"));

        listaEmpleados.add(new Empleado("Gaby", "Romano", "gaby@hotmail.com", "clave!!!"));
        listaEmpleados.add(new Empleado("Angel", "Gomez", "angel@hotmail.com", "micontrasena"));
        listaEmpleados.add(new Empleado("Gustavo", "Patricios", "gustavo@hotmail.com", "esasssss"));

        listaEncargados.add(new Encargado("Axel", "Dominguez", "axelcito@gmail.com", "estaesunaclave"));
        listaEncargados.add(new Encargado("Laura", "Jimenez", "laurita@gmail.com", "lacontrasena"));
        listaEncargados.add(new Encargado("Chino", "Martinez", "chino@gmail.com", "otraclave"));

        listaProductos.add(new Producto(52, "Monitor Philips", "Monitores", 2500f, "No Disponible"));
        listaProductos.add(new Producto(53, "Mouse marca Genius", "Periféricos", 35000.00f, "Disponible"));
        listaProductos.add(new Producto(54, "AMD APU A10 5700K", "Procesadores", 50000f, "Disponible"));

        // punto 10. Recorremos las listas mostrando sus contenidos por pantalla
        for (Cliente cl : listaClientes) {
            System.out.println("Clientes: ");
            cl.mostrar();
            System.out.println("-------");
        }

        for (Empleado empl : listaEmpleados) {
            System.out.println("Empleados: ");
            empl.mostrar();
            System.out.println("-------");
        }

        for (Encargado enc : listaEncargados) {
            System.out.println("Encargados: ");
            enc.mostrar();
            System.out.println("-------");
        }

        for (Producto prod : listaProductos) {
            System.out.println("Productos: ");
            System.out.println(prod);
            System.out.println("-------");
        }

        // Modifico algunos campos de los objetos
        listaClientes.get(0).asignarNombre("Tomas Ignacio");
        listaEmpleados.get(2).asignarCorreo("gustavoCorreo@gmail.com");
        listaProductos.get(2).asignarDescripcion("Intel Core 2 Duo");

        System.out.println("\n\nRECORRER DE NUEVO LAS LISTAS PARA CORROBORAR LOS CAMBIOS\n");

        for (Cliente cl : listaClientes) {
            System.out.println("Clientes: ");
            cl.mostrar();
            System.out.println("-------");
        }

        for (Empleado empl : listaEmpleados) {
            System.out.println("Empleados: ");
            empl.mostrar();
            System.out.println("-------");
        }

        for (Encargado enc : listaEncargados) {
            System.out.println("Encargados: ");
            enc.mostrar();
            System.out.println("-------");
        }

        for (Producto prod : listaProductos) {
            System.out.println("Productos: ");
            System.out.println(prod);
            System.out.println("-------");
        }
    }
}
