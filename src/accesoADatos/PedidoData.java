
package accesoADatos;

import entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoData {
    
    private Connection con = null;
    
    public PedidoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarPedido(Pedido pedi){ 
    
    String sql = "INSERT INTO pedido (idMesa,	nombreMesero, fechaHora, importe, cobrada) VALUES (?, ?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            
            ps.setInt(1, pedi.getIdMesa());
            ps.setString(2, pedi.getNombreMesero());
            ps.setDate(3, Date.valueOf(pedi.getFechaHora()));
            ps.setDouble(4, pedi.getImporte());
            ps.setBoolean(5, pedi.isCobrada());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedi.setIdPedido(rs.getInt("idPedido"));
                JOptionPane.showMessageDialog(null, "Pedido añadido con éxito.");
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido: " + ex.getMessage());
            
        }
    }
    
    public void borrarPedido(int idPedido){
    try {
            String sql = "DELETE FROM pedido WHERE idPedido = ?";
              
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el pedido.");
            } else{
                JOptionPane.showMessageDialog(null, "No se encontró el pedido");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido");
        }
    }
    
   public void modificarPedido(Pedido pedi){ 
       String sql = "UPDATE pedido SET idMesa = ?, nombreMesero = ?, fechaHora= ?, importe = ?, cobrada = ? WHERE idPedido = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, pedi.getIdMesa());
            ps.setString(2, pedi.getNombreMesero());
            ps.setDate(3, Date.valueOf(pedi.getFechaHora()));
            ps.setDouble(4, pedi.getImporte());
            ps.setBoolean(5, pedi.isCobrada());
            ps.setInt(6, pedi.getIdPedido());
            
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                JOptionPane.showMessageDialog(null, "Pedido modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Pedido no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido: " + ex.getMessage());
        }
        }

      public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE idMesa = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
              pedido.setIdMesa(rs.getInt("idMesa"));
              pedido.setNombreMesero(rs.getString("nombreMesero"));
              pedido.setFechaHora(LocalDate.parse("fechaHora"));
              pedido.setImporte(rs.getInt("importe"));
              pedido.setCobrada(rs.getBoolean("estado"));
              pedidos.add(pedido);

           }
           ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Pedido: " + ex.getMessage());
       }
       return pedidos;
    }

public class Mesa{
    private List<Pedido> pedidos;
    private String estado;

    public Mesa() {
        this.pedidos = new ArrayList<>();
        this.estado = "libre";
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void quitarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    public void listarPedidos() {
        for (Pedido pedido : this.pedidos) {
//            System.out.println(pedido.getProducto());
        }
    }

//    public double listarIngresosFecha(Date fecha) {
//        double ingresos = 0;
//        for (Pedido pedido : this.pedidos) {
//            if (pedido.getFechaHora().equals(fecha) && pedido.isCobrada()== 1) {
//                ingresos += pedido.calcularSubtotal();
//            }
//        }
//        return ingresos;
//    }
//
//    public double listarIngresosMeseroDia(String mesero, Date fecha) {
//        double ingresos = 0;
//        for (Pedido pedido : this.pedidos) {
//            if (pedido.getNombreMesero().equals(mesero) && pedido.getFechaHora().equals(fecha) && pedido.isCobrada()== 1) {
//                ingresos += pedido.calcularSubtotal();
//            }
//        }
//        return ingresos;
//    }
}


}
    
