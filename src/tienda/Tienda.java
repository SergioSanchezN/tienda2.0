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
public class Tienda {

    String prdNmb  = JOptionPane.showInputDialog("Indique el Producto");
    Double prdPrc  = Double.parseDouble(JOptionPane.showInputDialog("Indique el Precio"));
    
    
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String bbdd="jdbc:mysql://127.0.0.1/apptienda";
    private static final String usuario ="root";
    private static final String clave="1234";
    
    public static void main( String args[] ) {
       //Connection con = new Conexion();
       /*
       Connection conex = null;
        
        try {
            //Registrar el driver
            Class.forName("com.mysql.jdbc.Driver");
            //Creamos una conexión a la Base de Datos
            conex = DriverManager.getConnection(bbdd, usuario, clave);
            System.out.println("se ha conectado");
        // Si hay errores informamos al usuario. 
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: "+e);
        } catch (SQLException e) {
            System.out.println("Error de conexion: "+e);
        } catch (Exception e) {
            System.out.println("Error desconocido: "+e);
        }
        */
       
       Conexion conexion = Conexion.getSingletonInstance();
    
        
        //Clientes
        List<Cliente> clientes =  new ArrayList<>();
        clientes.add(new Cliente("1","Jorge"));
        clientes.add(new Cliente("2","Sam"));
        clientes.add(new Cliente("3","Dana"));
        
        //Productos
        List<Producto> productos =  new ArrayList<>();
        productos.add(new Producto("Piña",4000,30));
        productos.add(new Producto("Manzana",1500,12));
        productos.add(new Producto("Tomate",500,20));
        
        //Elegir cliente
        JOptionPane.showMessageDialog(null, "Simulación de un inventario tienda");
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
                    
                }
                               
            }
            salir = Integer.parseInt(JOptionPane.showInputDialog(
                        "Elija una opcion:\n 0.Continuar facturando\n 1.Salir de la aplicacion"));
        }
    
        
        //Tienda tienda = new Tienda();
        //IHM ihm = new IHM(tienda);
    }
}
    

