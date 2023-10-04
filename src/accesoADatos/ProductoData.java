
package accesoADatos;

import entidades.Producto;
import javax.swing.JOptionPane;


public class ProductoData {
   public void  altaProducto(Producto producto){
       ProductoData pD = new ProductoData();
       pD.altaProducto(producto);
       JOptionPane.showMessageDialog(null, "nuevo producto");
       
       
   }
   
   public void  bajaProducto(){
       ProductoData pD = new ProductoData();
       pD.bajaProducto();
       
   }
   public void modificarProducto(){
       ProductoData pD = new ProductoData();
       pD.modificarProducto();
       
   }
           
    public void consultarProducto(){
        ProductoData pD = new ProductoData();
        pD.consultarProducto();
        
    }
    
}
