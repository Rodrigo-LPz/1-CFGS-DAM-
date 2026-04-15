/**
 *
 * @author Rodrigo
 */
package com.mongodb.grud;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.*;
import java.util.*;
import static java.util.Locale.*;
import javax.swing.*;
import org.bson.*;
import org.bson.conversions.*;


public class GRUD{

    public static void main(String[] args){
        // Cadena/Ruta de conexion con la base de datos MongoDB.
        String uri = "mongodb://localhost:27017";

        // Se abre la conexión con MongoDB.
        try (MongoClient mongoClient = MongoClients.create(uri)){
            // Obtiene o crea una base de datos MongoDB desde Java.
            MongoDatabase database = mongoClient.getDatabase("My_Data_Base");
            System.out.println("\nBase de datos creada o conectada.");
            
            // Obtiene o crea una colección.
            MongoCollection<Document> collection = database.getCollection("my_collection");
            System.out.println("Colección creada o conectada.");
            
            //Operaciones 'CRUD' dentro de la colección.
            
                // Operación de insercción de un documento en una colección de MongoDB.
            //        Document data = new Document().append("name", "Pedro").append("age", 22);
            //        InsertOneResult insertOneResult = collection.insertOne(data);
            //        System.out.println(insertOneResult.getInsertedId());
        
                // Insercción de varios documentos de golpe en una colección de MongoDB.
            //        List<Document> severalData = new ArrayList<>();
            //        severalData.add(new Document().append("name", "Elena").append("age", 33));
            //        severalData.add(new Document().append("name", "Ana").append("age", 41));
            //        InsertManyResult insertManyResult = collection.insertMany(severalData);
            //        System.out.println(insertManyResult.getInsertedIds());
        //------------------------------------------------------------------------------------------------------------------------------    
        
                // Operación de insercción/búsqueda/consulta de un campo en un documento en una colección de MongoDB.
                    // Primero Obtenemos todos los documentos.
                //        FindIterable<Document> allCollection = collection.find();
                //        System.out.println("\n--- find() result ---");
                //        allCollection.forEach(document -> System.out.println(document));
            
                    // Ahora sí, realizamos la consulta de un campo dentro del documento.
                //        Bson filter = Filters.eq("name", "Pedro");
                //        FindIterable<Document> elementsFound = collection.find(filter);
                //        System.out.println("\n--- find(filter) result ---");
                //        elementsFound.forEach(document -> System.out.println(document));
        //------------------------------------------------------------------------------------------------------------------------------    
        
                // Operación de modificación de un documento en una colección de MongoDB.
            //        Bson newAge = Updates.set("age", 23);
            //        UpdateResult updateOne = collection.updateOne(filter, newAge);
            //        System.out.println(updateOne.getMatchedCount
        //------------------------------------------------------------------------------------------------------------------------------    
        
                // Operación de borrado/eliminación de un campo en un documento o de un documento en una colección de MongoDB.
                    // Borrado para/de un campo.
                //        DeleteResult deleteResult = collection.deleteMany(filter);
                //        System.out.println("\n--- Number of deleted elements with filter ---");
                //        System.out.println(deleteResult.getDeletedCount());
                
                    // Borrado para/de todos los documentos de la colección.
                //        deleteResult = collection.deleteMany(Filters.empty());
                //        System.out.println("\n--- Number of deleted elements with empty filter ---");
                //        System.out.println(deleteResult.getDeletedCount());
        //------------------------------------------------------------------------------------------------------------------------------    
        
                // Operación de eliminación de una colección de MongoDB.
                    // Eliminación de una coleccion de MongoDB.
                //        collection.drop();
                
                    // Eliminación de una base de datos de MongoDB.
                //        database.drop();
        
        // Capturamos a la excepción de conexión con la base d edatos.
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error: Falla al conectarse con MongoDB" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}