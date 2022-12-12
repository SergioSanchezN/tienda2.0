/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author USUARIO
 */
public class Producto {
    	private String nombre;
	private int precio;
	private int cantidad;

	//Constructor
	public Producto(String nombre, int precio, int cantidad)
	{
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
	}

	//GETs
	public String get_nombre(){
            return nombre;
	}
	public int get_precio(){
		return precio;
	}
	public int get_cantidad(){
		return cantidad;
	}

	//Funcion para disminuir en inventario
	public void vender_producto(int unidades){
		cantidad = cantidad - unidades;
	}
}
