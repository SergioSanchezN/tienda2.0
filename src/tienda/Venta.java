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
    private int id;
    private Cliente cliente;
    private InventarioProducto producto;
    private int cantidad;
    private int total;
    
    //Constructor
    public Venta(Cliente cliente, InventarioProducto producto, int cantidad){
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.calcularPrecio()*cantidad;
    }

    //GETs
    public Cliente getCliente(){
        return cliente;
    }
    public InventarioProducto getProducto(){
        return producto;
    }
    public int getCantidad(){
        return cantidad;
    }
    public int getTotal(){       
        return total;
    }
}
