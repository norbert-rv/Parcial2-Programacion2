///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package usuarios.modelos;
//
//import interfaces.IGestorUsuarios;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import pedidos.modelos.GestorPedidos;
//
///**
// *
// * @author estudiante
// */
//public class GestorUsuarios implements IGestorUsuarios { // REVISAR ORDEN DE PARAMETROS EN LOS METODOS
//
//    private List<Usuario> usuarios = new ArrayList<>();
//
//    // Implementación del patrón Singleton
//    private static GestorUsuarios gestor;
//
//    private GestorUsuarios() {
//
//    }
//
//    public static GestorUsuarios instanciar() {
//        if (gestor == null) {
//            gestor = new GestorUsuarios();
//        }
//
//        return gestor;
//    }
//
//    private String validarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
//
//        if (correo == null || !correo.contains("@")) {
//            return ERROR_CORREO;
//        }
//
//        if (apellido == null || apellido.isEmpty()) {
//            return ERROR_APELLIDO;
//        }
//
//        if (nombre == null || nombre.isEmpty()) {
//            return ERROR_NOMBRE;
//        }
//        if (clave == null || apellido.isEmpty()) {
//            return ERROR_CLAVES;
//        } else if (!claveRepetida.equals(clave)) {
//            return ERROR_CLAVES;
//        }
//
//        // forma correcta de verificar el Perfil???
//        if (perfil == null) {
//            return ERROR_PERFIL;
//        }
//
//        return EXITO;
//    }
//
////    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
////        /*crea un nuevo usuario,
////devolviendo una cadena con el resultado de la operación.*/
////
////        if (!this.validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida).equals(VALIDACION_EXITO)) {
////            return this.validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
////        }
////
////        
////        
////        switch (perfil) {
////            case CLIENTE:
////                Usuario cliente = new Cliente(correo, clave, apellido, nombre);
////                
////                return this.agregarUsuario(cliente);
////
////            case ENCARGADO:
////                Usuario encargado = new Encargado(correo, apellido, nombre, clave);
////
////                return this.agregarUsuario(encargado);
////
////            default:
////                Usuario empleado = new Empleado(correo, apellido, nombre, clave);
////
////                return this.agregarUsuario(empleado);
////        }
////
////    }
//
//    
//    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
//
//        String salida = validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
//        if (!salida.equals(VALIDACION_EXITO)) {
//            return salida;
//        }
//
//        switch (perfil) {
//            case CLIENTE:
//                Usuario cliente = new Cliente(correo, clave, apellido, nombre);
//                salida = agregarUsuario(cliente);
//                break;
//
//            case EMPLEADO:
//                Usuario empleado = new Empleado(correo, clave, apellido, nombre);
//                salida = agregarUsuario(empleado);
//                break;
//
//            default:
//                Usuario encargado = new Encargado(correo, clave, apellido, nombre);
//                salida = agregarUsuario(encargado);
//                break;
//        }
//
//        return salida;
//    }
//    
//    private String agregarUsuario(Usuario usuario) {
//        if (!usuarios.contains(usuario)) {
//            usuarios.add(usuario);
//            return EXITO;
//        } else {
//            return USUARIOS_DUPLICADOS;
//        }
//    }
//
//    public List<Usuario> verUsuarios() {
//
//        Collections.sort(usuarios, new CompUsuarioApYNom());
//
//        return usuarios;
//    }
//
//    public List<Usuario> buscarUsuarios(String apellido) {
//        /*busca si
//    existen usuarios con el apellido especificado (total o parcialmente).*/
//
//        ArrayList<Usuario> coincidenciasapellido = new ArrayList<>();
//
//        // Esta verificacion ahorra recorrer el ArrayList productos innecesariamente
//        if (apellido == null) {
//            return coincidenciasapellido;
//        }
//
//        for (Usuario p : usuarios) {
//            if (p.toString().toLowerCase().contains(apellido.toLowerCase())) {
//                coincidenciasapellido.add(p);
//            }
//        }
//
//        Collections.sort(coincidenciasapellido, new CompUsuarioApYNom());
//
//        return coincidenciasapellido;
//    }
//
//    public boolean existeEsteUsuario(Usuario usuario) /*devuelve true si existe el usuario especificado, false en caso contrario.*/ {
//        return usuarios.contains(usuario);
//    }
//
//    public Usuario obtenerUsuario(String correo)/* obtiene el usuario con el correo especificado. Si no hay un usuario con el correo, devuelve null.*/ {
//        for (Usuario u : usuarios) {
//
//            if (u.verCorreo().equalsIgnoreCase(correo)) {
//                return u;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public String borrarUsuario(Usuario usuario) {
//
//        GestorPedidos gp = GestorPedidos.crearGestorPedidos();
//
//        if (!usuarios.contains(usuario)) {
//            return USUARIO_INEXISTENTE;
//        }
//
//        if (!gp.hayPedidosConEsteCliente((Cliente) usuario)) {
//            usuarios.remove(usuario);
//            return EXITO;
//        } else {
//            // será que tengo que mostrar este mensaje aquí???
//            return ERROR_PERMISOS;
//        }
//    }
//}
// LO HAGO DE NUEVO PORQUE NO FUNCIONA POR ALGUNA RAZÓN EXTRAÑA
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author ivana
 */
public class GestorUsuarios implements IGestorUsuarios {

    private List<Usuario> usuarios = new ArrayList<>();

    // Patrón Singleton
    private static GestorUsuarios gestor;

    private GestorUsuarios() {
    }

    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    public String verificarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.isEmpty() || !apellido.matches("[a-z A-Z]+")) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || nombre.isEmpty() || !nombre.matches("[a-z A-Z]+")) {
            return ERROR_NOMBRE;
        }
        if (clave == null || clave.isEmpty()) {
            return ERROR_CLAVES;
        }
        if (claveRepetida == null || claveRepetida.isEmpty() || !(claveRepetida.equals(clave))) {
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }

        return VALIDACION_EXITO;
    }

    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {

        String salida = verificarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);

        if (!salida.equals(VALIDACION_EXITO)) {
            return salida;
        }

        switch (perfil) {
            case CLIENTE:
                Usuario cliente = new Cliente(correo, clave, apellido, nombre);
                return agregarUsuario(cliente);

            case EMPLEADO:
                Usuario empleado = new Empleado(correo, clave, apellido, nombre);
                return agregarUsuario(empleado);

            // default para case ENCARGADO (sino hay que poner return para el método)
            default:
                Usuario encargado = new Encargado(correo, clave, apellido, nombre);
                return agregarUsuario(encargado);
        }
    }

    private String agregarUsuario(Usuario u) {
        if (!usuarios.contains(u)) {
            usuarios.add(u);
            return EXITO;
        } else {
            return USUARIOS_DUPLICADOS;
        }
    }

    public List<Usuario> verUsuarios() {
        Collections.sort(usuarios, new CompUsuarioApYNom());
        return usuarios;
    }

    public List<Usuario> buscarUsuarios(String apellido) {
        /*busca si
    existen usuarios con el apellido especificado (total o parcialmente).*/

        List<Usuario> coincidenciasapellido = new ArrayList<>();

        // Esta verificacion ahorra recorrer el ArrayList productos innecesariamente
        if (apellido == null) {
            return coincidenciasapellido;
        }

        for (Usuario p : usuarios) {
            if (p.toString().toLowerCase().contains(apellido.toLowerCase())) {
                coincidenciasapellido.add(p);
            }
        }

        Collections.sort(coincidenciasapellido, new CompUsuarioApYNom());

        return coincidenciasapellido;
    }

    public boolean existeEsteUsuario(Usuario usuario) /*devuelve true si existe el usuario especificado, false en caso contrario.*/ {
        return usuarios.contains(usuario);
    }

    public Usuario obtenerUsuario(String correo)/* obtiene el usuario con el correo especificado. Si no hay un usuario con el correo, devuelve null.*/ {
        for (Usuario u : usuarios) {

            if (u.verCorreo().equalsIgnoreCase(correo)) {
                return u;
            }
        }
        return null;
    }

    public String borrarUsuario(Usuario usuario) {

        GestorPedidos gp = GestorPedidos.crearGestorPedidos();

        if (!usuarios.contains(usuario)) {
            return USUARIO_INEXISTENTE;
        }

        if (!gp.hayPedidosConEsteCliente((Cliente) usuario)) {
            usuarios.remove(usuario);
            return EXITO;
        } else {
            // será que tengo que mostrar este mensaje aquí???
            return ERROR_PERMISOS;
        }
    }
}
