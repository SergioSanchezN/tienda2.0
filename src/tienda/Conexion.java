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
    private static final String driver="com.mysql.cj.jdbc.Driver";
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
    
    public static Connection get_conex(){
        return conex;
    } 
    
    public static void facturar(Factura factura){
      PreparedStatement ps;
      String consulta;
      try{
          consulta = "INSERT INTO factura ( fecha, id_cliente) values(?,?)";
          ps = conex.prepareStatement(consulta); 
          ps.setString(1, factura.get_fecha());
          ps.setString(2, factura.get_cliente().get_id());
          ps.executeUpdate();
          
          String SQL = "SELECT max(id) FROM factura;";
          PreparedStatement pstmt = conex.prepareStatement(SQL);
          ResultSet rs = pstmt.executeQuery();
        
          for(Venta ven : factura.get_ventas()){
            consulta = "INSERT INTO ventas (id_producto, cantidad, subtotal, factura_id) VALUES (?,?,?,?);";
            ps = conex.prepareStatement(consulta);
            ps.setInt(1, ven.get_producto().get_id());
            ps.setInt(2, ven.get_cantidad());
            ps.setInt(3, ven.get_subtotal());
            while ( rs.next() ) {
             String ids = rs.getString( 1 );
             ps.setInt(4, Integer.parseInt(ids));
            }   
            ps.executeUpdate();
            ven.sacar_producto();
          }
          
          
          JOptionPane.showMessageDialog(null, "Se han insertado los datos");
          
          
          
      }catch (SQLException sqle) {
        System.out.println("Error en la ejecución:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());
      }
     
   }
    
    
}
