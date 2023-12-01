package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author luciano
 */
public class Coneccion {
    private final String bd = "\\DataSystem\\db_ds";
    private final String url = "jdbc:h2:";
    private final String user = "root";
    private final String password = "";
    private final String driver = "org.h2.Driver";
    private Connection cn = null;
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Se a conectado exitosamente a de la base de datos.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al intentar conectarse a la base de datos." + ex);
            JOptionPane.showMessageDialog(null, "ERROR en la coneccion: " + ex);
        }
        return cn;
    }

    public void desconectar() {
        try {
            cn.close();
            System.out.println("Se a desconectado de la base de datos.");
        } catch (SQLException ex) {
            System.out.println("Error al intentar desconectarse de la base de datos." + ex);
            JOptionPane.showMessageDialog(null, "ERROR al desconectarse" + ex);
        }
    }  
}