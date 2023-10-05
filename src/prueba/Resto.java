
package prueba;

import accesoADatos.Conexion;
import entidades.Producto;
import accesoADatos.ProductoData;
import java.sql.Connection;

public class Resto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Connection con= Conexion.getConexion();
 //AGREGAR PRODUCTOS
//Producto producto1 = new Producto("Lomo 3", 2500, 5, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.agregarproducto(producto1);


//ELIMINA PRODUCTO
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.eliminarProducto(4);

// MODIFICA PRODUCTO
//Producto producto1 = new Producto(5,"Hamburguesa Lentejas", 1000, 10, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.modificarProducto(producto1); 


//CONSULTA PRODUCTO

ProductoData produData = new ProductoData();
Producto pro = produData.consultarProducto("pizza");
        System.out.println("Si tenemos disponible"+ pro.toString());

 
    }
    
}
