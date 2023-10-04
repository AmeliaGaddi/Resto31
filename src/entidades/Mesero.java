
package entidades;

public class Mesero {
    private int idMesero;
    private int idPedido;

    public Mesero() {
    }

    public Mesero(int idMesero, int idPedido) {
        this.idMesero = idMesero;
        this.idPedido = idPedido;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Mesero{" + "idMesero=" + idMesero + ", idPedido=" + idPedido + '}';
    }
    
    
    
}
