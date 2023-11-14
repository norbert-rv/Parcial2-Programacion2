/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

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
public class GestorPedidos {

    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";

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

        // Y el numero de pedido??
        Pedido pedido = new Pedido(0, fechaYHora, productosDelPedido, cliente);

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

}
