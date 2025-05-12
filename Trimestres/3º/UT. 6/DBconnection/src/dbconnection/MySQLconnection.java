package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLconnection{
    public static Connection getConnection(){
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "root";
        
        try{
            // Cargar el driver de MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conectarnos a la base de datos.
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.\n");
        } catch (ClassNotFoundException e){
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (SQLException e){
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
        
        return connection;
    }
}