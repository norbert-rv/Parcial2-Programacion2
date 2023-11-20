/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class GestorPedidos implements IGestorPedidos {

    ArrayList<Pedido> pedidos = new ArrayList<>();

    private static GestorPedidos gestor;

    private GestorPedidos() {

    }

    public static GestorPedidos crearGestorPedidos() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }

        return gestor;
    }

    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {

        if (!this.validarDatos(fecha, hora, productosDelPedido, cliente).equalsIgnoreCase(VALIDACION_EXITO)) {
            return this.validarDatos(fecha, hora, productosDelPedido, cliente);
        }

        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);

        Pedido pedido = new Pedido(pedidos.size() + 1, fechaYHora, productosDelPedido, cliente);

        cliente.agregarPedido(pedido);

        return EXITO;
    }

    public String cambiarEstado(Pedido pedidoAModificar) {
        if (!pedidos.contains(pedidoAModificar)) {
            return PEDIDO_INEXISTENTE;
        } else {

            Pedido pedido = pedidos.get(pedidos.indexOf(pedidoAModificar));

            if (pedido.verEstado().equals(Estado.CREADO)) {
                pedido.asignarEstado(Estado.PROCESANDO);
            } else if (pedido.verEstado().equals(Estado.PROCESANDO)) {
                pedido.asignarEstado(Estado.ENTREGADO);
            }

            return EXITO;

        }
    }

    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    public boolean hayPedidosConEsteCliente(Cliente cliente) {

        for (Pedido p : pedidos) {
            if (p.verCliente().equals(cliente)) {
                return true;
            }
        }

        return false;
    }

    public boolean hayPedidosConEsteProducto(Producto producto) {

        for (Pedido p : pedidos) {
            ArrayList<ProductoDelPedido> pdp = p.verProductoDelPedido();

            for (ProductoDelPedido prodDelPedido : pdp) {
                if (prodDelPedido.verProducto().equals(producto)) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean existeEstePedido(Pedido pedido) {

        return pedidos.contains(pedido);

    }

    public Pedido obtenerPedido(Integer numero) {

        for (Pedido p : pedidos) {
            if (p.verNumero() == numero) {
                return p;
            }
        }

        return null;

    }

    private String validarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {

        if (fecha == null) {
            return ERROR_FECHA;
        }

        if (hora == null) {
            return ERROR_HORA;
        }

        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }

        if (cliente == null) {
            return ERROR_CLIENTE;
        }

        return VALIDACION_EXITO;

    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        
        if(this.existeEstePedido(pedido)){
            pedido.verCliente().cancelarPedido(pedido);
            
            return EXITO;
        }
        else{
            return PEDIDO_INEXISTENTE;
        }
            
    }

}
