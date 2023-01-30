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
public class Tienda_inv {

    //Atributos
    Conexion conexion = Conexion.getSingletonInstance();
    private List<Cliente> clientes =  new ArrayList<>();
    private List<Producto> productos =  new ArrayList<>();


    //Constructor
    public Tienda_inv(){      
        clientes = this.conexion.obtenerClientes();
        productos = this.conexion.obtenerPoductos();
        
        
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    public List<Producto> getProductosInventario(){
        return productos;
    }
    
}
