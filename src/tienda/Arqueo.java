/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author USUARIO
 */
public class Arqueo extends Compra {
    private Compra compra;
  
    public Arqueo(int precio, int cantidad) {
	super(precio, cantidad);
    }
    
    public void cambiarPrecio(){
        int value = (compra.getCantidadComprada()*compra.getPrecio()+this.getCantidadComprada()*this.getPrecio())/(compra.getCantidadComprada()+this.getCantidadComprada());
        this.setPrecio(value);
    }
    
    
}
