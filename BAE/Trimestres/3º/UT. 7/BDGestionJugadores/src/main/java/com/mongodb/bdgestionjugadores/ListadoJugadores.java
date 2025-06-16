/*
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

// Se crea la clase "ListadoJugadores" esta hará la función de listar/buscar el registro de los jugadores que se encuentren dentro de la colección.
public class ListadoJugadores{
    // Declara un método privado para realizar operaciones CRUD dentro de una colección de documentos en MongoDB.
    private final MongoCollection<Document> collection;

    // Crea un constructor que recibe la colección, el atributo privado "collection" creado anteriormente.
    public ListadoJugadores(MongoCollection<Document> collection){
        this.collection = collection;
    }

    // Crea una función con la que filtrar datos desde la base de datos de "MongoDB".
    Document filtroJugador;

    // Declara un método público, "ejecutarListadoJugador", para ejecutar la acción de listar/buscar a un jugador.
    public void ejecutarListadoJugador(){
        // Crea un escáner con el que poder interactuar con el usuario a través de la consola.
        Scanner user = new Scanner(System.in);
        
        // Muestreo de instrucciones previas.
        System.out.println("\nA continuación siga las indicaciones dadas introduciendo los valores acorde a lo que se le solicite en el momento:");

        // Muestreo de la acción a realizar.
        System.out.println("\n\n\t<=== LISTADO DE JUGADORES REGISTRADOS ====>\n");

        // Recupera todos los documentos, jugadores, de la colección.
        FindIterable<Document> jugadores = collection.find();


        // Creación de las variables a usar.
        String nombre, posicion;
        Integer edad, dorsal;
        
        // Declara una variable de tipo "boolean" con el fin de controlar si la colección está vací­a.
        boolean existenJugadores = false;

        // Crea un bucle de tipo "for-each" con el que recorrer y mostrar todos los documentos, jugadores, de la colección.
        for (Document jugador : jugadores){
            existenJugadores = true;

            nombre = jugador.getString("Nombre");
            edad = jugador.getInteger("Edad");
            dorsal = jugador.getInteger("Dorsal");
            posicion = jugador.getString("Posición");

            System.out.println("Nombre    : " + nombre);
            System.out.println("Edad      : " + edad + " años");
            System.out.println("Dorsal    : " + dorsal);
            System.out.println("Posición  : " + posicion);
            System.out.println("<-------------------------------------------------------------------------->\n\n");
        }

        // Crea un condicional de tipo "if" para comprobar si la colección está vací­a o no.
        if (!existenJugadores){
            System.err.println("ERROR: La colección sobre la que se está trabajando no existe o no contiene ningún registro, jugadores, (Está vací­a).");
        }

        // Creación de las variables a usar.
        String respuesta, respuestaFinal, campo, campoFinal, parametro, parametroEstricto, parametroEstrictoFinal;
        
        // Pregunta al usuario si desea buscar a un jugador en concreto/especí­fico.
        System.out.print("\n¿Desea buscar un jugador especí­fico dentro de la colección de jugadores? → (Sí­ / No): ");
        respuesta = user.nextLine().trim();
        respuestaFinal = Character.toUpperCase(respuesta.charAt(0)) + respuesta.substring(1).toLowerCase();

        if (!respuestaFinal.equals("No")){
            return; /* Se termina la búsqueda de jugadores en caso de que la respuesta no haya sido "Sí­" o "Si" */
        } else if (!respuestaFinal.equals("Sí­") && !respuestaFinal.equals("Si")){ /* No volvemos a filtrar en este "if" el posible "!respuestaFinal.equals("No")" pues ya está filtrado o declarado en el anterior "if". */
            System.out.println("ERROR: El valor de la respuesta introducida {" + respuestaFinal + "} no es válido. Recuerde que la respuesta a introducir deberá ser 'Sí­' o 'No'.");
            return;
        } else{
            // Muestreo de los posibles opciones a escoger para filtrar la búsqueda del jugador.
            while (true){
                System.out.println("\n¿Y por cuál campo/parámetro le gustarí­a empezar a filtrar la búsqueda del jugador? (Nombre / Edad/ / Dorsal / Posición)");
                campo = user.nextLine().trim();
                campoFinal = Character.toUpperCase(campo.charAt(0)) + campo.substring(1).toLowerCase();

                // Crea un bucle de tipo "if" con el que poder salir de bucle "while" en caso de que el usuario haya introducido correctamente el campo con el que trabajar.
                if (campoFinal.equals("Nombre") || campoFinal.equals("Edad") || campoFinal.equals("Dorsal") || campoFinal.equals("Posición") || campoFinal.equals("Posicion")){
                    break; /* Valida el valor introducido y sale del condicional, del "if". */
                } else{
                    System.out.println("ERROR: El valor introducido como campo de búsqueda o filtrado {" + campoFinal + "} no es válido. Recuerde que el valor del campo a introducir deberá ser 'Nombre', 'Edad', 'Dorsal' o 'Posición'.");
                }
            }

            // Petición del nuevo dato/parámetro para filtrar la búsqueda del jugador.
            System.out.print("\nEn ese caso, por favor, introduzca el nuevo valor de parámetro de búsqueda del campo {" + campoFinal + "} a buscar: ");
            parametro = user.nextLine().trim();
            
            // Crea un condicional de tipo "if" para realizar la búsqueda de jugadores por edad o dorsal.
            if (campoFinal.equals("Edad") || campoFinal.equals("Dorsal")){
                // Crea un bloque de tipo "try-catch" para efectuar la búsqueda del filtro sobre el/los jugador/es que entren dentro del párametro introducido.
                try{
                    int parametroNumerico = Integer.parseInt(parametro);
                    filtroJugador = new Document(campoFinal, parametroNumerico);
                } catch (NumberFormatException  e){
                    System.err.println("ERROR: El valor introducido como párametro de búsqueda {" + parametro + "} para el campo {" + campoFinal + "} no es válido. Recuerde que el valor introducido como parámetro deberá ser un número entero válido.");
                    return;
                }

            // Crea el caso contrario del anterior condicional, del "if", para realizar la búsquedaBúsqueda de jugadores por nombre o posición.
            } else{
                // Por defecto, asignaremos a la variable "parametroEstrictoFinal" el valor "Flexible" a fines de que la búsqueda pueda llegar a darse, teniendo esta un valor por defecto.
                parametroEstrictoFinal = "Flexible";
                
                // Crea un bucle de tipo "while" con el que comprobar que el valor introducido para el tipo de búsqueda concuerde.
                while (true){
                    // Muestreo de las opciones de filtrado que hay para la búsqueda en caso de haber escogido como "campo" a "Nombre" o "Posición".
                    System.out.println("\nDado que has escogido el campo de búsqueda {" + campoFinal + "} ¿Prefiere una búsqueda directa o flexible? (Directa / Flexible)\n(una búsqueda directa es aquella que busca el jugador exacto dado un parámetro, por ejemplo: si buscas por el parámetro de nombre 'Rodri', queriendo encontrar al jugador 'Rodrigo', no lo encontrarás, pues estás buscando a un jugador con el registro de 'Rodri'. En cambio, una búsqueda flexible es aquella que busca al/a los jugador/es que empiecen por 'Rodri', pudiendo obtener más jugadores tales como 'Rodri', 'Rodrigo', 'Rodriguez', etc.).");

                    parametroEstricto = user.nextLine().trim();
                    parametroEstrictoFinal = Character.toUpperCase(parametroEstricto.charAt(0)) + parametroEstricto.substring(1).toLowerCase();
                    
                    // Declara un condicional de tipo "if" para verificar si el valor introducido para la variable "parametroEstricto" es uno de los dos (en este caso) esperados.
                    if (parametroEstrictoFinal.equals("Directa") && parametroEstrictoFinal.equals("Flexible")){
                        break; /* Se comprueba que el valor es el esperado, es correcto y se sale del condicional "if". */
                    } else{
                        System.err.println("Error: El valor introducido como párametro para el tipo de búsqueda no es válido. Recuerde que el valor a introducir deberá ser sólo 'Directa' o 'Flexible': ");
                    }
                }

                // Crea un condicional de tipo "if" para el caso de que la variable "parametroEstrictoFinal" reciba como valor "Directa".
                if (parametroEstrictoFinal.equals("Directa")){
                    /*
                      *
                       *
                        * La expresión regular "$regex" indica que se usará una expresión regular (búsqueda por patrón/token), esto a modo de dirección.
                        * La expresión regular "^" significa que la búsqueda tendrá que: â€śempezar por/conâ€¦â€ť.
                        * La expresión regular "$" significa que la búsqueda tendrá que: terminar por/conâ€¦â€ť.
                        * Todo esto en conjunto dará como resultado que el valor de la variable "parámetro" a buscar dentro del "campo" tendrá queser estrictamente igual al valor introducido por el usuario, sin que haya ningún otro carácter antes o después de la cadena de texto.
                        * Por otro lado, la expresión regular "$options" se utiliza, es es una clave de "MongoDB" que permite modificar el comportamiento del "regex".
                        * En cambio, la expresión regular "i" (de "insensitive"), indica que no debe importar si es mayúscula o minúscula.
                       *
                      *
                    */
                    filtroJugador = new Document(campoFinal, new Document("$regex", "^" + parametro + "$").append("$options", "i"));
                
                // Crea un condicional de tipo "if" para cubrir el otro caso, donde la variable "parametroEstrictoFinal" reciba como valor "Flexible".
                } else if (parametroEstrictoFinal.equals("Flexible")){
                    filtroJugador = new Document(campoFinal, new Document("$regex", parametro).append("$options", "i"));
                }

            }
            // Activa el filtro y ejecuta la búsqueda del/de los jugador/es que coincidan con el parámetro introducido dentro del campo solicitado.
            FindIterable<Document> resultado = collection.find(filtroJugador);

            // Declara una variable de tipo "boolean" con un valor inicial "false" con el fin de manejar si la colección está vací­a respecto al/a los jugador/es que se estén buscando.
            boolean resultadoJugadorEncontrado = false;
            
            // Muestreo del resultado final de la búesqueda filtrada.
            System.out.println("\n\n\t<=== RESULTADO DE BÚSQUEDA ===>\n");

            // Repite el proceso con un nuevo bucle de tipo "for-each".
            for (Document jugador : resultado){
                resultadoJugadorEncontrado = true;

                System.out.println("Nombre    : " + jugador.getString("Nombre"));
                System.out.println("Edad      : " + jugador.getInteger("Edad") + " años");
                System.out.println("Dorsal    : " + jugador.getInteger("Dorsal"));
                System.out.println("Posición  : " + jugador.getString("Posición"));
                System.out.println("<-------------------------------------------------------------------------->\n\n");
            }

            // Crea un condicional de tipo "if" para comprobar si la búsqueda da un resultado o no en base a los documentos, jugadores, registrados en la colección.
            if (!resultadoJugadorEncontrado){
                System.err.println("ERROR: Fallo en nuestro sistema al encontrar el/los jugador/es coincidentes con los datos ingresados como parámetro de búsqueda {" + parametro +"} para/dentro del campo " + campoFinal + ". O bien ese jugador no existe.");
            }
        }

        // Cierra el escáner.
        //user.close();
    }
}