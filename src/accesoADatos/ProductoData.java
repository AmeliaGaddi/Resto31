
package accesoADatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {

    public static void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection con = null;
    
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
     public void agregarproducto(Producto produ){ 
    
    String sql = "INSERT INTO producto (nombre, precio,cantidad , estado) VALUES (?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setString(1,produ.getNombre());
            ps.setDouble(2, produ.getPrecio());
            ps.setInt(3, produ.getCantidad());
            ps.setBoolean(4,produ.isEstado());
           
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                produ.setIdProducto(rs.getInt("idProducto"));
                JOptionPane.showMessageDialog(null, "Producto añadido con éxito.");
                JOptionPane.showMessageDialog(null, "Id nuevo Producto: "+ rs.getInt("idProducto"));
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Productos: " + ex.getMessage());
            
        }
    }
     
     public void eliminarProducto(int id){
    try {
            String sql = "UPDATE producto SET estado = 0 WHERE idProducto = ?";
//              String sql = "DELETE FROM producto WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el producto.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto");
        }
    }
    
     public void modificarProducto(Producto produ){ 
       String sql = "UPDATE producto SET nombre = ?, precio = ?, cantidad = ?, estado= ? WHERE idProducto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, produ.getNombre());
            ps.setDouble(2, produ.getPrecio());
            ps.setInt(3, produ.getCantidad());
            ps.setBoolean(4, produ.isEstado());
            ps.setInt(5, produ.getIdProducto());
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                JOptionPane.showMessageDialog(null, "Producto modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
    }
      
    public Producto consultarProducto(String nombre) {
        

Producto produ = null;
        String sql = "SELECT idProducto, nombre, cantidad, precio FROM producto WHERE nombre = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                produ = new Producto();
                produ.setIdProducto(rs.getInt("IdProducto"));
                produ.setNombre(rs.getString("nombre"));
                produ.setCantidad(rs.getInt("cantidad"));
                produ.setPrecio(rs.getDouble("precio"));
                produ.setEstado(true);
                
                JOptionPane.showMessageDialog(null, "Se encontrò el siguiente producto: " + produ.toString());

            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
        }
        return produ;
    
    }
     public class ListaProductos{
  //  public List<Producto> listar() {
    private List<Producto> productos;
    private int estado;
   

    public void Pedido() {
        this.productos = new ArrayList<>();
        this.estado = 0;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void quitarProducto(Producto producto) {
        this.productos.remove(producto);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : this.productos) {
            subtotal += (producto.getCantidad()) * (producto.getPrecio());
        }
        return subtotal;
    }
        public List<Producto> listar() {
        return this.productos;
       
    }
       
        }
  
    
    
}
