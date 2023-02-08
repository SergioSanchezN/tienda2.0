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
public class Compra {
    private int id;
    private String fecha;
    private int precio;
    private int cantidadComprada;
    private int cantidadReal;
    
    public Compra( int precio, int cantidad){
        this.precio = precio;
        this.cantidadComprada = cantidad;
        this.cantidadReal = cantidad;
    }
    
    //GET
    public int getId(){
        return id;
    }
    public int getPrecio(){
        return precio;
    }   
    public int getCantidadComprada(){
        return cantidadComprada;
    }
    public int getCantidadReal(){
        return cantidadReal;
    }
    
    //SET
    public void setId(int id){
        this.id = id;
    }
    public void setCantidadReal(int cantidadReal){
        this.cantidadReal = cantidadReal;
    }
    public void setPrecio(int precio){
        this.precio = precio;
    }
    
    
    //Vender producto
    public int venderProducto(int cant){
        if(cantidadReal>=cant){
            cantidadReal = cantidadReal - cant;
            return cantidadReal;
        }else{
            cantidadReal = 0;
            return cantidadReal;
        }
    }
}
