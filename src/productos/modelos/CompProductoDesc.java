/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.Comparator;

/**
 *
 * @author estudiante
 */
public class CompProductoDesc implements Comparator<Producto> {

    public int compare(Producto t, Producto t1) {
        return t.toString().compareTo(t1.toString());
    }

}
