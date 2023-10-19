
package accesoADatos;

import entidades.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafa
 */
public class LoginData {
    
    private Connection con = null; 

    public LoginData() { //constructor va inicializar la variable con
        con = Conexion.getConexion();
    }
    
    
//     Login l;
    public Login log(String usuario,String pass){
        Login l = null;
       String sql = "Select * from usuarios where nombre = ? and contraseña = ?";
       try{
           PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, usuario);
          ps.setString(2, pass);
         ResultSet rs = ps.executeQuery();
          if(rs.next()){
              l = new Login();
              l.setId(rs.getInt("idUsuario"));
              l.setUsuario(rs.getString("nombre"));
              l.setPass(rs.getString("contraseña"));
          
          }
       
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "ERROR" + e.getMessage());
       
       }
     return l;
    }
    public void agregarUsuario(String usuario,String pass){ 
    
    String sql = "INSERT INTO usuarios (nombre,contraseña) VALUES (?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
            //Remplazo los ? por los datos del alumno que quiero enviar 
              ps.setString(1,usuario);
              ps.setString(2,pass);
           
           
            ps.executeUpdate();//ejecuta el preparedStatement armado anterior
            ResultSet rs = ps.getGeneratedKeys();//Obtiene la clave,recibimos un resultset consulta
            if (rs.next()) {
//               
                JOptionPane.showMessageDialog(null, "Exito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
            
        }
    }
    
}
