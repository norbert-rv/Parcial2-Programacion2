/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_CLAVES;
import static interfaces.IGestorUsuarios.EXITO;
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

    // booleano para que el método btnGuardarClic() sepa si debe agregar un usuario nuevo o si debe modificarlo
    private boolean usuarioNuevo;
    private String correoUsuarioAModificar;

    // constructores sobrecargados para ControladorAMUsuario
    // constructor para NUEVO usuario
    public ControladorAMUsuario(java.awt.Dialog ventanaPadre) {
        this.ventanaCrearYModUsuario = new VentanaCrearYModificarUsuario(ventanaPadre, true, this);
        this.configurarperfil();
        this.ventanaCrearYModUsuario.setLocationRelativeTo(null);
        this.ventanaCrearYModUsuario.setTitle(TITULO_NUEVO);
        this.usuarioNuevo = true;
        this.ventanaCrearYModUsuario.setVisible(true);
    }

    // constructor para MODIFICAR usuario
    public ControladorAMUsuario(java.awt.Dialog ventanaPadre, String correoUsuarioSeleccionado) {
        this.ventanaCrearYModUsuario = new VentanaCrearYModificarUsuario(ventanaPadre, true, this);
        this.ventanaCrearYModUsuario.verTextocorreo().setText(correoUsuarioSeleccionado);
        this.ventanaCrearYModUsuario.verTextocorreo().setEditable(false);
        this.ventanaCrearYModUsuario.verTextocorreo().setOpaque(false);
        this.ventanaCrearYModUsuario.verTextoapellido().requestFocus();
        this.configurarperfil();
        this.ventanaCrearYModUsuario.setLocationRelativeTo(null);
        this.ventanaCrearYModUsuario.setTitle(TITULO_MODIFICAR);
        this.usuarioNuevo = false;
        this.correoUsuarioAModificar = correoUsuarioSeleccionado;
        this.ventanaCrearYModUsuario.setVisible(true);
    }

    private void configurarperfil() {
        ModeloComboPerfil modelo = new ModeloComboPerfil();
        this.ventanaCrearYModUsuario.verComboPerfiles().setModel(modelo);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

        String correo = ventanaCrearYModUsuario.verTextocorreo().getText().trim();

        String apellido = ventanaCrearYModUsuario.verTextoapellido().getText().trim();

        String nombre = ventanaCrearYModUsuario.verTextonombre().getText().trim();

        char[] clave = ventanaCrearYModUsuario.verContraseñatexto().getPassword();

        char[] claveRepetida = ventanaCrearYModUsuario.verContraseñareptexto().getPassword();

        //controlar si la siguiente linea es correcta
        Perfil perfil = ((ModeloComboPerfil) ventanaCrearYModUsuario.verComboPerfiles().getModel()).obtenerPerfil();

        IGestorUsuarios gu = GestorUsuarios.instanciar();

        if (usuarioNuevo){
            if(gu.verificarDatos( correo,apellido,nombre,perfil,new String(clave), new String(claveRepetida)).equals(VALIDACION_EXITO)){
                gu.crearUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida));}
            else{
                if(gu.verificarDatos( correo,apellido,nombre,perfil,new String(clave), new String(claveRepetida)).equals(ERROR_CLAVES)){
                    String mensajecontraseñanocoinciden = "Las contraseñas no coinciden, por favor controlar.";
                    JOptionPane.showMessageDialog(this.ventanaCrearYModUsuario, mensajecontraseñanocoinciden, "Error", JOptionPane.INFORMATION_MESSAGE);}
                else{
                    String mensajeDatosInvalidos = "Los datos no son válidos. Por favor revise los campos.";
                JOptionPane.showMessageDialog(this.ventanaCrearYModUsuario, mensajeDatosInvalidos, "Error", JOptionPane.INFORMATION_MESSAGE);}}}
        
    else {
            // ¿Debería desahabilitar para seleccionar Perfil?
            if(gu.verificarDatos( correo,apellido,nombre,perfil,new String(clave), new String(claveRepetida)).equals(VALIDACION_EXITO)){
            String resultadoOperacion = gu.modificarUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida));
           
            if (!resultadoOperacion.equals(EXITO)) {
                String mensajeDatosInvalidos = "Los datos no son válidos. Por favor revise los campos.";
                JOptionPane.showMessageDialog(this.ventanaCrearYModUsuario, mensajeDatosInvalidos, "Error", JOptionPane.INFORMATION_MESSAGE);}
            }
            else{ 
                 if(gu.verificarDatos( correo,apellido,nombre,perfil,new String(clave), new String(claveRepetida)).equals(ERROR_CLAVES)){
                    String mensajecontraseñanocoinciden = "Las contraseñas no coinciden, por favor controlar.";
                    JOptionPane.showMessageDialog(this.ventanaCrearYModUsuario, mensajecontraseñanocoinciden, "Error", JOptionPane.INFORMATION_MESSAGE);}
            }
        }
        
        this.ventanaCrearYModUsuario.dispose();
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
            this.ventanaCrearYModUsuario.verTextoapellido().requestFocus();
        }
    }
    
    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
//        char c = evt.getKeyChar();
        
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verTextonombre().requestFocus();
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verContraseñatexto().requestFocus();
        }
    }


    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.ventanaCrearYModUsuario.verContraseñareptexto().requestFocus();
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
