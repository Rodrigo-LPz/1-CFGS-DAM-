/**
 *
 * @author Rodrigo
 */
package com.mongodb.bdgestionjugadores;

// Importaciones de librerías de la base de datos de MongoDB.
    // Importa todos los paquetes de la API "client", como por ejemplo "com.mongodb.client.MongoClient" o "com.mongodb.client.MongoClients".
    import com.mongodb.client.*;
    // Importa el paquete "Document".
    import org.bson.Document;

// Importaciones de librerías de Java.
    // Importa todos los paquetes de la API "util", como por ejemplo "java.util.Scanner".
    import java.util.*;


// Crea la clase "BDGestionDeJugadores" donde conectar y crear la base de datos en MongoDB.
public class BDGestionDeJugadores{
    // Declara un método privado para realizar operaciones CRUD dentro de una colección de documentos en MongoDB.
    private MongoCollection<Document> collection;
    // Declara un método privado con el que hacer la conexión con la base de datos.
    private MongoClient mongoClient;
    // Declara un método privado con la cual crear la base de datos.
    private MongoDatabase mongoDatabase;
    
    // Declara un método con el atributo escáner privado y final para leer la entrada del usuario desde la consola.
    private final Scanner user = new Scanner(System.in);
    
    // Crea un método público.
    public BDGestionDeJugadores(){
        // Declara una variable no numérica con la que hacer la conexión con la base de datos.
        String url = "mongodb://localhost:27017";
        
        // Crea un bloque de tipo 'try-catch' con el que intentar logearse/conectarse, crear la conexión con la base de datos.
        try{
            // Crea una conexión con la base de datos MongoDB dada la url de la variable "String url".
            mongoClient = MongoClients.create(url);
            // Dadas las operaciones CRUD, se obtiene o crea una base de datos MongoDB.
            mongoDatabase = mongoClient.getDatabase("EquipoDeFutbol");
            // Ahora, dentro de la BD se obtiene o crea una colección.
            collection = mongoDatabase.getCollection("Jugadores");

            // Muestreo del resultado obtenido hasta ahora.
            System.out.println("\nConexión con la base de datos {" + mongoDatabase.getName() + "} de MongoDB exitosa/establecida correctamente.\n\tAhora podrá realizar las diferentes operaciones CRUD dentro de su colección {" + collection.getNamespace() + "}.");

        // Captura la excepción/error en caso de que no se pueda conectar/cargar o identificar la base de datos.
        } catch (Exception e){
            System.err.println("ERROR: Fallo en la conexión con la base de datos: " + e.getMessage());
        }
    }

    // Crea un método público para acceder a la colección creada en la base de datos, "Jugadores", desde el archivo "MenuJugadores.java".
    public MongoCollection<Document> getCollection(){
        return collection;
    }

    // Crea un método público para acceder a la colección y ejecutar la función/es dada/s en el archivo "RegistroJugadores.java" desde el archivo "MenuJugadores.java".
    public void registrarJugador(){
        RegistroJugadores registro = new RegistroJugadores(collection);
        registro.ejecutarRegistroJugador();
    }

    // Crea un método público para acceder a la colección y ejecutar la función/es dada/s en el archivo "ListadoJugadores.java" desde el archivo "MenuJugadores.java".
    public void listarJugadores(){
        ListadoJugadores listado = new ListadoJugadores(collection);
        listado.ejecutarListadoJugador();
    }

    // Crea un método público para acceder a la colección y ejecutar la función/es dada/s en el archivo "ActualizacionJugadores.java" desde el archivo "MenuJugadores.java".
    public void actualizarJugador(){
        ActualizacionJugadores registro = new ActualizacionJugadores(collection);
        registro.ejecutarActualizacionJugador();
    }

    // Crea un método público para acceder a la colección y ejecutar la función/es dada/s en el archivo "EliminacionJugadores.java" desde el archivo "MenuJugadores.java".
    public void eliminarJugador(){
        EliminacionJugadores registro = new EliminacionJugadores(collection);
        registro.ejecutarEliminacionJugador();
    }

    // Crea un método público para acceder a la colección y ejecutar la función/es dada/s en el archivo "ActualizacionJugadores.java" desde el archivo "MenuJugadores.java".
    public void buscarPorPosicion(){
        ListadoPorPosicionJugadores registro = new ListadoPorPosicionJugadores(collection);
        registro.ejecutarListadoPorPosicionJugador();
    }

    //Crea un método público con el que cerrar la conexión con la base de datos.
    public void cierreDeConexion(){
        // Declara un condicional de tipo "if" para cerrar la conexión con la base de datos en caso de que la variable "mongoClient" no sea nula.
        if (mongoClient != null){
            mongoClient.close();
            System.out.println("\nConexión con la base de datos de MongoDB {" + mongoDatabase.getName() + "} cerrada correctamente.");
        }
    }
}