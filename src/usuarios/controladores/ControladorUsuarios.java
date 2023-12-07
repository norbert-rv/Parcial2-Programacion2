/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import interfaces.IControladorUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tomascabrerabellomo
 */
public class ControladorUsuarios implements IControladorUsuarios{

    private VentanaUsuarios ventanaUsuarios;
    
    public ControladorUsuarios(java.awt.Frame ventanaPadre) {
        this.ventanaUsuarios = new VentanaUsuarios(ventanaPadre, true, this);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        // por ahora solo cerrar la ventana. ¿Hay que hacer algo más?
        // ¿Qué pasa que no se cierra?
        this.ventanaUsuarios.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
    }
    
}
