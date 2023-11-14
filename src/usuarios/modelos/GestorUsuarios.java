/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;


/**
 *
 * @author estudiante
 */
public class GestorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String PERFIL_CAMBIO = "El usuario no puede cambiarse de perfil";
    public static final String ERROR_PERMISOS = "No se tienen los permisos para realizar esta funcionalidad";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String USUARIO_INEXISTENTE = "No existe el usuario especificado";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";

    // Implementación del patrón Singleton
    private static GestorUsuarios gestor;

    private GestorUsuarios() {

    }

    public static GestorUsuarios crearGestorUsuarios() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }

        return gestor;
    }

    private String validarDatos(String correo, String contrasenia, String claverepetida, String apellido, String nombre) {

        if (correo == null || !correo.contains("@")) {
            return ERROR_CORREO;
        }

        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }

        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (contrasenia == null || apellido.isEmpty()) {
            return ERROR_CLAVES;
        } else if (!claverepetida.equals(contrasenia)) {
            return ERROR_CLAVES;
        }

        return EXITO;
    }

    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        /*crea un nuevo usuario,
devolviendo una cadena con el resultado de la operación.*/

        if (!this.validarDatos(correo, apellido, nombre, clave, claveRepetida).equals(VALIDACION_EXITO)) {
            return this.validarDatos(correo, apellido, nombre, clave, claveRepetida);
        }

        switch (perfil) {
            case CLIENTE:
                Usuario u = new Cliente(correo, clave, apellido, nombre);

                if (!usuarios.contains(u)) {
                    usuarios.add(u);
                    return EXITO;
                } else {
                    return USUARIOS_DUPLICADOS;
                }
            case ENCARGADO:
                Usuario encargado = new Encargado(correo, apellido, nombre, clave);
                if (!usuarios.contains(encargado)) {
                    usuarios.add(encargado);
                    return EXITO;
                } else {
                    return USUARIOS_DUPLICADOS;
                }
            default:
                Usuario empleado = new Empleado(correo, apellido, nombre, clave);
                if (!usuarios.contains(empleado)) {
                    usuarios.add(empleado);
                    return EXITO;
                } else {
                    return USUARIOS_DUPLICADOS;
                }
        }

    }
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    
   public ArrayList<Usuario> buscarUsuarios(String apellido){ /*busca si
    existen usuarios con el apellido especificado (total o parcialmente).*/
       
    ArrayList<Usuario> coincidenciasapellido = new ArrayList<>();

        // Esta verificacion ahorra recorrer el ArrayList productos innecesariamente
        if (apellido == null) {
            return coincidenciasapellido;
        }

        for (Usuario p : usuarios) {
            if (p.toString().toLowerCase().contains(apellido.toLowerCase())) {
                coincidenciasapellido.add(p);
            }
        }

        return coincidenciasapellido;
   }
   public boolean existeEsteUsuario(Usuario usuario) /*devuelve true si existe el usuario especificado, false en caso contrario.*/{
       return usuarios.contains(usuario);
   }
   
   public Usuario obtenerUsuario(String correo)/* obtiene el usuario con el correo especificado. Si no hay un usuario con el correo, devuelve null.*/{
       for (Usuario u : usuarios) {
           
            if (u.verCorreo().equalsIgnoreCase(correo)) {
                return u;
            }
        }
        return null;
   }
}
