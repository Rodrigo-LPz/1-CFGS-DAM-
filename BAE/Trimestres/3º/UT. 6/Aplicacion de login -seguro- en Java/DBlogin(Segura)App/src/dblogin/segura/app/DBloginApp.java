package dblogin.segura.app;

import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class DBloginApp{
    public static void main(String[] args){
        // Creamos las 3 propiedades constantes de la clase (url o direcci�n de la base de datos, usuario y contrase?a).
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
        
        // Declaramos un comprobante para saber si se ha introducido un par�metro y las variables correspondientes para el n�mero de intentos.
        boolean loginsuccesful = false;
        int maxAttenpts = 3;
        int countAttenpts = 0;
        
        // Declara la variable de tipo "String" para "sql" y "reset sql".
        String sql = "";
        String resetsql = "";
        
        // Declara la variable de tipo "String" para la enciptaci�n de la contrase?a, "encryptedPassword".
        String encryptedPassword = "";
        
        try{
            // Cargar el Driver de la base de datos 'MySQL'.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente.");
            
            // Conectarse a la base de datos 'MySQL'.
            connection = DriverManager.getConnection(db_url, db_user, db_password); /* Creamos el objeto "connection". */
            System.out.println("Conexi�n establecida con la base de datos.");
            
            // Creamos un bucle de tipo "do-while" con el que al menos solicitar al usuario los datos de entraqda antes de acceder al programa/aplicaci�n.
            do{                
                // Solicitamos los datos de entrada al usuario.
                System.out.print("\nPlease, enter your username: ");
                username = user.nextLine();
                
                // Despu�s de pedir el usuario y antes de introducir la contrase?a hacemos un comprobante de este.
                //Realizamos las distintas consultas SQL.
                // -------------------------- Comprobamos si el usuario existe (si los datos introducidos son correctos). --------------------------
                sql = "SELECT password, failed_attempts, last_attempts FROM users WHERE username = ?";
                pstmt = connection.prepareStatement(sql);
                
                // El "1" funcionar� como array, sustituyendo su valor por los (?) del String "Consulta". Funcionando como una especie de array.
                pstmt.setString(1, username);
                
                // Muestreo de la consulta para comprobar que se ha realizado correctamente la consulta.
                System.out.println("\nConsulta SQL ejecutada: " + sql);
                
                // Ejecutamos la consulta.
                rs = pstmt.executeQuery();
                
                // Inicializamos el aceso exitoso con valor "false".
                loginsuccesful = false;
                
                // Verificamos si la consulta resultado, "rs", encuentra el usuario, es decir, validamos el resultado.
                if (rs.next()){
                    encryptedPassword = rs.getString("password");
                    int failedAttempts = rs.getInt("failed_attempts");
                    java.sql.Timestamp lastAttemptTimestamp = rs.getTimestamp("last_attempts");
                    LocalDateTime lastAttempt = lastAttemptTimestamp != null ? lastAttemptTimestamp.toLocalDateTime() : null;
                    
                    // Comproamos si el usuario est� bloqueado inicialmente.
                    if (failedAttempts >= 3 && lastAttempt != null && Duration.between(lastAttempt, LocalDateTime.now()).toMinutes() < 5){
                        // Declaramos dos variables n�mericas largas "long" con las que calcular el tiempo registrado en el �ltimo intento de conexi�n antes del bloqueo. Y, el tiempo m�ximo a estar bloqueado
                        long timeSinceLastConnection = 5 - Duration.between(lastAttempt, LocalDateTime.now()).toMinutes();/* Inicialmente el registro se har� en milisegundos. */
                        long timeFiveMinutes = 60 - Duration.between(lastAttempt, LocalDateTime.now()).minusMinutes(timeSinceLastConnection).getSeconds(); /* Pasamos los cinco (5) minutos a milisegundos. [5 veces (minutos) * 60 segundos (1 minuto) * 1000 milisegundos (1 segundo = 1000 milisegundos)]. */
                        
                        // verificamos si el tiempo transcurrido entre la �ltima conexi�n es igual o menor que el tiempo m�ximo dado para el bloqueo del usuario.
                        if (timeSinceLastConnection <= timeFiveMinutes){
                            // Declaramos una variable n�merica larga "long" con la que calcular el tiempo restante que queda como resultado entre el tiempo actual, en el momento de su ejecuci�n, menos el tiempo registrado en el �ltimo intento de conexi�n antes del bloqueo.
                            long timeLeft = (timeFiveMinutes - timeSinceLastConnection);
                            JOptionPane.showMessageDialog (null, "La cuenta ha sido bloqueada. Vuelva a intentarlo dentro de (" + timeLeft + ") segundos.");
                            continue; /* Conti�a/Va directamente al siguiente ciclo del do-while. */
                        } else{
                            // En caso de que el tiempo m�ximo de bloqueo ya haya transcurrido reiniciamos el conteo de intentos.
                            resetsql = "UPDATE users SET failed_attempts = 0 WHERE username = ?"; /* Usamos una nueva consulta, "resetsql", pero podr�amos volver a usar la sentencia "sql", siendo �sta su segunda consulta, rescribiendo la anterior. Pero para mejor claridad y reutilizaci�n usamos una nueva declaraci�n para una nueva consulta. */
                            PreparedStatement resetStmt = connection.prepareStatement(resetsql);
                            
                            // El "1" funcionar� como array, sustituyendo su valor por los (?) del String "Consulta". Funcionando como una especie de array.
                            resetStmt.setString(1, username);
                            
                            // Se ejecuta la consulta.
                            resetStmt.execute();
                            
                            // Se cierra o finaliza la consulta, pues ya no interesa ya que ya se ha terminado de restaurar el contador.
                            resetStmt.close();
                            
                            // Conteo de intentos a cero (0).
                            failedAttempts = 0;
                        }
                    }
                    
                    // Ahora s� que pedimos la contrase?a.
                    System.out.print("Now, enter your password: ");
                    password = user.nextLine();
                    
                    // Ahora, tras verificar la existencia, verificamos la validez de la contrase?a introducida respecto a la que se encuentra almacenada de forma encriptada.
                    if (BCrypt.checkpw(password, encryptedPassword)){ // Igual a decir que "loginsuccesful = BCrypt.checkpw(password, encryptedPassword);".
                        System.out.println("\nInicio de sesi�n habilitado. Bienvenido, " + username + ".");
                        loginsuccesful = true;
                        
                        // De nuevo, y de forma similar "else" anterior, si el usuario introduce correctamente la contrase?a, reiniciamos el conteo de intentos. La diferencia con el "else" anterior es que directamente cerramos la consulta sin volver a poner el n�mero de intentos, "failedAttempts", pues el usuario ya se ha logeado y no requiere de volver a ponerla.
                        resetsql = "UPDATE users SET failed_attempts = 0 WHERE username = ?";
                        PreparedStatement resetStmt = connection.prepareStatement(resetsql);
                        
                        // El "1" funcionar� como array, sustituyendo su valor por los (?) del String "Consulta". Funcionando como una especie de array.
                        resetStmt.setString(1, username);
                            
                        // Se ejecuta la consulta.
                        resetStmt.execute();
                            
                        // Se cierra o finaliza la consulta, pues ya no interesa ya que ya se ha terminado de restaurar el contador.
                        resetStmt.close();
                        
                    // Por el contrario, en caso de que la contrase?a se haya introducido err�neamente o no coincida con la encriptaci�n de la almacenada aumentaremos el n�mero de intentos fallidos (+1), as� hasta llegar a su m�ximo de intentos (3).
                    } else{
                        System.out.println("\nInicio de sesi�n denegado. El usuario o la contrase?a es incorrecto.");
                        
                        // Aumentamos el contador y registramos el momento en que se fall�.
                        failedAttempts++;
                        String updateSql = "UPDATE users SET failed_attempts = ?, last_attempts = ? WHERE username = ?";
                        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                        
                        // El "1" establecer� el valor del primer par�metro (?) de la consulta "SQL" como un n�mero entero "int" que contiene la variable "failedAttempts".
                        updateStmt.setInt(1, failedAttempts);
                        
                        // El "2" funcionar� como array, sustituyendo su valor por los (?) del String "Consulta". Funcionando como una especie de array.
                        updateStmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                        
                        // El "3" funcionar� como array, sustituyendo su valor por los (?) del String "Consulta". Funcionando como una especie de array.
                        updateStmt.setString(3, username);
                        
                        // Se ejecuta la consulta.
                        updateStmt.executeUpdate();
                        
                        // Se cierra o finaliza la consulta.
                        updateStmt.close();
                        
                        // Incremento del conteo de intentos. 
                        countAttenpts++;
                        
                        if (!loginsuccesful && countAttenpts < maxAttenpts){
                        System.out.println("\nVuelva a intentarlo de nuevo. Intento n�mero " + (countAttenpts + 1) + " de " + maxAttenpts + ".");
                        }
                    }
                } else{
                    System.out.println("\nInicio de sesi�n denegado. La contrase?a esa incorrecta o no existe.");
                }
                
            // Se ejecutar� el bucle hasta que no se cumplan las dos condiciones impuestas.
            } while (!loginsuccesful && countAttenpts < maxAttenpts);
            
            // Caso para cuando se exceda el n�mero de intentos.
            if (!loginsuccesful || countAttenpts > maxAttenpts){
                System.out.println("Has excedido el n�mero de intentos m�ximo (3). Acceso bloqueado.");
            }
        
        } catch (ClassNotFoundException ex){ /* Capturamos el posible error que puede surgir al cargar el driver, es decir, en "Class.forName". */
            System.err.println("Error al cargar el driver del SGBD: " + ex.getMessage());
        } catch (SQLException ex){/* Capturamos el posible error que puede surgir al cargar o intentar conectarse a la base de datos. */
            System.err.println("Error al conectarse a la base de datos o al realizar la consulta/sentencia: " + ex.getMessage());
        } finally{ /* Creamos o capturamos la �ltima sentencia, es decir, el cierre de la base de datos tras terminar de utilizarla. */
            try{
                if (rs != null){ /* Tambi�n se puede escribir de la siguiente forma: "if (rs != null) rs.close();". */
                    rs.close();
                }
                if (pstmt != null){
                    pstmt.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException ex){
                System.out.println("Error al cerrar o finalizar la Conexi�n." + ex.getMessage());
            }
        }
        
        // Se cierra el esc�ner "user".
        user.close();
    }
}