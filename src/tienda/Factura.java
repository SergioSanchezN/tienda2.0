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
    public int calcular_total(){
        int suma = 0;
        for(Venta ven : ventas){
            suma = suma + ven.get_subtotal();
        }      
        return suma;
    }
}
