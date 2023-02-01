/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;

/**
 *
 * @author USUARIO
 */
public class Cliente {
    //Atributos
    final private int id;
    final private String nombre;

    //Constructor
    public Cliente(int id, String nomb){
        this.id = id;
        this.nombre = nomb;
    }

    //GET
    public String get_nombre(){
            return nombre;
    }
    
    public int get_id(){
            return id;
    }
}
