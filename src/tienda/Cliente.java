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
    final private String id;
    final private String nombre;

    //Constructor
    public Cliente(String id, String nomb){
        this.id = id;
        this.nombre = nomb;
    }

    //GET
    public String get_nombre(){
            return nombre;
    }
    
    public String get_id(){
            return id;
    }
}
