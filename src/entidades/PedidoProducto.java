
package entidades;

public class PedidoProducto {
    private int idPedidoProd;
    private int idPedido;
    private int idProducto;
    private int cantidad;

    public PedidoProducto() {
    }

    public PedidoProducto(int idPedidoProd, int idPedido, int idProducto, int cantidad) {
        this.idPedidoProd = idPedidoProd;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdPedidoProd() {
        return idPedidoProd;
    }

    public void setIdPedidoProd(int idPedidoProd) {
        this.idPedidoProd = idPedidoProd;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "PedidoProducto{" + "idPedidoProd=" + idPedidoProd + ", idPedido=" + idPedido + ", idProducto=" + idProducto + ", cantidad=" + cantidad + '}';
    }
    
    
}
