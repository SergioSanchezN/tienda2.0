/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

/**
 *
 * @author USUARIO
 */
public class Conexion{
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String bbdd="jdbc:mysql://localhost:3306/apptienda";
    private static final String usuario ="root";
    private static final String clave="1234";
    private static Connection conex;
    private static Conexion conexion_principal;
    
    
    private Conexion(){
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
    }
    
    public static Conexion getSingletonInstance(){
        if (conex == null){
            conexion_principal = new Conexion();
        }
        else{
            System.out.println("No se puede crear el objeto, porque ya existe un objeto de la clase Conexion");
        }
        return conexion_principal;
    }
    
    public void facturar(Factura factura){
      String sql = "insert into datos(nombre, edad, sexo) values(?,?,?)";
      
      	
      PreparedStatement ps = conex.prepareStatement("insert into datos(nombre, edad, sexo) values(?,?,?)");
  
        
    
      try (PreparedStatement stmt = conex.prepareStatement("INSERT INTO factura (fecha, id_cliente) VALUES ('"+factura.get_fecha()+"','"+factura.get_cliente().get_id()+"');")) {
      ResultSet rs = stmt.executeQuery();
      
      try (PreparedStatement stmt = conex.prepareStatement("INSERT INTO factura (fecha, id_cliente) VALUES ('"+factura.get_fecha()+"','"++"');")) {
      ResultSet rs = stmt.executeQuery();

      while (rs.next())
        System.out.println (rs.getString("country"));

    } catch (SQLException sqle) { 
      System.out.println("Error en la ejecución:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());    
    }
    }
    
    
}
