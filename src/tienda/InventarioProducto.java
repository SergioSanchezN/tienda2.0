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
public class InventarioProducto {
    private int id;
    private String nombre;
    private List<Compra> compras = new ArrayList<>();
    private int precio;
    Conexion conexion = Conexion.getSingletonInstance();

    //Constructor
    public InventarioProducto(int id,String nombre,int precio){       
        this.id = id;
        this.nombre = nombre;        
        this.compras = conexion.obtenerCompras(this);
        this.precio = precio;
    }

    //GETs
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    
    public int getPrecio(){
        return precio;
    }
    
    public int getCantidad(){
        compras = this.conexion.obtenerCompras(this);
        int total = 0;
        for(Compra compraIter : compras){
            total = total + compraIter.getCantidadReal();
        }
        return total;
    }
    
    public void actualizarInventario(){
        compras = this.conexion.obtenerCompras(this);
    }
    
    // Calcular precio
    public int calcularPrecio(){
        this.compras = conexion.obtenerCompras(this);
        double suma = 0;
        for(Compra compraIter : compras){
            suma = suma + compraIter.getPrecio();
        }
        int precio = 0;
        if(!compras.isEmpty()){
            suma = suma / compras.size() * 1.1;
        }        
        precio = (int) suma;  
        this.precio = precio;
        return precio;
    }
    
    //Vender producto
    public void sacarProducto(int cant){
        this.compras = conexion.obtenerCompras(this);
        for(Compra compraIter : compras){
            if((compraIter.getCantidadReal()-cant)>=0){
                cant = compraIter.getCantidadReal()-cant;
                System.out.println(compraIter.getId());
                System.out.println(cant);
                conexion.sacarInventario(compraIter.getId(), cant);
                break;
            }else{
                System.out.println(compraIter.getId());
                System.out.println(cant);
                cant=cant-compraIter.getCantidadReal();
                conexion.sacarInventario(compraIter.getId(), 0);
            }       
        } 
        compras = this.conexion.obtenerCompras(this);
    }  
    
     
}
