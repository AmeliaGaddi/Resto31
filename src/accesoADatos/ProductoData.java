
package accesoADatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ProductoData {
    private Connection con = null;
    
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
    
   public void  altaProducto(Producto producto){
       ProductoData pD = new ProductoData();
       pD.altaProducto(producto);
       
       
    }
       
   
   
   public void  bajaProducto(){
       ProductoData pD = new ProductoData();
       pD.bajaProducto();
       
   }
   public void modificarProducto(){
       ProductoData pD = new ProductoData();
       pD.modificarProducto();
       
   }
           

        
        
    public Producto consultarProducto(String nombre) {
        

Producto produ = null;
        String sql = "SELECT idProducto, nombre, cantidad, precio FROM producto WHERE nombre = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                produ = new Producto();
                produ.setIdProducto(rs.getInt("IdProducto"));
                produ.setNombre(rs.getString("nombre"));
                produ.setCantidad(rs.getInt("cantidad"));
                produ.setPrecio(rs.getDouble("precio"));
            
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno: " + ex.getMessage());
        }
        return produ;
    
    }
    
}
