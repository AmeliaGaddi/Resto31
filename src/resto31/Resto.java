
package resto31;

import accesoADatos.Conexion;
import java.sql.Connection;

public class Resto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Connection con= Conexion.getConexion();
    }
    
}
