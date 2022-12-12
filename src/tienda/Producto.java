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
        private int id;
    	private String nombre;
	private int precio;
	private int cantidad;

	//Constructor
	public Producto(int id,String nombre, int precio, int cantidad)
	{
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
	}

	//GETs
        public int get_id(){
            return id;
	}
        
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
