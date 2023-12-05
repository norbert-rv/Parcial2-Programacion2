/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
/**
 *
 * @author tomascabrerabellomo
 */
public interface IControladorAMUsuario {
    public static final String TITULO_NUEVO = "Nuevo usuario"; 
    public static final String TITULO_MODIFICAR = "Modificar usuario";
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Guardar
     * @param evt evento
     */                        
    public void btnGuardarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     * @param evt evento
     */                        
    public void btnCancelarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtApellido
     * @param evt evento
     */
    public void txtApellidoPresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtNombre
     * @param evt evento
     */
    public void txtNombrePresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtDocumento
     * @param evt evento
     */
    public void txtCorreoPresionarTecla(KeyEvent evt);        
        
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo passClave
     * @param evt evento
     */
    public void passClavePresionarTecla(KeyEvent evt); 
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo passRepetirClave
     * @param evt evento
     */
    public void passClaveRepetidaPresionarTecla(KeyEvent evt);
}
