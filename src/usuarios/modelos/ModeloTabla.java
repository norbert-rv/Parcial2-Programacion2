/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author norbert
 */
public class ModeloTabla extends AbstractTableModel {

    // IMPLEMENTAR
    
    @Override
    public int getRowCount() {
       return 3;
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        return null;
    }
    
    @Override
    public String getColumnName(int columna) {
        return null;
    }
    
    // VER CUALES HAY QUE IMPLEMENTAR
    
//    @Override
//    public boolean isCellEditable(int fila, int columna) {
//        return true;
//    }
//    
//    @Override
//    public void setValueAt(Object unValor, int fila, int columna) {
//        
//    }
//    
//    @Override
//    public Class<> getColumnClass(int columna) {
//        
//    }
}
