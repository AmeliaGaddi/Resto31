
package entidades;

import java.time.LocalDate;


public class Pedido {
    
    private int idPedido;
    private int idMesa;
    private String nombreMesero;
//    private LocalDate fechaHora;
    private LocalDate fechaHora;
    private double importe;
    private boolean cobrada;
    
    public Pedido() {
    }

    public Pedido(int idPedido, int idMesa, String nombreMesero, LocalDate fechaHora, double importe, boolean cobrada) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public Pedido(int idPedido, int idMesa, String nombreMesero, double importe, boolean cobrada) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.nombreMesero = nombreMesero;
        this.importe = importe;
        this.cobrada = cobrada;
    }
    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isCobrada() {
        return cobrada;
    }

    public void setCobrada(boolean cobrada) {
        this.cobrada = cobrada;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFechaHora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}