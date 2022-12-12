/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author USUARIO
 */
public class Venta {
    //Atributos
    private Producto producto;
    private int cantidad;
    private int subtotal;
    
    //Constructor
    public Venta(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.get_precio()*cantidad;
    }

    //GETs
    public Producto get_producto(){
            return producto;
    }
    public int get_cantidad(){
            return cantidad;
    }
    public int get_subtotal(){       
        return subtotal;
    }
}
