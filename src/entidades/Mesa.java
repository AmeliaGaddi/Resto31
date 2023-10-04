
package entidades;


public class Mesa {
   private int idMesa;
   private int capacidad;
   private boolean estado;
   private int idPedido;

    public Mesa() {
    }

    public Mesa(int idMesa, int capacidad, boolean estado, int idPedido) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", capacidad=" + capacidad + ", estado=" + estado + ", idPedido=" + idPedido + '}';
    }

   
}
