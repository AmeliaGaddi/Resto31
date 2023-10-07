
package accesoADatos;

import entidades.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class PedidoData {
    
    private Connection con = null;
    
    public PedidoData(){
        con = Conexion.getConexion();
    }
    
    public void agregarPedido(Pedido pedi){ 
    
    String sql = "INSERT INTO pedido (idPedido,	idMesa,	nombreMesero, fechaHora, importe, cobrada) VALUES (?, ?, ?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1,pedi.getIdPedido());
            ps.setInt(2, pedi.getIdMesa());
            ps.setString(3, pedi.getNombreMesero());
            ps.setDate(4, Date.valueOf(pedi.getFechaHora()));
            ps.setDouble(5, pedi.getImporte());
            ps.setBoolean(6, pedi.isCobrada());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
//                produ.setIdProducto(rs.getInt("idProducto"));
                JOptionPane.showMessageDialog(null, "Pedido añadido con éxito.");
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Productos: " + ex.getMessage());
            
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
    }
