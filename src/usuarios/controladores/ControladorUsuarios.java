/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import interfaces.IControladorUsuarios;
import javax.swing.table.AbstractTableModel;
import usuarios.modelos.ModeloTabla;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tomascabrerabellomo
 */
public class ControladorUsuarios implements IControladorUsuarios{

    private VentanaUsuarios ventanaUsuarios;
    
    // patrón singleton
    private static ControladorUsuarios controladorUsuarios;
    
    private ControladorUsuarios(java.awt.Frame ventanaPadre) {
        this.ventanaUsuarios = new VentanaUsuarios(ventanaPadre, true, this);
        
        // prueba
//        this.ventanaUsuarios.verTablaUsuarios().setModel(new ModeloTabla());
    }
    
    public static ControladorUsuarios instanciar(java.awt.Frame ventanaPadre) {
        if(controladorUsuarios == null) {
            controladorUsuarios = new ControladorUsuarios(ventanaPadre);
        }
        
        return controladorUsuarios;
    }
    // fin patrón singleton

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
        // si la ventana vuelve a obtener el foco, se actualizan los datos de la tabla
//        this.actualizarDatosTabla();
    }
    
    private void actualizarDatosTabla() {
        AbstractTableModel modeloTablaUsuarios = (AbstractTableModel)this.ventanaUsuarios.verTablaUsuarios().getModel();
        ((ModeloTabla)modeloTablaUsuarios).actualizarDatosTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        // por ahora solo cerrar la ventana. ¿Hay que hacer algo más?
        // ¿Qué pasa que no se cierra?
        this.ventanaUsuarios.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            this.btnBuscarClic(null);
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
    }
    
}
