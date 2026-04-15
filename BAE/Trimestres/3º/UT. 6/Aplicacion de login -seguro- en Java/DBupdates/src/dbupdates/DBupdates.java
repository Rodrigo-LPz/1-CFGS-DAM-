package dbupdates;

import java.sql.DriverManager;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class DBupdates {

    public static void main(String[] args){
        // Creamos las 3 propiedades constantes de la clase (url o dirección de la base de datos, usuario y contrase?a).
        String db_url = "jdbc:mysql://localhost:3306/seguridad_db";
        String db_user = "root";
        String db_password = "root";
        
        // Declaramos los objetos "Connection" para poder conectarse a la base de datos y "Statement" para declarar posteriormente las sentencias con las que interactuar con dicha base.
        Connection connection = null;
        PreparedStatement pstmt = null;
        String sql, encriptedPassword;

        try{
            // Cargar el Driver de la base de datos 'MySQL'.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente.");

            // Conectarse a la base de datos 'MySQL'.
            connection = DriverManager.getConnection(db_url, db_user, db_password);
            /* Creamos el objeto "connection". */
            System.out.println("Conexión establecida con la base de datos.");

            // Modificamos/Insertamos la columna "failed_attempts" en/a la tabla "user".
    //            sql = "ALTER TABLE users ADD COLUMN failed_attempts INT DEFAULT 0";
    //            pstmt = connection.prepareStatement(sql);
    //            pstmt.executeUpdate();
    //            System.out.println("\n\nLa columna 'failed_attempts' ha sido a?adida a la tabla");
            
            // Modificamos/Insertamos la columna "last_attempts" en/a la tabla "user".
    //            sql = "ALTER TABLE users ADD COLUMN last_attempts TIMESTAMP";
    //            pstmt = connection.prepareStatement(sql);
    //            pstmt.executeUpdate();
    //            System.out.println("\nLa columna 'last_attempts' ha sido a?adida a la tabla");
            
            // Encriptamos la/s contrase?a/s.
                /* Primero para el usuario 'admin' con la contrase?a 'admin123'. */
            encriptedPassword = BCrypt.hashpw("admin123", BCrypt.gensalt(12));
            System.out.println("\nLa contrase?a 'admin123' ha sido encriptada. Resultado de encriptación: " + encriptedPassword);
            sql = "UPDATE users SET password = ? WHERE username = ?";
            pstmt = connection.prepareStatement(sql);

            // Tanto el "1" como el "2" funcionarán como array, sustituyendo su valor por los (?) del String "Consulta". Eto funcionará como una especie de array.
            pstmt.setString(1, encriptedPassword);
            pstmt.setString(2, "admin");

            // Muestreo del resultado como indicación de que ha sucedido.
            pstmt.executeUpdate();
            System.out.println("La contrase?a del usuario 'admin' ha sido actualizada.");
            
            // --------------------------------------------------------------------------------------
            
                /* Ahora para el usuario 'pass' con la contrase?a 'pass123'*/
            encriptedPassword = BCrypt.hashpw("pass123", BCrypt.gensalt(12));
            System.out.println("\nLa contrase?a 'pass123' ha sido encriptada. Resultado de encriptación: " + encriptedPassword);
            sql = "UPDATE users SET password = ? WHERE username = ?";
            pstmt = connection.prepareStatement(sql);

            // Tanto el "1" como el "2" funcionarán como array, sustituyendo su valor por los (?) del String "Consulta". Eto funcionará como una especie de array.
            pstmt.setString(1, encriptedPassword);
            pstmt.setString(2, "usuario");

            // Muestreo del resultado como indicación de que ha sucedido.
            pstmt.executeUpdate();
            System.out.println("La contrase?a del usuario 'usuario' ha sido actualizada.\n");

        } catch (ClassNotFoundException ex){
            /* Capturamos el posible error que puede surgir al cargar el driver, es decir, en "Class.forName". */
            System.err.println("\nError al cargar el driver del SGBD: " + ex.getMessage());
        } catch (SQLException ex){/* Capturamos el posible error que puede surgir al cargar o intentar conectarse a la base de datos. */
            System.err.println("\nError al conectarse a la base de datos o al realizar la consulta/sentencia: " + ex.getMessage());
        } finally{
            /* Creamos o capturamos la última sentencia, es decir, el cierre de la base de datos tras terminar de utilizarla. */
            try{
                if (pstmt != null){
                    pstmt.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException ex){
                System.out.println("\nError al cerrar o finalizar la conexión." + ex.getMessage());
            }
        }
    }
}
