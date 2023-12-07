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
       return 1;
    }
    
    @Override
    public int getColumnCount() {
        return 1;
    }
    
    @Override
    public Object getValueAt(int fila, int columna) {
        return null;
    }
    
    @Override
    public String getColumnName(int columna) {
        return null;
    }
}
