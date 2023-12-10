/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_CLAVES;
import static interfaces.IGestorUsuarios.VALIDACION_EXITO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfil;
import usuarios.modelos.Perfil;
import usuarios.vistas.VentanaCrearYModificarUsuario;

/**
 *
 * @author tomascabrerabellomo
 */
public class ControladorAMUsuario implements IControladorAMUsuario {

    private VentanaCrearYModificarUsuario ventanaCrearYModUsuario;

    // cadenas constantes para los cuadros de mensaje
    private static final String DATOS_INVALIDOS = "Los datos no son válidos. Por favor revise los campos.";

    // booleano para que el método btnGuardarClic() sepa si debe agregar un usuario nuevo o si debe modificarlo
    private boolean usuarioNuevo;
    private String correoUsuarioAModificar;

    // constructores sobrecargados para ControladorAMUsuario
    // constructor para NUEVO usuario
    public ControladorAMUsuario(java.awt.Dialog ventanaPadre) {
        this.ventanaCrearYModUsuario = new VentanaCrearYModificarUsuario(ventanaPadre, true, this);
        this.configurarPerfil();
        this.ventanaCrearYModUsuario.setLocationRelativeTo(null);
        this.ventanaCrearYModUsuario.setTitle(TITULO_NUEVO);
        this.usuarioNuevo = true;
        this.ventanaCrearYModUsuario.setVisible(true);
    }

    // constructor para MODIFICAR usuario
    public ControladorAMUsuario(java.awt.Dialog ventanaPadre, String correoUsuarioSeleccionado) {
        this.ventanaCrearYModUsuario = new VentanaCrearYModificarUsuario(ventanaPadre, true, this);
        this.ventanaCrearYModUsuario.verTextoCorreo().setText(correoUsuarioSeleccionado);
        this.ventanaCrearYModUsuario.verTextoCorreo().setEditable(false);
        this.ventanaCrearYModUsuario.verTextoCorreo().setOpaque(false);
        this.ventanaCrearYModUsuario.verTextoApellido().requestFocus();
        this.configurarPerfil();
        this.ventanaCrearYModUsuario.setLocationRelativeTo(null);
        this.ventanaCrearYModUsuario.setTitle(TITULO_MODIFICAR);
        this.usuarioNuevo = false;
        this.correoUsuarioAModificar = correoUsuarioSeleccionado;
        this.ventanaCrearYModUsuario.setVisible(true);
    }

    private void configurarPerfil() {
        ModeloComboPerfil modelo = new ModeloComboPerfil();
        this.ventanaCrearYModUsuario.verComboPerfiles().setModel(modelo);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

        String correo = ventanaCrearYModUsuario.verTextoCorreo().getText().trim();

        String apellido = ventanaCrearYModUsuario.verTextoApellido().getText().trim();

        String nombre = ventanaCrearYModUsuario.verTextoNombre().getText().trim();

        char[] clave = ventanaCrearYModUsuario.verTextoContrasenia().getPassword();

        char[] claveRepetida = ventanaCrearYModUsuario.verTextoContraseniaRep().getPassword();

        //controlar si la siguiente linea es correcta
        Perfil perfil = ((ModeloComboPerfil) ventanaCrearYModUsuario.verComboPerfiles().getModel()).obtenerPerfil();

        IGestorUsuarios gu = GestorUsuarios.instanciar();

        if (usuarioNuevo) {
            if (gu.verificarDatos(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida)).equals(VALIDACION_EXITO)) {
                gu.crearUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida));
                this.ventanaCrearYModUsuario.dispose();
            } else {
                if (gu.verificarDatos(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida)).equals(ERROR_CLAVES)) {
                    this.mensajeInformacion(ERROR_CLAVES, "Error");
                } else {
                    this.mensajeInformacion(DATOS_INVALIDOS, "Error");
                }
            }
        } else {
            // ¿Debería desahabilitar para seleccionar Perfil?
            // Llamo una sola vez a verificarDatos() para ahorrar tiempo
            String resultadoVerificacion = gu.verificarDatos(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida));

            if (resultadoVerificacion.equals(VALIDACION_EXITO)) {
                gu.modificarUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida));
                this.ventanaCrearYModUsuario.dispose();
            } else {
                if (resultadoVerificacion.equals(ERROR_CLAVES)) {
                    this.mensajeInformacion(ERROR_CLAVES, "Error");
                } else {
                    this.mensajeInformacion(DATOS_INVALIDOS, "Error");
                }
            }
        }
    }

    public void mensajeInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(this.ventanaCrearYModUsuario, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {

        int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaCrearYModUsuario, "¿Desea cancelar la carga del usuario? Se perderán los cambios no guardados.", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventanaCrearYModUsuario.dispose();
        }
    }

    /*
        La funcionalidad que espero obtener de estos métodos
        es que al presionar Enter el foco pase al siguiente
        campo de texto para escribir.
     */
    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verTextoApellido().requestFocus();
        }
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verTextoNombre().requestFocus();
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verTextoContrasenia().requestFocus();
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verTextoContraseniaRep().requestFocus();
        }
    }

    // para el caso del último campo, se ejecuta btnGuardarClic(). 
    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.btnGuardarClic(null);
        }
    }

}
