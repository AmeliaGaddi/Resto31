
package entidades;


public class Mesa {
   private int idMesa;
   private int capacidad;
   private boolean estado;
   private int numero;

    public Mesa() {
    }

    public Mesa(int idMesa, int capacidad, boolean estado, int idPedido) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.numero = idPedido;
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

    public int getnumero() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Mesa{" + "idMesa=" + idMesa + ", capacidad=" + capacidad + ", estado=" + estado + ", numero=" + numero + '}';
    }

   
}
