/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
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
public class ControladorAMUsuario implements IControladorAMUsuario{
    private VentanaCrearYModificarUsuario ventanaCrearYModUsuario;
    
    // constructor para ControladorAMUsuario
    public ControladorAMUsuario(java.awt.Dialog ventanaPadre) {
        this.ventanaCrearYModUsuario = new VentanaCrearYModificarUsuario(ventanaPadre, true, this);
        this.configurarperfil();
        this.ventanaCrearYModUsuario.setLocationRelativeTo(null);
        this.ventanaCrearYModUsuario.setTitle(TITULO_NUEVO);
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

        System.out.println(gu.crearUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRepetida)));
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
