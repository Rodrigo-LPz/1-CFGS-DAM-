package dbloginapp;

import java.sql.*;
import java.util.Scanner;


public class DBloginApp{
    public static void main(String[] args){
        // Creamos las 3 propiedades constantes de la clase (url o direcci?n de la base de datos, usuario y contrase?a).
        String db_url = "jdbc:mysql://localhost:3306";
        String db_user = "root";
        String db_password = "root";
        
        // Declaramos la/s variable/s.
        Scanner user = new Scanner(System.in);
        String username = "";
        String password = "";
        
        // Declaramos los objetos "Connection" para poder conectarse a la base de datos y "Statement" para declarar posteriormente las sentencias con las que interactuar con dicha base.
        Connection connection = null;
        Statement stmt = null;
        
        // Solicitamos los datos de entrada al usuario.
        System.out.print("Please, enter your username: ");
        username = user.nextLine();
        System.out.print("Now, create or insert a password: ");
        password = user.nextLine();
        
        try{
            // Cargar el Driver de la base de datos 'MySQL'.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente");
            
            // Conectarse a la base de datos 'MySQL'.
            connection = DriverManager.getConnection(db_url, db_user, db_password); /* Creamos el objeto "connection". */
            System.out.println("Conexi?n correcta");
            
            //Realizamos las distintas consultas SQL.
            
            
        } catch (ClassNotFoundException ex){ /* Capturamos el posible error que puede surgir al cargar el driver, es decir, en "Class.forName". */
            System.err.println("Error al cargar el driver del SGBD: " + ex.getMessage());
        } catch (SQLException ex){/* Capturamos el posible error que puede surgir al cargar o intentar conectarse a la base de datos. */
            System.err.println("Error al conectarse a la base de datos o al realizar la consulta/sentencia: " + ex.getMessage());
        } finally{ /* Creamos o capturamos la ?ltima sentencia, es decir, el cierre de la base de datos tras terminar de utilizarla. */
            try{
                if (stmt != null){
                    stmt.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException ex){
                System.out.println("Error al cerrar o finalizar la conexi?n." + ex.getMessage());
            }
        }
    }
}