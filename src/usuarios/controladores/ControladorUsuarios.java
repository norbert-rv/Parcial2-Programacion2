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
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTabla;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tomascabrerabellomo
 */
public class ControladorUsuarios implements IControladorUsuarios {

    private VentanaUsuarios ventanaUsuarios;
    private static final String USUARIO_NO_SELECCIONADO = "Debe seleccionar un usuario de la tabla.";

    public ControladorUsuarios(java.awt.Frame ventanaPadre) {
        this.ventanaUsuarios = new VentanaUsuarios(ventanaPadre, true, this);
        this.ventanaUsuarios.verTablaUsuarios().setModel(new ModeloTabla());
        this.ventanaUsuarios.setLocationRelativeTo(null);
        this.ventanaUsuarios.setTitle(TITULO);
        this.ventanaUsuarios.setVisible(true);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controlador = new ControladorAMUsuario(this.ventanaUsuarios);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int filaSeleccionada = this.ventanaUsuarios.verTablaUsuarios().getSelectedRow();

        IGestorUsuarios gu = GestorUsuarios.instanciar();

        try {
            String correoFilaSeleccionada = gu.verUsuarios().get(filaSeleccionada).verCorreo();

            Usuario usuario = gu.verUsuarios().get(filaSeleccionada);
            Perfil perfilUsuarioSeleccionado;

            if (usuario.getClass().getSimpleName().equalsIgnoreCase(Perfil.CLIENTE.toString())) {
                perfilUsuarioSeleccionado = Perfil.CLIENTE;
            } else if (usuario.getClass().getSimpleName().equalsIgnoreCase(Perfil.EMPLEADO.toString())) {
                perfilUsuarioSeleccionado = Perfil.EMPLEADO;
            } else {
                perfilUsuarioSeleccionado = Perfil.ENCARGADO;
            }

            IControladorAMUsuario controlador = new ControladorAMUsuario(this.ventanaUsuarios, correoFilaSeleccionada, perfilUsuarioSeleccionado);
        } catch (IndexOutOfBoundsException iob) {
            JOptionPane.showMessageDialog(this.ventanaUsuarios, USUARIO_NO_SELECCIONADO, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int filaSeleccionada = this.ventanaUsuarios.verTablaUsuarios().getSelectedRow();

        IGestorUsuarios gu = GestorUsuarios.instanciar();

        try {
            Usuario usuarioABorrar = gu.verUsuarios().get(filaSeleccionada);
            int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaUsuarios, CONFIRMACION, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");

            if (opcionEscogida == JOptionPane.YES_OPTION) {
                gu.borrarUsuario(usuarioABorrar);
            }
        } catch (IndexOutOfBoundsException iob) {
            JOptionPane.showMessageDialog(this.ventanaUsuarios, USUARIO_NO_SELECCIONADO, "Error", JOptionPane.INFORMATION_MESSAGE);
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
        De esta forma, cuando vuelvo a borrar el cuadro de búsqueda y aprieto Buscar,
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
