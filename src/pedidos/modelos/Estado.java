/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author estudiante
 */
public enum Estado {
    CREADO, SOLICITADO, PROCESANDO, ENTREGADO;
    
    @Override
    public String toString(){
        return "Estado: " + this.name();
    }
}
