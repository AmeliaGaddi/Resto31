
package accesoADatos;

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
    
    String sql = "INSERT INTO pedidoproducto (idPedidoProducto,	idPedido, idProducto, cantidad) VALUES (?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1,pp.getIdPedidoProd());
            ps.setInt(2, pp.getIdPedido());
            ps.setInt(3, pp.getIdProducto());
            ps.setInt(4, pp.getCantidad());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
//                produ.setIdProducto(rs.getInt("idProducto"));
                JOptionPane.showMessageDialog(null, "PedidoProducto añadido con éxito.");
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
    
    public void borrarPedido(int idPedidoProducto){
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

}


