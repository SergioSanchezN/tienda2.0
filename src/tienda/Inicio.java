/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class Inicio {
    String prdNmb  = JOptionPane.showInputDialog("Indique el Producto");
    Double prdPrc  = Double.parseDouble(JOptionPane.showInputDialog("Indique el Precio"));
    
    
    public static void main( String args[] ) {
        
        Tienda store = new Tienda();      
        Menu home = new Menu(store);
        home.setVisible(true);

        /*//Conexion conexion = Conexion.getSingletonInstance();
           
        //Clientes
        List<Cliente> clientes =  new ArrayList<>();
        clientes.add(new Cliente("1","Jorge"));
        clientes.add(new Cliente("2","Sam"));
        clientes.add(new Cliente("3","Dana"));
        
        //Productos
        List<Producto> productos =  new ArrayList<>();
        productos.add(new Producto(1,"Piña"));
        productos.add(new Producto(2,"Manzana"));
        productos.add(new Producto(3,"Tomate"));
        
        //Factura fact = new Factura(clientes.get(1),"11/12/2022");
        //Conexion.facturar(fact);
        
        //Elegir cliente
        //JOptionPane.showMessageDialog(null, "Simulación de un inventario tienda");
        int salir = 0;
        while(salir == 0){
            int cliente_nombre  = Integer.parseInt(JOptionPane.showInputDialog(
                    "Indique el cogido del cliente:\n 1.Jorge\n 2.Sam\n 3.Dana"));
            String fecha  = JOptionPane.showInputDialog("Indique la fecha de hoy");
            Factura factura = new Factura(clientes.get(cliente_nombre-1),fecha);
            int facturar = 0;
            while(facturar == 0){
                int id_producto = Integer.parseInt(JOptionPane.showInputDialog(
                        "Indique el Producto:\n 1.Piña\n 2.Manzana\n 3.Tomate"));           
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                        "ingrese la cantidad de " + productos.get(id_producto-1).get_nombre()+
                        "\nque quiere comprar"));            
                factura.añadir_venta(new Venta(productos.get(id_producto-1),cantidad));
                
                JOptionPane.showMessageDialog(null, "total: "+factura.calcular_total());
                
                facturar = Integer.parseInt(JOptionPane.showInputDialog(
                        "Elija una opcion: \n0.Agregar mas productos\n 1.Facturar productos"));
                if(facturar == 1){
                    Conexion.facturar(factura);
                }
                               
            }
            salir = Integer.parseInt(JOptionPane.showInputDialog(
                        "Elija una opcion:\n 0.Continuar facturando\n 1.Salir de la aplicacion"));
        }*/

        //Tienda tienda = new Tienda();
        //IHM ihm = new IHM(tienda);
    }
}
    

