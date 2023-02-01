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

    private int precioVenta = 0;

    //Constructor
    public InventarioProducto(int id,String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //GETs
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    public int getPrecioVenta(){
        return precioVenta;
    }

    //Añadir compra
    public void añadirCompra(Compra compra){
        compras.add(compra);
        double suma = 0;
        for(Compra compraIter : compras){
            suma = suma + compraIter.getPrecio();
        }
        int precio = 0;
        if(!compras.isEmpty()){
            suma = suma / compras.size() * 1.1;
        }        
        precio = (int) suma;         
        this.precioVenta = precio;
    }
    
    //Vender producto
    public int venderProducto(int cant){
        
        for(Compra compraIter : compras){
            cant = compraIter.venderProducto(cant);
            if(cant == 0){
                break;
            }
        }       
        return cant;              
    }              
}
