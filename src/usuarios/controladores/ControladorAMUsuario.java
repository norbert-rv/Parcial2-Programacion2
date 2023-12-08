/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
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

        String apellido = ventanaCrearYModUsuario.verTextoapellido().getText().trim();

        String nombre = ventanaCrearYModUsuario.verTextonombre().getText().trim();

        char[] clave = ventanaCrearYModUsuario.verContraseñatexto().getPassword();

        char[] claveRepetida = ventanaCrearYModUsuario.verContraseñareptexto().getPassword();

        //controlar si la siguiente linea es correcta
        Perfil perfil = ((ModeloComboPerfil) ventanaCrearYModUsuario.verComboPerfiles().getModel()).obtenerPerfil();

        IGestorUsuarios gu = GestorUsuarios.instanciar();

        if (usuarioNuevo) {
            String correo = ventanaCrearYModUsuario.verTextocorreo().getText().trim();

//        System.out.println(gu.crearUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida)));
            gu.crearUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida));

            this.ventanaCrearYModUsuario.dispose();
        } else {
            // aquí modifico el usuario utilizando el correo ingresado en el segundo constructor
            String resultadoOperacion = gu.modificarUsuario(correoUsuarioAModificar, apellido, nombre, perfil, new String(clave), new String(claveRepetida));
            
            if (!resultadoOperacion.equals(VALIDACION_EXITO)) {
                String mensajeDatosInvalidos = "Los datos no son válidos. Por favor ingrese información válida.";
                JOptionPane.showMessageDialog(this.ventanaCrearYModUsuario, mensajeDatosInvalidos, "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {

        int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaCrearYModUsuario, "¿Desea cancelar la carga del usuario? Se perderán los cambios no guardados.", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventanaCrearYModUsuario.dispose();
        }
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
    }

}
