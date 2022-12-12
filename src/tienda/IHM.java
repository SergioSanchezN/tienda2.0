/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author USUARIO
 */
class IHM {
    Frame miFrame;

    public IHM(Tienda_inv tienda) {
    //Panel principal
    Panel panel_filas = new Panel();
    panel_filas.setLayout(new BorderLayout());
    panel_filas.setLayout(new GridLayout(6,1));
    
    //Panel cliente
    Panel panel_cliente = new Panel();
    Label label_cliente = new Label("Elija el cliente:");
    Choice choice_cliente = new Choice();
    for(Cliente cli : tienda.get_clientes()){
        choice_cliente.addItem(cli.get_nombre());
    }
    Button button_cliente = new Button( "Confirmar cliente" );
    panel_cliente.setLayout(new BorderLayout());
    panel_cliente.add(label_cliente, BorderLayout.WEST);
    panel_cliente.add(choice_cliente, BorderLayout.CENTER);
    panel_cliente.add(button_cliente, BorderLayout.EAST);
    
    //Panel fecha
    Panel panel_fecha= new Panel();
    Label label_fecha = new Label("Escriba la fecha");
    TextField text_fecha = new TextField(30);
    panel_fecha.add(label_fecha);
    panel_fecha.add(text_fecha);
       
    //Panel producto
    Panel panel_producto = new Panel();
    Label label_producto = new Label("Elija el producto:");  
    Choice choice_producto = new Choice();
    for(Producto prod : tienda.get_productos()){
        choice_producto.addItem(prod.get_nombre());
    }
    panel_producto.setLayout(new BorderLayout());
    panel_producto.add(label_producto, BorderLayout.WEST);
    panel_producto.add(choice_producto, BorderLayout.CENTER);
    
    //Panel cantidad
    Panel panel_cantidad = new Panel();
    Label label_cantidad  = new Label("Escriba la cantidad:");
    TextField text_cantidad = new TextField(30);  
    panel_cantidad.setLayout(new BorderLayout());
    panel_cantidad.add(label_cantidad, BorderLayout.WEST);
    panel_cantidad.add(text_cantidad, BorderLayout.CENTER);
    
    //Panel agregar
    Panel panel_agregar= new Panel();
    Button button_agregar = new Button( "Agregar producto" );
    panel_agregar.add(button_agregar);

    
    
    Button botonTitulo = new Button( "Imprime Titulo" );
    Button botonCursorMano = new Button( "Cursor Mano" );
    Button botonCursorFlecha = new Button( "Cursor Flecha" );
    
    //Se añaden los paneles
    panel_filas.add(panel_cliente);
    panel_filas.add(panel_fecha);
    panel_filas.add(panel_producto);
    panel_filas.add(panel_cantidad);
    panel_filas.add(panel_agregar);
    
       
    // Instancia un objeto Frame con su titulo indicativo de que se
    // se trata, utilizando un FlowLayout
    miFrame = new Frame( "APP tienda" );
    miFrame.setLayout( new FlowLayout() );

    // Añade tres objetos Button al Frame
    miFrame.add( panel_filas, BorderLayout.CENTER );  
    
    // Fija el tamaño del Frame y lo hace visible
    miFrame.setSize( 500,500 );
    miFrame.setVisible( true );    

    // Instancia y registra objetos ActionListener sobre los
    // tres botones utilizando la sintaxis abreviada de las
    // clases anidadas
    botonTitulo.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent evt ) {
            System.out.println( miFrame.getTitle() );
        }
    } );

    botonCursorMano.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent evt ) {
            miFrame.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
            }
        } );

    botonCursorFlecha.addActionListener( new ActionListener() {
        public void actionPerformed( ActionEvent evt ) {
            miFrame.setCursor( new Cursor( Cursor.DEFAULT_CURSOR ) );
            }
        } );

    // Instancia y registra un objeto WindowListener sobre el objeto
    // Frame para terminar el programa cuando el usuario haga click
    // con el raton sobre el boton de cerrar la ventana que se 
    // coloca sobre el objeto Frame
    miFrame.addWindowListener( new WindowAdapter() {
        public void windowClosing( WindowEvent evt ) {
            // Concluye la aplicacion cuando el usuario cierra la 
           // ventana
            System.exit( 0 );
            }
        } );
    }  
}
