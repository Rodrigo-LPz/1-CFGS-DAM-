/**
 *
 * @author Rodrigo
 */
package com.mongodb.bdgestionjugadores;

// Importaciones de librerí­as de la base de datos de MongoDB.
    // Importa todos los paquetes de la API "client", como por ejemplo "com.mongodb.client.MongoClient" o "com.mongodb.client.MongoClients".
    import com.mongodb.client.*;
    // Importa el paquete "Document".
    import org.bson.Document;

// Importaciones de librerí­as de Java.
    // Importa todos los paquetes de la API "util", como por ejemplo "java.util.Scanner".
    import java.util.*;


// Se crea la clase "ListadoPorPosicionJugadores", la cual hará la función de listar/buscar el registro de los jugadores que se encuentren dentro de la colección mediante su posición natural dentro del campo (a modo de filtro).
public class ListadoPorPosicionJugadores{
    // Declara un método privado para realizar operaciones CRUD dentro de una colección de documentos en MongoDB.
    private final MongoCollection<Document> collection;

    // Crea un constructor que recibe la colección, el atributo privado "collection" creado anteriormente.
    public ListadoPorPosicionJugadores(MongoCollection<Document> collection){
        this.collection = collection;
    }

    // Declara un método público, "ejecutarListadoJugador", para ejecutar la acción de listar/buscar a un jugador.
    public void ejecutarListadoPorPosicionJugador(){
        // Crea un escáner con el que poder interactuar con el usuario a través de la consola.
        Scanner user = new Scanner(System.in);
        
        // Muestreo de instrucciones previas.
        System.out.println("\nA continuación siga las indicaciones dadas introduciendo los valores acorde a lo que se le solicite en el momento:");

        // Muestreo de la acción a realizar.
        System.out.println("\n\n\t<=== BÚSQUEDA DE JUGADORES POR POSICIÓN ====>\n");

        // Recupera todos los documentos, jugadores, de la colección.
        FindIterable<Document> jugadores = collection.find();

        // Crea una función con la que filtrar datos desde la base de datos de "MongoDB".
        Document filtroJugador;

        // Asignación de variables numéricas y no numéricas.
        String parametro, parametroFinal;
        boolean existenJugadores = false; /* Declara una variable de tipo "boolean" con el fin de controlar si la colección está vacĂ­a. */

        // Declara un bucle de tipo "while" con el que solicitar al usuario la posición del jugador.
        while (true){
            // Muestreo de las indicaciones instrucciones a seguir por el usuario.
            System.out.print("\nPor favor, introduzca la posición natural a buscar (Guardameta, Defensa, Mediocampista o Delantero): ");
            parametro = user.nextLine().trim();    
            parametroFinal = Character.toUpperCase(parametro.charAt(0)) + parametro.substring(1).toLowerCase();

            // Valida que el valor introducido sea una de las posiciones válidas.
            if (parametroFinal.matches("Guardameta|Defensa|Mediocampista|Delantero")){
                break; /* Se comprueba que el valor es el esperado, es correcto y se sale del condicional "if". */
            } else {
                // Muestreo del resultado.
                System.err.println("ERROR: el valor introducido como posición {" + parametroFinal + "} no es válido. Recuerde que el valor a introducir deberá ser uno de los siguientes: 'Guardameta', 'Defensa', 'Mediocampista' o 'Delantero'.");
                return;    
            }
        }

        filtroJugador = new Document("Posición", parametroFinal);

        // Activa el filtro y ejecuta la búsqueda del/de los jugador/es que coincidan con el parámetro, posición, introducido dentro del campo solicitado, "parametroFinal".
        FindIterable<Document> resultado = collection.find(filtroJugador);

        // Muestreo del resultado final de la búesqueda filtrada.
        System.out.println("\n\n\t<=== RESULTADO DE BÚSQUEDA ===>\n");

        // Crea un bucle de tipo "for-each" con el que recorrer y mostrar todos los documentos, jugadores, de la colección coincidentes al parámetro solicitado/especificado.
        for (Document jugador : resultado){
            existenJugadores = true;

            System.out.println("Nombre    : " + jugador.getString("Nombre"));
            System.out.println("Edad      : " + jugador.getInteger("Edad") + " años");
            System.out.println("Dorsal    : " + jugador.getInteger("Dorsal"));
            System.out.println("Posición  : " + jugador.getString("Posición"));
            System.out.println("<-------------------------------------------------------------------------->\n\n");
        }

        // Crea un condicional de tipo "if" para comprobar si la búsqueda da un resultado o no en base a los documentos, jugadores, registrados en la colección.
        if (!existenJugadores){
            System.err.println("ERROR: Fallo en nuestro sistema al encontrar el/los jugador/es coincidentes con los datos ingresados como parámetro de búsqueda {" + parametro +"} para/dentro del campo 'Posición'. O bien ese jugador no existe o no está recogido en nuestra base de datos.");
        }

        // Cierra el escáner.
        //user.close();
    }
}