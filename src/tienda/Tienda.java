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
    private List<Compra> compras = new ArrayList<>();

    //Constructor
    public Tienda(){      
        clientes = this.conexion.obtenerClientes();
        productos = this.conexion.obtenerPoductos();  
        compras = this.conexion.obtenerComprasTienda();
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    public List<InventarioProducto> getProductos(){
        return productos;
    }
    
    public List<Compra> getCompras(){
        return compras;
    }
    
    public void registrarVenta(Cliente cliente, InventarioProducto producto, int cantidad) {
        Venta venta = new Venta(cliente, producto, cantidad);        
        conexion.ingresarVenta(venta);
    }
    
     public void registrarCompra(InventarioProducto producto,int precio, int cantidad) {
        Compra compra = new Compra(precio, cantidad);        
        conexion.ingresarCompra(producto, compra);
        producto.actualizarInventario();
    }
     
    public void registrarArqueo(InventarioProducto producto, int precio, int cantidad) {
        Arqueo arqueo = new Arqueo(precio, cantidad);        
        conexion.ingresarArqueo(producto, arqueo);
    }
     
     
    public void cargarProductos(InventarioProducto producto){
        
    }
    
}
