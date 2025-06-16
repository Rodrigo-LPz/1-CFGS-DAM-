/**
 *
 * @author Rodrigo
 */
package com.mongodb.bdgestionjugadores;

// Importaciones de librerías de la base de datos de MongoDB.
    // Importa todos los paquetes de la API "client" y "client.result", como por ejemplo "com.mongodb.client.MongoClient" o "com.mongodb.client.MongoClients" y "com.mongodb.client.result.UpdateResult".
    import com.mongodb.client.*;
    import com.mongodb.client.result.*;
    // Importa el paquete "Document".
    import org.bson.Document;

// Importaciones de librerías de Java.
    // Importa todos los paquetes de la API "util", como por ejemplo "java.util.Scanner".
    import java.util.*;


// Se crea la clase "ActualizacionJugadores" esta hará la función de actualizar los datos del registro de los jugadores que se encuentren dentro de la colección.
public class ActualizacionJugadores{
    // Declara un método privado para realizar operaciones CRUD dentro de una colección de documentos en MongoDB.
    private final MongoCollection<Document> collection;

    // Crea un constructor que recibe la colección, el atributo privado "collection" creado anteriormente.
    public ActualizacionJugadores(MongoCollection<Document> collection){
        this.collection = collection;
    }

    // Método auxiliar para obtener un valor como String de manera segura
    private String getStringValue(Document doc, String field) {
        Object value = doc.get(field);
        return value != null ? value.toString() : "N/A";
    }

    // Método auxiliar para obtener un valor entero de manera segura
    private Integer getIntegerValue(Document doc, String field) {
        Object value = doc.get(field);
        if (value == null) return null;
        
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    // Declara un método público, "ejecutarActualizacionJugador", para ejecutar la acción de actualizar los datos de registro de un jugador.
    public void ejecutarActualizacionJugador(){
        // Crea un escáner con el que poder interactuar con el usuario a través de la consola.
        Scanner user = new Scanner(System.in);

        // Muestreo de instrucciones previas.
        System.out.println("\nA continuación siga las indicaciones dadas introduciendo los valores acorde a lo que se le solicite en el momento:");

        // Muestreo de la acción a realizar.
        System.out.println("\n\n\t<=== ACTUALIZACIÓN DE JUGADOR ====>");

        // Crea unas funciones con las que filtrar, modificar/actualizar, seleccionar y realizar la operación sobre los datos desde la base de datos de "MongoDB".
        Document filtroJugador, filtroIdentificador, jugadorFiltrado, jugadores, actualizacion;

        // Asignación de variables numéricas y no numéricas.
        String campo, campoFinal, parametro, parametroActualizado, parametroFormateado, campoActualizado, campoActualizadoFinal;
        int numeroDeLista;

        // Pregunta al usuario por el campo a buscar a dicho jugador en concreto/específico.
        System.out.println("\n¿Por cuál campo/parámetro le gustaría empezar a filtrar la búsqueda del jugador? (Nombre / Dorsal / Posición)"); /* Se obvia el parámetro "Edad" pues para la acción que se va a ejecutar posteriormente no es coherente buscar a dicho jugador por su edad, esto se debe a que por lo general, puede darse el caso de que al menos dos jugadores compartan la misma edad. */
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
                // Búsqueda que considera tanto valores enteros como strings
                filtroJugador = new Document("$or", Arrays.asList(
                    new Document(campoFinal, parametroNumerico),
                    new Document(campoFinal, parametro)
                ));
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

        // Crea un bucle de tipo "for-each" con el que recorrer cada documento, jugador, que coincida con el filtro aplicado y añadirlo a la lista "coincidencias".
        for (Document jugador : collection.find(filtroJugador)){
            coincidencias.add(jugador); /* Lo que se está haciendo es crear una colección de datos temporal, en este caso una lista, "List"; donde almacenar los jugadores coincidentes al filtro creado anteriormente. Y, finalmente, con el bucle, añadir ese jugador a la lista. */
        }

        // Declara un condicional de tipo "if" con el que recoger el/los casos en el que el valor de la variable "coincidencias" se encuentre vacío.
        if (coincidencias.isEmpty()){
            System.err.println("ERROR: Dado el filtro de búsqueda impuesto {" + filtroJugador + "} no se ha encontrado ningún jugador que coincida con la búsqueda dentro o propio a la colección que se está trabajando.");
            return;

        // Crea un condicional de tipo "if" para acoger el/los casos en el que el filtro obtenga o de como resultado a más de un jugador de forma simultánea.
        } else if (coincidencias.size() > 1){
            // Muestreo del caso por pantalla.
            System.out.println("\nDado el filtro de búsqueda impuesto, esta ha resultado en varios jugadores:");

            // Crea un bucle de tipo "for" con el que recorrer cada jugador almacenado (encontrado) en la lista temporal, en "coincidencias", e irlos mostrando por pantalla.
            for (int i = 0; i < coincidencias.size(); i++){
                jugadores = coincidencias.get(i);
                
                // Uso de métodos auxiliares para obtener valores de manera segura
                String nombre = getStringValue(jugadores, "Nombre");
                Integer edad = getIntegerValue(jugadores, "Edad");
                Integer dorsal = getIntegerValue(jugadores, "Dorsal");
                String posicion = getStringValue(jugadores, "Posición");
                
                System.out.println("\n" + (i + 1) + ".\t Nombre: " + nombre + 
                                 " | Edad: " + (edad != null ? edad + " años" : "N/A") + 
                                 " | Dorsal: " + (dorsal != null ? dorsal : "N/A") + 
                                 " | Posición: " + posicion);
            }

            // Declara un bucle de tipo "while" con el que seleccionar al jugador concreto a modificar/actualizar (sus registros/datos).
            while (true){
                // Muestreo de las instrucciones a seguir:
                System.out.print("\nSeleccione el número de lista del jugador que desea actualizar: ");

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
                    System.err.println("ERROR: El sistema reconoce que valor que está introduciendo no corresponde con un valor numérico válido. Inténtelo de nuevo.");
                    user.nextLine(); /* Limpia el buffer, de esta manera nos aseguramos de que la lectura de código durante la ejecución no se salte nada. */
                }
            }

            // Asigna a la variable "jugadorFiltrado" el jugador correspondiente a la opción elegida.
            jugadorFiltrado = coincidencias.get(numeroDeLista - 1); /* Se empieza restando por (1) ya que las posiciones de los índices comienzan en (0). */

        // Cubre el caso restante, aquel en el que sólo haya un jugador en la lista de coincidencias, asignándole directamente su correspondiente a "jugadorFiltrado".
        }else{
            jugadorFiltrado = coincidencias.get(0); /* Dado que es el único jugador que ha pasado los filtros, que tiene dichas coincidencias, ocupará la primera posición, que en los índices será el (0). */
        }

        // Muestreo de los datos actuales/modificados usando métodos auxiliares
        String nombreJugador = getStringValue(jugadorFiltrado, "Nombre");
        Integer edadJugador = getIntegerValue(jugadorFiltrado, "Edad");
        Integer dorsalJugador = getIntegerValue(jugadorFiltrado, "Dorsal");
        String posicionJugador = getStringValue(jugadorFiltrado, "Posición");
        
        System.out.println("\nEl jugador seleccionado a cambiar (sus datos/registros) es:");
        System.out.println("\tNombre: " + nombreJugador);
        System.out.println("\tEdad: " + (edadJugador != null ? edadJugador + " años" : "N/A"));
        System.out.println("\tDorsal: " + (dorsalJugador != null ? dorsalJugador : "N/A"));
        System.out.println("\tPosición: " + posicionJugador);

        // Vuelta a preguntar por el campo, pero esta vez para saber cuál será el campo a cambiar/actualizar del jugador seleccionado.
        System.out.println("\n¿Y cuál es el campo/parámetro que desea cambiar o actualizar del jugador? (Nombre / Edad / Dorsal / Posición)");
        campoActualizado = user.nextLine().trim();
        campoActualizadoFinal = Character.toUpperCase(campoActualizado.charAt(0)) + campoActualizado.substring(1).toLowerCase();

        // Declara un condicional de tipo "if" con el que cubrir el caso/s en el que el usuario haya introducido un valor como "campo" incorrecto o inválido.
        if (!campoActualizadoFinal.equals("Nombre") && !campoActualizadoFinal.equals("Edad") && !campoActualizadoFinal.equals("Dorsal") && !campoActualizadoFinal.equals("Posición") && !campoActualizadoFinal.equals("Posicion")) {
            System.out.println("ERROR: El valor introducido como campo de búsqueda o filtrado {" + campoActualizadoFinal + "} no es válido. Recuerde que el valor del campo a introducir deberá ser 'Nombre', 'Edad', 'Dorsal' o 'Posición'.");
            return;
        }

        // Muestreo de la nueva instrucción a seguir por el usuario.
        System.out.print("\nAhora, por favor, introduzca el nuevo valor a cambiar/actualizar para el campo seleccionado previamente {" + campoActualizadoFinal + "}: ");
        parametroActualizado = user.nextLine().trim();

        // Crea un filtro único para identificar al documento, jugador, seleccionado, a actualizar.
        filtroIdentificador = new Document("_id", jugadorFiltrado.getObjectId("_id")); /* El atributo "_id" se asigna automáticamente a cada documento que se crea bajo "MongoDB". Este actuará como identificador único de dicho documento (Como si fuese un DNI). */

        // Declara un condicional de tipo "switch" con el que gestionar los cambios deseados por el usuario dada un campo solicitado, "campoActualizadoFinal".
        switch (campoActualizadoFinal){
            // Caso para el campo "Nombre".
            case "Nombre":
                if (parametroActualizado.length() < 2 || !parametroActualizado.matches("[a-zA-ZáéíóúÁÉÍÓÚÜäëïöüÄËÏÖÜàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛñÑ\\s]+")){
                    System.err.println("ERROR: El valor introducido como nombre {" + parametroActualizado + "} no es válido. Recuerde que el valor a introducir debe contener al menos (2) carácteres no numéricos ni símbolos.");
                    return;
                }
                actualizacion = new Document("$set", new Document("Nombre", parametroActualizado)); /* El atributo "$set" se utiliza en "MongoDB" para modificar el valor de un campo ya existente en la colección. */
                break;

            // Caso para el campo "Edad".
            case "Edad":
                // Declara un bloque de tipo "try-catch" donde transformar el valor de la cadena a entero numérico.
                try{
                    int numeroEdad = Integer.parseInt(parametroActualizado);

                    // Crea un condicional de tipo "if" para delimitar la edad a introducir.
                    if (numeroEdad < 12 || numeroEdad > 65){
                        System.err.println("ERROR: El valor introducido como edad {" + numeroEdad + "} no es válido. Recuerde que el valor introducido debe estar comprendido entre los 12 y 65 años de edad.");
                        return;
                    }
                    // Guardar como entero para mantener consistencia
                    actualizacion = new Document("$set", new Document("Edad", numeroEdad));
                
                } catch (NumberFormatException e){
                    System.err.println("ERROR: El valor introducido como edad  {" + parametroActualizado + "} no es válido. Recuerde que el valor introducido como parámetro deberá ser un número entero válido (comprendido entre el rango de números que va desde el 12 hasta el 65, ambos incluidos).");
                    return;
                }
                break;
        
            case "Dorsal":
                // Declara un bloque de tipo "try-catch" donde transformar el valor de la cadena a entero numérico.
                try{
                    int numeroDorsal = Integer.parseInt(parametroActualizado);

                    // Crea un condicional de tipo "if" para delimitar el dorsal edad a introducir.
                    if (numeroDorsal < 1 || numeroDorsal > 99){
                        System.err.println("ERROR: El valor introducido como dorsal {" + numeroDorsal + "} no es válido. Recuerde que el valor introducido debe estar comprendido entre los números 1 y 99, ambos incluidos.");
                        return;
                    }
                    // Guardar como entero para mantener consistencia
                    actualizacion = new Document("$set", new Document("Dorsal", numeroDorsal));
                
                } catch (NumberFormatException e){
                    System.err.println("ERROR: El valor introducido como dorsal  {" + parametroActualizado + "} no es válido. Recuerde que el valor introducido como parámetro deberá ser un número entero válido (comprendido entre el rango de números que va desde el 1 hasta el 99, ambos incluidos).");
                    return;
                }
                break;

            case "Posición": case "Posicion":
                // Formatea la cadena "parametroFormateado" poniendo el primer carácter, la primera letra, en mayúscula.
                parametroFormateado = Character.toUpperCase(parametroActualizado.charAt(0)) + parametroActualizado.substring(1).toLowerCase();

                // Crea un condicional de tipo "if" para cubrir los casos
                if (!parametroFormateado.matches("Guardameta|Defensa|Mediocampista|Delantero")){
                    // Muestreo del resultado.
                    System.err.println("ERROR: el valor introducido como posición {" + parametroFormateado + "} no es válido. Recuerde que el valor a introducir deberá ser uno de los siguientes: 'Guardameta', 'Defensa', 'Mediocampista' o 'Delantero'.");
                    return;    
                }
                actualizacion = new Document("$set", new Document("Posición", parametroFormateado));
                break;

            default:
                System.err.println("ERROR: el valor introducido como campo a cambiar/actualizar {" + campoActualizadoFinal+ "} no es válido o no es reconocido por nuestro sistema. Recuerde que el valor a introducir deberá ser uno de los siguientes: 'Nombre', 'Edad', 'Dorsal' o 'Posición'.");
                return;
        }

        // Ahora, una vez tenemos el valor a cambiar registrado sobre el campo que se desea ejecutamos la operación de actualización sobre la base de datos.
        UpdateResult resultado = collection.updateOne(filtroIdentificador, actualizacion);

        // Por último, realizamos una comprobación/verificación para saber si la modificación se ha efectuado correctamente.
        if (resultado.getModifiedCount() > 0){
            System.out.println("\n El cambio/actualización de datos sobre el jugador seleccionado se ha efectuado correctamente.");
        } else{
            System.err.println("ERROR: Fallo en la actualización de datos sobre el jugador seleccionado. Es posible que el valor sea idéntico al actual o el campo o jugador solicitado no existan.");
        }

        // Cierra el escáner.
        // user.close();
    }
}