/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
public enum Categoria {
    ENTRADA, PLATOPRINCIPAL, POSTRE;
    
    @Override
    public String toString(){
        return "Categoría: " + this.name();
    }
}
