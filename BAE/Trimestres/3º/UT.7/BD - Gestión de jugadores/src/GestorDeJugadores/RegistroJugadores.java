/**
 *
 * @author Rodrigo
 */
package GestorDeJugadores;

// Importaciones de librerías de la base de datos de MongoDB.
    // Importa todos los paquetes de la API "client", como por ejemplo "com.mongodb.client.MongoClient" o "com.mongodb.client.MongoClients".
    import com.mongodb.client.*;
    // Importa el paquete "Document".
    import org.bson.Document;

// Importaciones de librerías de Java.
    // Importa todos los paquetes de la API "util", como por ejemplo "java.util.Scanner".
    import java.util.*;

// Se crea la clase "RegistroJugadores" esta hará la función de añadir nuevos registros, jugadores, a la colección.
public class RegistroJugadores{
    // Declara un método privado para realizar operaciones CRUD dentro de una colección de documentos en MongoDB.
    private final MongoCollection<Document> collection;

    // Crea un constructor que recibe la colección, el atributo privado "collection" creado anteriormente.
    public RegistroJugadores(MongoCollection<Document> collection){
        this.collection = collection;
    }

    // Declara un método público, "ejecutarRegistroJugador", para ejecutar la acción de registrar un nuevo jugador.
    public void ejecutarRegistroJugador(){
        // Crea un escáner con el que poder interactuar con el usuario através de la consola.
        Scanner user = new Scanner(System.in);

        // Muestreo de instrucciones previas.
        System.out.println("\nA continuación siga las indicaciones dadas introduciendo los valores acorde a lo que se le solicite en el momento:");

        // Muestreo de la acción a realizar.
        System.out.println("\n\n\t<=== REGISTRO DE NUEVOS JUGADORES ====>");

        // Crea una función con la que filtrar datos desde la base de datos de "MongoDB".
        Document filtroDorsal, registroNuevoJugador;

        // Creación de las variables a usar.
        String nombre, posicion;
        int edad, dorsal;
        long totalJugadores

        // Declara un condicional de tipo "if" con el que validar hasta un máximo de 26 registros, jugadores.
        totalJugadores = collection.countDocuments();
        if (totalJugadores >= 26) {
            System.err.println("ERROR: Ya se ha alcanzado el máximo permitido de jugadores registrados (26) por club. No se pueden añadir más jugadores.");
            return;
        }

        // Crea un bucle de tipo "while" para el nombre del jugador.
        while (true){
            // Solicitud de los datos del jugador al usuario.
            System.out.print("\nPor favor, introduzca el nombre completo del jugador: ");
            nombre = user.nextLine().trim();

            // Crea un condicional de tipo "if" para validar un registro más realista para el campo "Nombre".
            if (nombre.length() < 2){
                System.err.println("ERROR: El valor introducido como nombre no es válido. Recuerde que debe contener al menos 2 caracteres.");
            } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚÜäëïöüÄËÏÖÜàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛñÑ\\s]+")){ /* El atributo ".matches" sirve para filtrar que una cadena de texto, en este caso, cumpla con al menos una de las expresiones regulares impuestas, "regex". */
                System.err.println("ERROR: El valor introducido como nombre {" + nombre + "} no es válido. Recuerde que el valor introducido no puede contener ni números ni símbolos.");
            } else{
                break; /* Se comprueba que el valor es el esperado, es correcto y se sale del condicional "if". */
            }
        }

        // Crea un bucle de tipo "while" para la edad del jugador.
        while (true){
            System.out.print("\nPor favor, ahora introduzca la edad del jugador: ");
            if (!user.hasNextInt()){
                System.err.println("ERROR: El valor introducido como edad no es válido. Recuerde que debe ser un número entero válido.");
                user.next(); /* Se descarta la entrada inválida introducida por el usuario. */
                continue; /* Se salta el resto del código dentro del ciclo actual, del bucle "while", y pasa directamente a la siguiente iteración del bucle. */
            }
    
            edad = user.nextInt();
            user.nextLine(); /* Limpia el buffer, de esta manera nos aseguramos de que la lectura de código durante la ejecución no se salte nada. */
    
            if (edad < 12 || edad > 65){
                System.err.println("ERROR: El valor introducido como edad {" + edad + "} no es válido. Recuerde que el valor introducido debe estar comprendido entre los 12 y 65 años de edad.");
            } else{
                break; /* Valida el valor introducido y sale del condicional, del "if". */
            }
        }

        // Crea un bucle de tipo "while" para el dorsal (número de camiseta del jugador).
        while (true){
            System.out.print("\nNuevamente, por favor, introduzca el dorsal (número de camiseta del jugador): ");
            if (!user.hasNextInt()){
                System.err.println("ERROR: El valor introducido como dorsal no es válido. Recuerde que debe ser un número entero válido.");
                user.next(); // Se descarta la entrada inválida introducida por el usuario.
                continue; /* Se salta el resto del código dentro del ciclo actual, del bucle "while", y pasa directamente a la siguiente iteración del bucle. */
            }
    
            dorsal = user.nextInt();
            user.nextLine(); /* Limpia el buffer, de esta manera nos aseguramos de que la lectura de código durante la ejecución no se salte nada. */
        
            if (dorsal < 1 || dorsal > 99){
                System.err.println("ERROR: El valor introducido como dorsal {" + dorsal + "} no es válido. Recuerde que el valor introducido debe estar comprendido entre los números 1 y 99, ambos incluidos.");
            } else{
                // Declara un condicional de tipo "if" para validar la existencia de un dorsal único por jugador.
                filtroDorsal = new Document("Dorsal", dorsal);

                if (collection.find(filtroDorsal).first() != null){
                    System.err.println("ERROR: Ya existe un jugador con el número de camiseta o dorsal {" + dorsal + "} en el club.");
                } else{
                    break; /* Se comprueba que el valor es el esperado, es correcto y se sale del condicional "if". */
                }
            }
        }

        // Crea un bucle de tipo "while" para la posición natural del jugador.
        while (true){
            System.out.print("\nFinalmente, por favor, introduzca la posición natural a cubrir por el jugador (por ejemplo: Guardameta, Defensa, Mediocampista o Delantero): ");
            posicion = user.nextLine().trim();
    
            if (posicion.equalsIgnoreCase("Guardameta") || posicion.equalsIgnoreCase("Defensa") || posicion.equalsIgnoreCase("Mediocampista") || posicion.equalsIgnoreCase("Delantero")){
                // Formatea la cadena "posición" poniendo el primer carácter, la primera letra, en mayúscula.
                posicion = Character.toUpperCase(posicion.charAt(0)) + posicion.substring(1).toLowerCase();
                break;
            } else{
                System.err.println("ERROR: El valor introducido como posición {" + posicion + "} no es válido. Recuerde que debe coincidir/situarse entre una de estas cuatro: {Guardameta, Defensa, Mediocampista o Delantero}.");
            }
        }

        // Crea el documento con los datos introducidos validados.
        registroNuevoJugador = new Document("Nombre", nombre).append("Edad", edad).append("Dorsal", dorsal).append("Posición", posicion);

        // Inserta en la colección los datos del nuevo jugador registrado.
        try{
            collection.insertOne(registroNuevoJugador);
            System.out.println("\nEnhorabuena, el nuevo jugador ha sido registrado exitosamente dentro del club.");
        } catch (Exception e){
            System.err.println("ERROR: Fallo al registrar el jugador: " + e.getMessage());
        }

        // No se cierra el escáner pues interesa que se pueda seguir usándolo el menú.
        /* user.close(); */
    }
}