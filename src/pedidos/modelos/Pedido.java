/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = Estado.CREADO; // todo pedido inicia en CREADO
        this.cliente = cliente;
    }
    
    
    public void mostrar(){
//        // formato para la Fecha y para la Hora
//        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("hh:mm");
        
        System.out.println("Nro: " + numero
                + "\nFecha: " + this.fechaYHora.format(this.formatoFecha())
                + "\tHora: " + this.fechaYHora.format(this.formatoHora())
                + "\nCliente: " + cliente.obtenerApellido() + ", " + cliente.obtenerNombre()
                + "\nEstado: " + this.estado.name());
    }
    
    private DateTimeFormatter formatoFecha() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    private DateTimeFormatter formatoHora() {
        return DateTimeFormatter.ofPattern("hh:mm");
    }
    
    public int obtenerNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime obtenerFechaYHora() {
        return fechaYHora;
    }

    public LocalDate obtenerFecha(){
        return fechaYHora.toLocalDate();
    }
    
    public LocalTime obtenerHora(){
        return fechaYHora.toLocalTime();
    }
    
    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
    public void asignarCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
