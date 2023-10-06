
package prueba;

import accesoADatos.Conexion;
import accesoADatos.PedidoData;
import entidades.Producto;
import accesoADatos.ProductoData;
import entidades.Pedido;
import java.sql.Connection;
import java.time.LocalDate;

public class Resto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Connection con= Conexion.getConexion();
 //AGREGAR PRODUCTOS
//Producto produ1 = new Producto("Shawarma", 2500, 15, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.agregarproducto(produ1);


//ELIMINA PRODUCTO
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.eliminarProducto(4);

// MODIFICA PRODUCTO
//Producto producto1 = new Producto(5,"Hamburguesa Lentejas", 1000, 10, true);
//ProductoData produData = new ProductoData();//Guarda en la base
//produData.modificarProducto(producto1); 


//CONSULTA PRODUCTO

//ProductoData produData = new ProductoData();
//Producto pro = produData.consultarProducto("pizza");
//        System.out.println("Si tenemos disponible"+ pro.toString());

 
// AGREGAR UN PEDIDO
PedidoData pedid = new PedidoData();
Pedido pe = new Pedido(0, 2, "Juanca", LocalDate.now(), 3000.2, false);
pedid.agregarPedido(pe);

    }
    
}
