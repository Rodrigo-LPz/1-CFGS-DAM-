package dbloginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class DBloginApp_masSeguro{
    public static void main(String[] args){
        // Creamos las 3 propiedades constantes de la clase (url o direcci?n de la base de datos, usuario y contrase?a).
        String db_url = "jdbc:mysql://localhost:3306/seguridad_db";
        String db_user = "root";
        String db_password = "root";
        
        // Declaramos la/s variable/s.
        Scanner user = new Scanner(System.in);
        String username = "";
        String password = "";
        
        // Declaramos los objetos "Connection" para poder conectarse a la base de datos y "Statement" para declarar posteriormente las sentencias con las que interactuar con dicha base.
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        // Declaramos el objeto "ResultSet", definido dentro del "try" para poder obtener el resultado dado por la consulta a la base de datos y "Statement" para declarar posteriormente las sentencias con las que interactuar con dicha base.
        ResultSet rs = null;
        
        // Declaramos un comprobante para saber si se ha introducido un par?metro.
        boolean succesful = false;
        
        // Solicitamos los datos de entrada al usuario.
        System.out.print("Please, enter your username: ");
        username = user.nextLine();
        
        System.out.print("Now, create a password: ");
        password = user.nextLine();
        
        
        // Declara la variable de tipo "String" para "sql".
        String sql = "";
        
        try{
            // Cargar el Driver de la base de datos 'MySQL'.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente.");
            
            // Conectarse a la base de datos 'MySQL'.
            connection = DriverManager.getConnection(db_url, db_user, db_password); /* Creamos el objeto "connection". */
            System.out.println("Conexi?n establecida con la base de datos.");
            
            //Realizamos las distintas consultas SQL.
            // -------------------------- Comprobamos si el usuario existe y es introducido correctamente. --------------------------
            sql = "SELECT * FROM users WHERE username = ? and password = ?";
            pstmt = connection.prepareStatement(sql);
            
            // Tanto el "1" como el "2" funcionar?n como array, sustituy?ndose su valor por los (?) del String "Consulta". Eto funcionar? como una especie de array
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            // Muestreo de la consulta.
            System.out.println("Consulta SQL ejecutada: " + sql);
            
            // Ejecutamos la consulta.
            rs = pstmt.executeQuery();
            succesful = false;
            
            // Verificamos si la consulta encontr? el usuario, es decir, validamos el resultado.
            while (rs.next()){
                succesful = true;
                int rowId = rs.getInt("Id");
                String rowUsername = rs.getString("username");
                String rowPassword = rs.getString("password");
                System.out.println(rowId + "\t" + rowUsername+ "\t" + rowPassword);
            }
            
            if (succesful){
                System.out.println("Inicio de sesi?n ");
            }
        } catch (ClassNotFoundException ex){ /* Capturamos el posible error que puede surgir al cargar el driver, es decir, en "Class.forName". */
            System.err.println("Error al cargar el driver del SGBD: " + ex.getMessage());
        } catch (SQLException ex){/* Capturamos el posible error que puede surgir al cargar o intentar conectarse a la base de datos. */
            System.err.println("Error al conectarse a la base de datos o al realizar la consulta/sentencia: " + ex.getMessage());
        } finally{ /* Creamos o capturamos la ?ltima sentencia, es decir, el cierre de la base de datos tras terminar de utilizarla. */
            try{
                if (pstmt != null){
                    pstmt.close();
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