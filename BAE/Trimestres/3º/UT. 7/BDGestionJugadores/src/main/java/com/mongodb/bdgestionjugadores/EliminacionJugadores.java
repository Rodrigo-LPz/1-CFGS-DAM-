/**
 *
 * @author Rodrigo
 */
package com.mongodb.bdgestionjugadores;

// Importaciones de librerí­as de la base de datos de MongoDB.
    // Importa todos los paquetes de la API "client" y "client.result", como por ejemplo "com.mongodb.client.MongoClient" o "com.mongodb.client.MongoClients" y "com.mongodb.client.result.UpdateResult".
    import com.mongodb.client.*;
    import com.mongodb.client.result.*;
    // Importa el paquete "Document".
    import org.bson.Document;
    // Importa el paquete "ObjectId".
    import org.bson.types.ObjectId;

// Importaciones de librerí­as de Java.
    // Importa todos los paquetes de la API "util", como por ejemplo "java.util.Scanner".
    import java.util.*;


// Se crea la clase "EliminacionJugadores" esta hará la función de gestionar la eliminación de jugadores registrados en nuestra colección.
public class EliminacionJugadores{
    // Declara un método privado para realizar operaciones CRUD dentro de una colección de documentos en MongoDB.
    private final MongoCollection<Document> collection;

    // Crea un constructor que recibe la colección, el atributo privado "collection" creado anteriormente.
    public EliminacionJugadores(MongoCollection<Document> collection){
        this.collection = collection;
    }

    // Declara un método público, "ejecutarEliminacionJugador", para ejecutar la acción de eliminar a un jugador de la colección.
    public void ejecutarEliminacionJugador(){
        // Crea un escáner con el que poder interactuar con el usuario a través de la consola.
        Scanner user = new Scanner(System.in);

        // Muestreo de instrucciones previas.
        System.out.println("\nA continuación siga las indicaciones dadas introduciendo los valores acorde a lo que se le solicite en el momento:");

        // Muestreo de la acción a realizar.
        System.out.println("\n\n\t<=== ELIMINACIí“N DE JUGADOR ====>");

        // Crea unas funciones con las que filtrar, seleccionar y realizar la operación sobre los datos desde la base de datos de "MongoDB".
        Document filtroJugador, jugadorFiltrado, jugadores;

        // Asignación de variables numéricas y no numéricas.
        String campo, campoFinal, parametro, respuesta, respuestaConfirmada;
        int numeroDeLista;

        // Pregunta al usuario por el campo a buscar a dicho jugador en concreto/especí­fico.
        System.out.println("\n¿Por cuál campo/parámetro le gustarí­a empezar a filtrar la búsqueda del jugador? (Nombre / Dorsal / Posición)"); /* Se obvia el parámetro "Edad" pues para la acción que se va a ejecutar posteriormente no es coherente buscar a dicho jugador por su edad, esto se debe a que por lo general, puede darse el caso de que al menos dos jugadores compartan la misma edad. */
        campo = user.nextLine().trim();
        campoFinal = Character.toUpperCase(campo.charAt(0)) + campo.substring(1).toLowerCase();

        // Crea un bucle de tipo "while" a modo de comprobante para validar el valor final obtenido o introducido en la variable "campoFinal".
        while (!campoFinal.equals("Nombre") && !campoFinal.equals("Dorsal") && !campoFinal.equals("Posición") && !campoFinal.equals("Posicion")){
            System.out.println("ERROR: El valor introducido como campo de búsqueda o filtrado {" + campoFinal + "} no es válido. Recuerde que el valor del campo a introducir deberá ser 'Nombre', 'Dorsal' o 'Posición'.");
            
            // Brinda una nueva oportunidad de introducir el valor correcto.
            campo = user.nextLine().trim();
            campoFinal = Character.toUpperCase(campo.charAt(0)) + campo.substring(1).toLowerCase();
        }

        // Muestreo del siguiente paso/acción a realizar por el usuario.
        System.out.println("\nEn ese caso, por favor, introduzca el valor de parámetro de búsqueda del campo {" + campoFinal + "} a buscar: ");
        parametro = user.nextLine().trim();

        // Crea un condicional de tipo "if" para realizar la búsqueda de jugadores por dorsal.
        if (campoFinal.equals("Dorsal")){
            // Crea un bloque de tipo "try-catch" para efectuar la búsqueda del filtro sobre el/los jugador/es que entren dentro del parámetro introducido.
            try{
                int parametroNumerico = Integer.parseInt(parametro);
                filtroJugador = new Document(campoFinal, parametroNumerico);
            } catch (NumberFormatException  e){
                System.err.println("ERROR: El valor introducido como parámetro de búsqueda {" + parametro + "} para el campo {" + campoFinal + "} no es válido. Recuerde que el valor introducido como parámetro deberá ser un número entero válido.");
                return;
            }

        // Crea el caso contrario del anterior condicional, del "if", para realizar la búsqueda de jugadores por nombre o posición.
        } else{
            /*
              *
               *
                * La expresión regular "$regex" indica que se usará una expresión regular (búsqueda por patrón/token), esto a modo de dirección.
                * Todo esto en conjunto dará como resultado que el valor de la variable "parámetro" a buscar dentro del "campo" tendrá que ser estrictamente igual al valor introducido por el usuario, sin que haya ningún otro carácter antes o después de la cadena de texto.
                * Por otro lado, la expresión regular "$options" se utiliza, es es una clave de "MongoDB" que permite modificar el comportamiento del "regex".
                * En cambio, la expresión regular "i" (de "insensitive"), indica que no debe importar si es mayúscula o minúscula.
               *
              *
            */
            filtroJugador = new Document(campoFinal, new Document("$regex", parametro).append("$options", "i")); /* Se realiza una búsqueda de tipo "Flexible" a fines de que se encuentre un jugador en una cobertura de caso mayor, más amplia. */
        }

        // Crea una lista donde se almacenarán temporalmente los jugadores que coincidan con el filtro de búsqueda aplicado.
        List<Document> coincidencias = new ArrayList<>();

        // Crea un bucle de tipo "for-each" con el que recorrer cada documento, jugador, que coincida con el filtro aplicado y aí±adirlo a la lista "coincidencias".
        for (Document jugador : collection.find(filtroJugador)){
            coincidencias.add(jugador); /* Lo que se está haciendo es crear una colección de datos temporal, en este caso una lista, "List"; donde almacenar los jugadores coincidentes al filtro creado anteriormente. Y, finalmente, con el bucle, aí±adir ese jugador a la lista. */
        }

        // Declara un condicional de tipo "if" con el que recoger el/los casos en el que el valor de la variable "coincidencias" se encuentre vací­o.
        if (coincidencias.isEmpty()){
            System.err.println("ERROR: Dado el filtro de búsqueda impuesto {" + filtroJugador + "} no se ha encontrado ningún jugador que coincida con la búsqueda dentro o propio a la colección que se está trabajando.");
            return;

        // Crea un condicional de tipo "if" para acoger el/los casos en el que el filtro obtenga y arroje como resultado a más de un jugador de forma simultánea.
        } else if (coincidencias.size() > 1){
            // Muestreo del caso por pantalla.
            System.out.println("\nDado el filtro de búsqueda impuesto, esta ha resultado en varios jugadores:");

            // Crea un bucle de tipo "for" con el que recorrer cada jugador almacenado (encontrado) en la lista temporal, en "coincidencias", e irlos mostrando por pantalla.
            for (int i = 0; i < coincidencias.size(); i++){
                jugadores = coincidencias.get(i);
                System.out.println("\n" + (i + 1) + ".\t Nombre: " + jugadores.getString("Nombre") + " | Edad: " + jugadores.getInteger("Edad") + " | Dorsal: " + jugadores.getInteger("Dorsal") + " | Posición: " + jugadores.getString("Posición"));
            }

            // Declara un bucle de tipo "while" con el que seleccionar al jugador concreto a modificar/actualizar (sus registros/datos).
            while (true){
                // Muestreo de las instrucciones a seguir:
                System.out.print("\nSeleccione el número de lista del jugador que desea eliminar: ");

                // Declara un condicional de tipo "if" a fin de comprobar que el valor introducido por el usuario es numérico, es decir, un número entero válido.
                if (user.hasNextInt()){
                    numeroDeLista = user.nextInt();
                    user.nextLine(); /* Limpia el buffer, de esta manera nos aseguramos de que la lectura de código durante la ejecución no se salte nada. */

                    // Crea un condicional de tipo "if" para poder comprobar que el número introducido esté comprendido dentro del rango de opciones disponibles.
                    if (numeroDeLista >= 1 && numeroDeLista <= coincidencias.size()){
                        break; /* Valida el valor introducido y sale del condicional, del "if". */
                    } else{
                        System.err.println("ERROR: El valor/número de lista introducido {" + numeroDeLista + "} no es reconocido por nuestro sistema o se encuentra fuera del rango de opciones disponibles. Inténtelo nuevamente.");
                    }

                // Crea una cobertura para los casos en los que el usuario introduzca un valor no numérico.
                } else{
                    System.err.println("ERROR: El sistema reconoce que el valor que está introduciendo no corresponde con un valor numérico válido. Inténtelo de nuevo.");
                    user.nextLine(); /* Limpia el buffer, de esta manera nos aseguramos de que la lectura de código durante la ejecución no se salte nada. */
                }
            }

            // Asigna a la variable "jugadorFiltrado" el jugador correspondiente a la opción elegida.
            jugadorFiltrado = coincidencias.get(numeroDeLista - 1); /* Se empieza restando por (1) ya que las posiciones de los í­ndices comienzan en (0). */

        // Cubre el caso restante, aquel en el que sólo haya un jugador en la lista de coincidencias, asignándole directamente su correspondiente a "jugadorFiltrado".
        }else{
            jugadorFiltrado = coincidencias.get(0); /* Dado que es el único jugador que ha pasado los filtros, que tiene dichas coincidencias, ocupará la primera posición, que en los í­ndices será el (0). */
        }

        // Muestreo de los datos obtenidos, de los jugadores encontrados.
        System.out.println("\nEl jugador seleccionado a eliminar es:\n\tNombre: " + jugadorFiltrado.getString("Nombre") + "\n\tEdad: " + jugadorFiltrado.getInteger("Edad") + " aí±os\n\tDorsal: " + jugadorFiltrado.getInteger("Dorsal") + "\n\tPosición: " + jugadorFiltrado.getString("Posición"));

        // Confirmación de la acción 'borrado' al usuario para mayor seguridad.
        System.out.print("\n{" + jugadorFiltrado + "} es el jugador seleccionado. ¿Está seguro de querer eliminarlo? → (Sí­ / No): ");
        respuesta = user.nextLine().trim();
        respuestaConfirmada = Character.toUpperCase(respuesta.charAt(0)) + respuesta.substring(1).toLowerCase();

        // Declara un condicional de tipo "if" con el que cubrir los casos de respuestas 'No' a la confirmación de borrado.
        if (respuestaConfirmada.equals("No")){
            // Muestreo del resultado.
            System.out.println("Acción de borrado declinada por el usuario. El jugador no ha sido eliminado/borrado de la colección.");
            return;

        // Cobertura de tipo condicional "else-if" para los casos de respuesta "No".
        } else if (!respuestaConfirmada.equals("Sí­") && !respuestaConfirmada.equals("Si")){
            System.err.println("ERROR: El valor introducido como respuesta {" + respuestaConfirmada + "} no es válido. Recuerde que la respuesta a introducir deberá ser o bien 'Sí­' o bien 'No'.");
            return;
        }

        // Ejecuta la acción de borrado/eliminación usando el ID del documento.
        ObjectId idJugador = jugadorFiltrado.getObjectId("_id"); /* El atributo "_id" se asigna automáticamente a cada documento que se crea bajo "MongoDB". Este actuará como identificador único de dicho documento (Como si fuese un DNI). */
        DeleteResult resultado = collection.deleteOne(new Document("_id", idJugador)); /* Recoge o coteja el objeto/documento, jugador, que comparta la misma dirección, el mismo 'ID' y después lo elimina de la colección. */

        // Muestreo del resultado final de la ejecución.
        if (resultado.getDeletedCount() > 0){
            System.out.println("\nEl jugador seleccionado {" + jugadorFiltrado + "} ha sido eliminado/borrado correctamente de la colección.");
        } else {
            System.err.println("ERROR: Fallo en la eliminación del jugador. Intente nuevamente.");
        }

        // Cierra el escáner.
        // user.close();
    }
}