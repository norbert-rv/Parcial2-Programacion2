/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import java.awt.event.ActionEvent;
import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.controladores.ControladorUsuarios;

/**
 *
 * @author root
 */
public class ControladorPrincipal implements IControladorPrincipal {

    private VentanaPrincipal ventanaPrincipal;

    public ControladorPrincipal() {
        this.ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.setTitle(TITULO);
        ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        ControladorPrincipal cp = new ControladorPrincipal();
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios controladorUsuarios = new ControladorUsuarios(this.ventanaPrincipal);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        // utilizo un confirm dialog
        int opcion = JOptionPane.showConfirmDialog(this.ventanaPrincipal, "¿Seguro que desea salir de la aplicación?", "Confirmar salir", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            this.ventanaPrincipal.dispose();
        }
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {
        // NO IMPLEMENTADO
    }

    @Override
    public void btnPedidosClic(ActionEvent evt) {
        // NO IMPLEMENTADO
    }

}
