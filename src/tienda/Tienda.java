/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class Tienda {

    //Atributos
    Conexion conexion = Conexion.getSingletonInstance();
    private List<Cliente> clientes =  new ArrayList<>();
    private List<InventarioProducto> productos =  new ArrayList<>();
    private Venta venta;


    //Constructor
    public Tienda(){      
        clientes = this.conexion.obtenerClientes();
        productos = this.conexion.obtenerPoductos();        
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    public List<InventarioProducto> getProductos(){
        return productos;
    }
    
    public void registrarVenta(Cliente cliente, InventarioProducto producto, int cantidad) {
        venta = new Venta(cliente, producto, cantidad);        
        conexion.ingresarVenta(venta);
    }
    
     public void registrarCompra(Cliente cliente, InventarioProducto producto, int cantidad) {
        venta = new Venta(precio,cantidad);        
        conexion.ingresarVenta(venta);
    }
    
}
