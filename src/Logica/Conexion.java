package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Fede
 */
public class Conexion {
    public String db = "basereserva";
    public String url = "jdbc:mysql://127.0.0.1/" + db;
    public String users = "root";
    public String pass = "";

    public Conexion() {
    }
    
    public Connection Conectar(){
        Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.users, this.pass);
            System.out.println("Conexion exitosa");
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error de conexión: " + e);
        }
        return link;
    }
    
}
