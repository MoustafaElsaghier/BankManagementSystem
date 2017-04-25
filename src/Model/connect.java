package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class connect {

    static Connection connection = null;
    static Statement statement = null;

    
    public static Connection startConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "root");   
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return connection;
    }
    public static Statement startConnectionStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "root");
            statement = connection.createStatement();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return statement;
    }
    public static void closeConnection() {
        try {
            connection.close();
            statement.cancel();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
