
package entidades;

import java.time.LocalDate;

public class Reserva {
    private int idCliente;
    private int idMesa;
    private String nombre;
    private LocalDate fecha;
    private LocalDate hora;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(int idCliente, int idMesa, String nombre, LocalDate fecha, LocalDate hora, boolean estado) {
        this.idCliente = idCliente;
        this.idMesa = idMesa;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idCliente=" + idCliente + ", idMesa=" + idMesa + ", nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + '}';
    }
    
    
    
}
