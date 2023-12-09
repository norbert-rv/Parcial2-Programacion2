/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTabla;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tomascabrerabellomo
 */
public class ControladorUsuarios implements IControladorUsuarios {

    private VentanaUsuarios ventanaUsuarios;
    IGestorUsuarios gu = GestorUsuarios.instanciar();

    // patrón singleton
    private static ControladorUsuarios controladorUsuarios;

    private ControladorUsuarios(java.awt.Frame ventanaPadre) {
        this.ventanaUsuarios = new VentanaUsuarios(ventanaPadre, true, this);
        this.ventanaUsuarios.verTablaUsuarios().setModel(new ModeloTabla());
        this.ventanaUsuarios.setLocationRelativeTo(null);
        this.ventanaUsuarios.setTitle(TITULO);
        this.ventanaUsuarios.setVisible(true);
    }

    public static ControladorUsuarios instanciar(java.awt.Frame ventanaPadre) {
        if (controladorUsuarios == null) {
            controladorUsuarios = new ControladorUsuarios(ventanaPadre);
        }

        return controladorUsuarios;
    }
    // fin patrón singleton

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controlador = new ControladorAMUsuario(this.ventanaUsuarios);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int filaSeleccionada = this.ventanaUsuarios.verTablaUsuarios().getSelectedRow();

        String correoFilaSeleccionada = gu.verUsuarios().get(filaSeleccionada).verCorreo();

        IControladorAMUsuario controlador = new ControladorAMUsuario(this.ventanaUsuarios, correoFilaSeleccionada);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int filaSeleccionada = this.ventanaUsuarios.verTablaUsuarios().getSelectedRow();
        Usuario usuarioBorrar = gu.verUsuarios().get(filaSeleccionada);

        int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaUsuarios, "¿Desea borrar el usuario seleccionado? Se perderán todos sus datos.", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");

        if (opcionEscogida == JOptionPane.YES_OPTION) {
            gu.borrarUsuario(usuarioBorrar);
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        // si la ventana vuelve a obtener el foco, se actualizan los datos de la tabla
        this.actualizarDatosTabla();
    }

    private void actualizarDatosTabla() {
        AbstractTableModel modeloTablaUsuarios = (AbstractTableModel) this.ventanaUsuarios.verTablaUsuarios().getModel();
        ((ModeloTabla) modeloTablaUsuarios).actualizarDatosTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        // por ahora solo cerrar la ventana. ¿Hay que hacer algo más?
        this.ventanaUsuarios.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        
        /*
        Funcionalidad para que al estar la casilla de texto vacia en la casilla de apellido
        se vuelvan a mostrar todos los usuarios en la tabla.
        */
        
//        String apellidoNulo = this.ventanaUsuarios.verTxtApellido().getText();
//        
//        if(apellidoNulo == null) {
//            AbstractTableModel modeloTablaUsuarios = (AbstractTableModel) this.ventanaUsuarios.verTablaUsuarios().getModel();
//            ((ModeloTabla) modeloTablaUsuarios).actualizarDatosTabla();
//        }
        
        /*
        Funcionalidad para que al presionar Enter se ejecute la funcionalidad Buscar.
        */
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            this.btnBuscarClic(null);
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {

        String apellidoBuscar = this.ventanaUsuarios.verTxtApellido().getText().trim();
        
        /*
        De esta forma, cuando vuelvo a borrar el cuadro de búsqueda y aprieto Borrar,
        se muestran todos los usuarios nuevamente.
        */
        if (apellidoBuscar != null) {
            IGestorUsuarios gu = GestorUsuarios.instanciar();
            
            List<Usuario> coincidenciasApellido = gu.buscarUsuarios(apellidoBuscar);

            AbstractTableModel modeloTablaUsuarios = (AbstractTableModel) this.ventanaUsuarios.verTablaUsuarios().getModel();
            ((ModeloTabla) modeloTablaUsuarios).actualizarDatosTabla(coincidenciasApellido);
        } else {
            this.actualizarDatosTabla();
        }
    }
}
