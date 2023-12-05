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
public interface IControladorUsuarios {
    public static final String TITULO = "Usuarios";
    public static final String CONFIRMACION = "¿Desea borrar el usuario especificado?";
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Nuevo
     * @param evt evento
     */                        
    public void btnNuevoClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Modificar
     * @param evt evento
     */                        
    public void btnModificarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar
     * @param evt evento
     */                        
    public void btnBorrarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando la ventana obtenga el foco
     * @param evt evento
     */
    public void ventanaObtenerFoco(WindowEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Volver
     * @param evt evento
    */                        
    public void btnVolverClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtApellido
     * Permite filtrar los usuarios a medida que se escribe en el campo de texto txtApellido
     * @param evt evento
    */
    public void txtApellidoPresionarTecla(KeyEvent evt);
    
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Buscar
     * Permite filtrar los usuarios según lo escrito en el campo de texto txtApellido
     * @param evt evento
    */                        
    public void btnBuscarClic(ActionEvent evt);
}

