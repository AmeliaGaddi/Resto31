package prueba;

import accesoADatos.Conexion;
import accesoADatos.MesaData;
import accesoADatos.PedidoData;
import entidades.Producto;
import accesoADatos.ProductoData;
import entidades.Mesa;
import entidades.Pedido;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import vistas.VistaLogin;

public class Resto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection con = Conexion.getConexion();

        VistaLogin vl = new VistaLogin();
         vl.setVisible(true);
         vl.setLocationRelativeTo(null); 
        
          Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    LocalDateTime localDateTime = timestamp.toLocalDateTime();
    LocalDate localDate = localDateTime.toLocalDate();
    System.out.println(localDate);
         
  
    //Este código crea una instancia de Timestamp con la fecha y hora actual y la imprime en la consola
        
    //  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    //Este código crea una instancia de Timestamp con la fecha y hora actual, crea una instancia de SimpleDateFormat con el patrón “dd/MM/yyyy HH:mm:ss” y formatea la fecha y hora en una cadena de texto según ese patrón.
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String formattedDate = dateFormat.format(timestamp);
    System.out.println(formattedDate);
    
          // Crear una instancia de pedidoData
    PedidoData pd = new PedidoData();
    
      // Llamar al método listarPedidos() en la instancia creada
    List<Pedido> pedidos = pd.listarPedidos();
    
//       Inicio v1 = new Inicio();
//        v1.setVisible(true);
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
         
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
          // ---AGREGAR UN PEDIDO---
//PedidoData pedid = new PedidoData();
//Pedido pe = new Pedido(5, 3, "Marcela", LocalDate.now(), 3500, true);
//pedid.agregarPedido(pe);
        
         //   ---BORRAR UN PEDIDO---
//pedid.borrarPedido(5);
        
         //   --- MODIFICAR PEDIDO ---
//pedid.modificarPedido(pe);
 
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
         //AGREGAR MESA
        //    MesaData mesaD = new MesaData();
        //    Mesa m= new Mesa(6, 04, true, 03);
        //    mesaD.agregarMesa(m);
            
         //ELIMINAR MESA
        //    MesaData mesaD=new MesaData();
        //    Mesa m= new Mesa(6, 04, true, 03);
        //    mesaD.eliminarMesa(6);
    
         //MODIFICAR MESA
        //MesaData mesaD= new MesaData();
        //Mesa m= new Mesa(4, 02, true, 02);
        //mesaD.modificarMesa(m);
    
         //CONSULTAR MESA
//        MesaData mesaD = new MesaData();
//        Mesa m = new Mesa(6, 04, true, 03);
//        mesaD.consultarMesa(03);

    }

}
