
package accesoADatos;

import entidades.Mesa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {
    
    private Connection con = null;
    
    public MesaData(){
        con = Conexion.getConexion();
    }
    
public void agregarMesa(Mesa me){ 
    
    String sql = "INSERT INTO mesa (idMesa, capacidad, estado, numero) VALUES (?, ?, ?, ?)";
    
    try {
            //preparedStatement envian la setencia anterior
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//que me devuelva la lista de claves generadas
           
            ps.setInt(1,me.getIdMesa());
            ps.setInt(2, me.getCapacidad());
            ps.setBoolean(3, me.isEstado());
            ps.setInt(4, me.getnumero());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                me.setIdMesa(rs.getInt("idMesa"));
                JOptionPane.showMessageDialog(null, "Mesa añadida.");
                JOptionPane.showMessageDialog(null, "Id mesa: "+ rs.getInt("idMesa"));
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
        }
    }

public void modificarMesa(Mesa me){ 
       String sql = "UPDATE mesa SET capacidad = ?, estado= ?, numero = ? WHERE IdMesa = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, me.getCapacidad());
            ps.setBoolean(2, me.isEstado());
            ps.setInt(3, me.getnumero());
            ps.setInt(4, me.getIdMesa());
            
            int exito = ps.executeUpdate();//execute devuelve en un entero con la cantidad de filas afectadas
            if (exito == 1) { //va a devolver 1 porque el id es unico
                JOptionPane.showMessageDialog(null, "La mesa ha sido modificada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra la mesa.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa : " + ex.getMessage());
        }
      }

// el siguiente metodo borra una mesa por su IdMesa
 public void borrarMesa(int idMesa){
    try {
            String sql = "DELETE FROM mesa WHERE idMesa = ?";
              
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Se eliminó la mesa.");
            } else{
                JOptionPane.showMessageDialog(null, "No se encontró la mesa");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa");
        }
    }
 
    public Mesa consultarMesa(int numero) {
        

        Mesa m = null;
        String sql = "SELECT idMesa, capacidad, estado, numero  FROM mesa WHERE numero = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Mesa(0, 0, true, 0);
                m.setIdMesa(rs.getInt("IdMesa"));
                m.setCapacidad(rs.getInt("capacidad"));
                m.setEstado(true);
                m.setnumero(rs.getInt("numero"));
              
            } else {
                JOptionPane.showMessageDialog(null, "No existe la mesa");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa: " + ex.getMessage());
        }
        return m;
    
    }
    }


    

