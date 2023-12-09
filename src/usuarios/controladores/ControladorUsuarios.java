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
import static interfaces.IGestorUsuarios.USUARIO_INEXISTENTE;
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
public class ControladorUsuarios implements IControladorUsuarios{

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
        IControladorAMUsuario controlador = new ControladorAMUsuario(this.ventanaUsuarios);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        // por ahora toma si seleccionas la casilla de correo, hay que completar para que sea la fila y tome el correo
        int filaSeleccionada = this.ventanaUsuarios.verTablaUsuarios().getSelectedRow();
        
        String correo = gu.verUsuarios().get(filaSeleccionada ).verCorreo();
        
        IControladorAMUsuario controlador = new ControladorAMUsuario(this.ventanaUsuarios, correo);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int filaSeleccionada = this.ventanaUsuarios.verTablaUsuarios().getSelectedRow();
        Usuario u1 = gu.verUsuarios().get(filaSeleccionada);
        
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaUsuarios, "¿Desea borrar la persona seleccionada? Se perderán todos sus datos", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            gu.verUsuarios().remove(u1);      
        }}

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        // si la ventana vuelve a obtener el foco, se actualizan los datos de la tabla
        this.actualizarDatosTabla();
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
       
//        List<Usuario> coincidenciasapellido = new ArrayList<>();
//        // Esta verificacion ahorra recorrer el ArrayList productos innecesariamente
////        if (ventanaUsuarios.verTxtApellido() == null) {
////            return coincidenciasapellido;
////        }
//               GestorUsuarios.verUsuarios() usuarios = new ArrayList();
//        for (Usuario p : verUsuarios()) {
//            if (p.verApellido().toLowerCase().contains(ventanaUsuarios.verTxtApellido().toString())) {
//                coincidenciasapellido.add(p);
//            }
//        }
//
//        Collections.sort(coincidenciasapellido, new CompUsuarioApYNom());
//
//        return coincidenciasapellido;
//    }
    
}}
