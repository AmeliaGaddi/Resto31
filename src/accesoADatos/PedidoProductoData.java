
package accesoADatos;

import entidades.Pedido;
import entidades.PedidoProducto;
import entidades.Producto;
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

public class PedidoProductoData {
    
    private Connection con = null;
    
    public PedidoProductoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarPedidoProducto(PedidoProducto pp){ 
    
    String sql = "INSERT INTO pedidoproducto (idPedido, idProducto, cantidad) VALUES (?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1, pp.getIdPedido());
            ps.setInt(2, pp.getIdProducto());
            ps.setInt(3, pp.getCantidad());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
              //pp.setIdPedidoProd(rs.getInt("idPedidoProducto"));
                JOptionPane.showMessageDialog(null, "PedidoProducto añadido con éxito.");
                //JOptionPane.showMessageDialog(null, "Id del PP es: "+ rs.getNString("idPedidoprod"));
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla PedidoProducto: " + ex.getMessage());
            
        }
    }
    
    public void modificarPedidoProducto(PedidoProducto pP){ 
       String sql = "UPDATE pedidoproducto SET idPedido = ?, idProducto = ?, cantidad= ? WHERE idPedidoProducto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, pP.getIdPedido());
            ps.setInt(2, pP.getIdProducto());
            ps.setInt(3, pP.getCantidad());
            ps.setInt(6, pP.getIdPedidoProd());
            
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                JOptionPane.showMessageDialog(null, "PedidoProducto modificado.");
            } else {
                JOptionPane.showMessageDialog(null, "El PedidoProducto no encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedidoproducto: " + ex.getMessage());
        }
        }
    
    public void borrarPedidoProducto(int idPedidoProducto){
    try {
            String sql = "DELETE FROM pedido WHERE idPedidoProducto = ?";
              
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedidoProducto);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el pedidoProducto.");
            } else{
                JOptionPane.showMessageDialog(null, "No se encontró el pedidoProducto");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedidoproducto");
        }
    }

    //           ****** LISTAS *******
    public List<Pedido> listarPedidoporMesero(String nombre){ // Listar pedidos atendidos por mesero
      List<Pedido> pedido = new ArrayList<Pedido>();
      String sql = "SELECT * FROM pedido WHERE nombreMesero = ?";
      
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdPedido(rs.getInt("idPedido"));
            p.setIdMesa(rs.getInt("idMesa"));    
            p.setNombreMesero(rs.getString("nombreMsero"));
//            p.setFechaHora(rs.getTimestamp("fecha_hora"));
            p.setImporte(rs.getInt("importe"));
            p.setCobrada(rs.getBoolean("cobrada"));
            pedido.add(p);
             }
              System.out.println("Exito");
            ps.close();
        } catch (SQLException ex) {
             ex.getMessage();
        }
        return pedido;
    }

    
    public List<Pedido> listarPedidoCobroMeseroDia(String nombre){//listar pedidos que cobro un mesero en particular 
        List<Pedido> pedido = new ArrayList<>();
      String sql = "SELECT * FROM pedido WHERE nombreMesero = ? and cobrada = 1";
      
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdPedido(rs.getInt("idPedido"));
            p.setIdMesa(rs.getInt("idMesa"));    
            p.setNombreMesero(rs.getString("nombreMesero"));
//            p.setFechaHora(rs.getTimestamp("fecha_hora"));
            p.setImporte(rs.getInt("importe"));
            p.setCobrada(rs.getBoolean("cobrada"));
            pedido.add(p);
             }
            ps.close();
        } catch (SQLException ex) {
           ex.getMessage();
        }
        return pedido;
    }
    
    public List<Pedido> listarPedidoMesa(int id){//ALTERNATIVA (Lista pedidos por mesa)
        List<Pedido> pedido = new ArrayList<>();
      String sql = "SELECT * FROM pedido WHERE idMesa= ? ";
      
       try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdPedido(rs.getInt("idPedido"));
            p.setIdMesa(rs.getInt("idMesa"));    
            p.setNombreMesero(rs.getString("nombreMesero"));
//            p.setFechaHora(rs.getTimestamp("fecha_hora"));
            p.setImporte(rs.getInt("importe"));
            p.setCobrada(rs.getBoolean("cobrada"));
            pedido.add(p);
             }
            ps.close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return pedido;
    }

 public List<Pedido> listarPedidoTotal() {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setNombreMesero(rs.getString("nombreMesero"));
//                p.setFechaHora(rs.getTimestamp("fecha_hora"));
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedidos.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido: " + ex.getMessage());
        }
        return pedidos;
    }
}


