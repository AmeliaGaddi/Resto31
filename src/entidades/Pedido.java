
package entidades;


public class Pedido {
    
    private int idPedido;
    private int idProducto;
    private int idMesero;
    private int idMesa;

    public Pedido() {
    }

    public Pedido(int idPedido, int idProducto, int idMesero, int idMesa) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.idMesero = idMesero;
        this.idMesa = idMesa;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", idProducto=" + idProducto + ", idMesero=" + idMesero + ", idMesa=" + idMesa + '}';
    }
    
    

   
}

