/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;
import java.util.ArrayList;
import java.util.List;
import tienda.Cliente;
import tienda.Venta;

/**
 *
 * @author USUARIO
 */
public class Factura {
    private Cliente cliente;
    private String fecha;
    private List<Venta> ventas =  new ArrayList<>();

    //Constructor
    public Factura(Cliente cliente, String fecha)
    {
        this.cliente = cliente;
        this.fecha = fecha;
    }
    
    public Cliente get_cliente(){
        return cliente;
    }
    
    public String get_fecha(){
        return fecha;
    }
    
    public List<Venta> get_ventas(){
        return ventas;
    }
    
    //Añadir venta
    public void añadir_venta(Venta venta){
        ventas.add(venta);
    }
    
    //Añadir total
    public double calcular_total(){
        double suma = 0;
        for(Venta ven : ventas){
            suma = suma + ven.getTotal();
        }      
        return suma;
    }
}
