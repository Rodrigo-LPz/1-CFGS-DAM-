package dbconnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class DBconnection{
    public static void main(String[] args){
        Connection connection = MySQLconnection.getConnection();
        
        if (connection != null){
            System.out.println("Ya puedes comenzar las operaciones con la base de datos.\n\n");
            
            try{
                Statement stmt = connection.createStatement();
                String sql = "SELECT codigo_cliente, nombre_cliente FROM cliente";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("Código\t\tNombre");
                while (rs.next()){
                    int codigo = rs.getInt("codigo_cliente");
                    String nombre = rs.getString("nombre_cliente");
                    System.out.println(codigo + "\t\t" + nombre);
                }
            } catch (SQLException ex){
                System.err.println("Error al realizar la consulta: " + ex.getMessage());
            }
        }
    }
}