/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;
import demo.Factura;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
    
    public ArrayList<Cliente> obtenerClientes(){ 
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        String consulta;
        try{    
            
            String SQL = "SELECT * FROM clientes;";
            PreparedStatement pstmt = conex.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                int id =  Integer.parseInt(rs.getString( 1 ));
                String nombre = rs.getString( 2 );
                Cliente clien = new Cliente(id, nombre);
                clientes.add(clien);               
            }
        
        }catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" 
            + sqle.getErrorCode() + " " + sqle.getMessage());
        }
      return clientes;
    }
    
    public ArrayList<InventarioProducto> obtenerPoductos(){ 
        
        ArrayList<InventarioProducto> productos = new ArrayList<>();
        PreparedStatement ps;
        String consulta;
        try{    
            
            String SQL = "SELECT * FROM productos;";
            PreparedStatement pstmt = conex.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                int id =  Integer.parseInt(rs.getString( 1 ));
                String nombre = rs.getString( 2 );
                InventarioProducto prod = new InventarioProducto(id, nombre);
                productos.add(prod);               
            }
                                   
        }catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" 
            + sqle.getErrorCode() + " " + sqle.getMessage());
        }
      return productos;
    }
    
    public ArrayList<Compra> obtenerComprasTienda(){         
        ArrayList<Compra> compras = new ArrayList<>();
        PreparedStatement ps;
        String consulta;
        try{               
            String SQL = "SELECT * FROM compras;";
            PreparedStatement pstmt = conex.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                int id =  Integer.parseInt(rs.getString( 1 ));
                int precio = Integer.parseInt(rs.getString( 2 ));
                int cantC = Integer.parseInt(rs.getString( 3 ));
                int cantR = Integer.parseInt(rs.getString( 4 ));
                Compra comp = new Compra(precio, cantC);
                comp.setCantidadReal(cantR);
                comp.setId(id);
                compras.add(comp);               
            }
            
        }catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" 
            + sqle.getErrorCode() + " " + sqle.getMessage());
        }
      return compras;
    }
    
    public ArrayList<Compra> obtenerCompras(InventarioProducto producto){         
        ArrayList<Compra> compras = new ArrayList<>();
        PreparedStatement ps;
        String consulta;
        try{               
            String SQL = "SELECT * FROM compras WHERE id_producto = "+producto.getId()+";";
            PreparedStatement pstmt = conex.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                int id =  Integer.parseInt(rs.getString( 1 ));
                int precio = Integer.parseInt(rs.getString( 2 ));
                int cantC = Integer.parseInt(rs.getString( 3 ));
                int cantR = Integer.parseInt(rs.getString( 4 ));
                Compra comp = new Compra(precio, cantC);
                comp.setCantidadReal(cantR);
                comp.setId(id);
                compras.add(comp);               
            }
            
        }catch (SQLException sqle) {
            System.out.println("Error en la ejecución:" 
            + sqle.getErrorCode() + " " + sqle.getMessage());
        }
      return compras;
    }
    
    public void sacarInventario(int id, int cant){
        PreparedStatement ps;
      String consulta;
      try{
          consulta = "UPDATE compras SET cantidadInventario = "+ cant +
            " WHERE (idCompras = "+ id +");";
            ps = conex.prepareStatement(consulta);
            
            ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Se han sacado productos del inventario");         
      }catch (SQLException sqle) {
        JOptionPane.showMessageDialog(null,"Error en la ejecución:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());
      } 
    }

    public static void ingresarVenta(Venta venta){
      PreparedStatement ps;
      String consulta;
      try{
          consulta = "INSERT INTO ventas (cantidad, total, id_producto, id_cliente) VALUES (?,?,?,?);";
            ps = conex.prepareStatement(consulta);
            ps.setInt(1, venta.getCantidad());
            ps.setInt(2, venta.getTotal());
            ps.setInt(3, venta.getProducto().getId());
            ps.setInt(4, venta.getCliente().get_id());
            ps.executeUpdate();

        JOptionPane.showMessageDialog(null, "Se ha guardado la venta");         
      }catch (SQLException sqle) {
        JOptionPane.showMessageDialog(null,"Error en la ejecución:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());
      }    
    }
    
    public static void ingresarCompra(InventarioProducto producto, Compra compra){
      PreparedStatement ps;
      String consulta;
      try{
          consulta = "INSERT INTO compras (precio, cantidadCompra, cantidadInventario, id_producto) VALUES (?,?,?,?);";
            ps = conex.prepareStatement(consulta);
            ps.setInt(1, compra.getPrecio());
            ps.setInt(2, compra.getCantidadComprada());
            ps.setInt(3, compra.getCantidadReal());
            ps.setInt(4, producto.getId());
            ps.executeUpdate();

          JOptionPane.showMessageDialog(null, "Se ha guardado la compra");
          
      }catch (SQLException sqle) {
        JOptionPane.showMessageDialog(null,"Error al guardar la compra:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());
      }    
    }
    
    
    
}




/*public static void demoIngresarProducto(Factura factura){
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
            ps.setInt(1, ven.get_producto().getId());
            ps.setInt(2, ven.get_cantidad());
            ps.setInt(3, ven.get_total());
            while ( rs.next() ) {
             String ids = rs.getString( 1 );
             ps.setInt(4, Integer.parseInt(ids));
            }   
            ps.executeUpdate();
            //ven.sacar_producto();
          }
          
          
          JOptionPane.showMessageDialog(null, "Se han insertado los datos");
          
          
          
      }catch (SQLException sqle) {
        System.out.println("Error en la ejecución:" 
        + sqle.getErrorCode() + " " + sqle.getMessage());
      }
     
   }*/
