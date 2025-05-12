package dbconnection;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class DBcreation{
    public static void main(String[] args) throws ClassNotFoundException{
        // Creamos las 3 propiedades constantes de la clase (url o direcci?n de la base de datos, usuario y contrase?a).
        String db_url = "jdbc:mysql://localhost:3306";
        String db_user = "root";
        String db_password = "root";
        
        // Declaramos los objetos "Connection" para poder conectarse a la base de datos y "Statement" para declarar posteriormente las sentencias con las que interactuar con dicha base.
        Connection connection = null;
        Statement stmt = null;
        
        // Declara la variable de tipo "String" "sql".
        String sql = "";
        
        try{
            // Cargar el Driver de la base de datos 'MySQL'.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente");
            
            // Conectarse a la base de datos 'MySQL'.
            connection = DriverManager.getConnection(db_url, db_user, db_password); /* Creamos el objeto "connection". */
            System.out.println("Conexi?n correcta");
            
            
            // -------------------------- Borramos la base de datos en caso de que exista. --------------------------
            // Creamos el objeto "stmt".
            stmt = connection.createStatement();
            // Creamos/Asignamos a la variable "sql" con un mensaje.
            sql = "DROP DATABASE IF EXISTS seguridada_db";
            
            // Ejecutamos la sentencia de la variable "sql".
            stmt.executeUpdate(sql);
            System.out.println("La base de datos 'seguridad_db' ha sido eliminada.");
            
            
            // -------------------------- Creamos la base de datos. --------------------------
            // Creamos/Asignamos a la variable "sql" con un mensaje.
            sql = "CREATE DATABASE seguridada_db";
            
            // Ejecutamos la sentencia de la variable "sql".
            stmt.executeUpdate(sql);
            System.out.println("La base de datos 'seguridad_db' ha sido creada.");
            
            
            // -------------------------- Usamos la base de datos. --------------------------
            // Creamos/Asignamos a la variable "sql" con un mensaje.
            sql = "USE seguridada_db";
            
            // Ejecutamos la sentencia de la variable "sql".
            stmt.executeUpdate(sql);
            System.out.println("La base de datos 'seguridad_db' ha sido seleccionada.");
            
            
            // -------------------------- Creamos la/s tabla/s. --------------------------
            // Creamos/Asignamos a la variable "sql" con un mensaje.
            sql = "CREATE TABLE users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(100) NOT NULL" +
                ")";
            
            // Ejecutamos la sentencia de la variable "sql".
            stmt.executeUpdate(sql);
            System.out.println("La tabla 'users' ha sido creada dentro de la base de datos 'seguridad_db'.");
            
            
            // -------------------------- Insertamos los distintos registros dentro de la tabla "users". --------------------------
            // Creamos/Asignamos a la variable "sql" con un mensaje.
            sql = "INSERT INTO users (username, password)" +
                    "VALUES ('admin', 'admin123'), ('usuario', 'pass123');";
            
            // Ejecutamos la sentencia de la variable "sql".
            stmt.executeUpdate(sql);
            System.out.println("Los distintos registros dentro de la tabla 'users' han sido creados.");
            
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