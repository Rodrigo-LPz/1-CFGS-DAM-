/**
 *
 * @author Rodrigo
 */

package com.mongodb.bdgestionjugadores;

// Importa el paquete "BDGestionDeJugadores".
    import com.mongodb.client.*; /* Con esta sentencia lo que hacemos es importar el archivo creado anteriormente 'BDGestionDeJugadores.java' hasta este archivo. */

// Importaciones de librerías de Java.
    // Importa todos los paquetes de la API "util", como por ejemplo "java.util.Scanner".
    import java.util.*;


// Crea la clase "MenuJugadores" donde se encuentra el menúş interactivo.
public class MenuJugadores extends BDGestionDeJugadores{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Crea una instancia de la clase "BDGestionDeJugadores".
        BDGestionDeJugadores gestorjugadores = new BDGestionDeJugadores();
        
        // Crea un escáner llamado "usuario" con el que dar la bienvenida al usuario.
        Scanner usuario = new Scanner(System.in);
        System.out.print("Bienvenido al programa 'GJ - Gestor de Jugadores', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido al programa " + nombre+ ", por favor, a continuación siga las instrucciones dadas.");
        
        // Declara una variable numérica, esta servirá como puente entre las opciones a escoger dentro del bucle.
        int opcion;
        
        // Crea un bucle de tipo "do-while", esto con la intención de que el menú se ejecute al menos una vez durante la ejecución completa del programa.
        do{
            // Muestreo de las instrucciones a seguir.
            System.out.println("\nEscoja una de las funciones/opciones a realizar en la Base de Datos del equipo:");

            // Muestreo de las opciones.
            System.out.println("\n\n\t<=== GESTIÓN DE JUGADORES ===>\n\n1. Registrar nuevo jugador al equipo.\n2. Mostrar/Listar todos los jugadores del equipo.\n3. Actualizar los datos del jugador.\n4. Eliminar jugador del equipo.\n5. Buscar jugador por posición natural.\n6. Salir del programa.\n");
            
            // Crea un bucle de tipo "while" para comprobar que el número introducido por el usuario corresponda con lo solicitado, es decir, que sea entero y está comprendido dentro del rango de opciones/acciones a ejecutar (1-6).
            while (!usuario.hasNextInt()){ /* Con "hasNextInt" lo que hacemos es comprobar o verificar si el token/instancia introducida como valor de la variable numérica "opcion" por el usuario es leĂ­do como lo que es un entero, "int", en caso de serlo devolverĂˇ true, en caso contrario dará "false". */
                System.out.println("ERROR: Por favor, vuelva a intentarlo. Introduzca un número válido para el sistema. Recuerde que el número a introducir deberá estar comprendido entre los números 1 y 6, ambos incluidos.");
                usuario.nextLine();
            }
            
            opcion = usuario.nextInt();
            usuario.nextLine();

            // Declara un condicional de tipo "switch", se podrá haber saltado/omitido el paso o el hecho de haberlo declarado dentro del "do", pero de esta manera nos aseguramos de que se ejecute al menos una vez.
            switch (opcion){
                /*
                * Caso 1: Realiza la función de registrar un nuevo jugador al equipo llamando a la función "registrarJugador" alojado en el archivo "BDGestionDeJugadores.java".
                * Caso 2: Realiza la función de buscar por el registro de un jugador dentro del equipo, lo muestra/lista, llamando a la función "listarJugadores" alojado en el archivo "BDGestionDeJugadores.java".
                * Caso 3: Realiza la función de actualizar el registro/base de datos de un jugador perteneciente al equipo llamando a la función "actualizarJugador" alojado en el archivo "BDGestionDeJugadores.java".
                * Caso 4: Realiza la función de eliminar a un jugador presente en el equipo llamando a la función "eliminarJugador" alojado en el archivo "BDGestionDeJugadores.java".
                * Caso 5: Realiza la función de buscar por la posición natural de/a un jugador del equipo llamando a la función "buscarPorPosicion" alojado en el archivo "BDGestionDeJugadores.java".
                * Caso 6: Realiza la función de salir del programa llamando a la función "cierreDeConexion" presente o declarada en el archivo "BDGestionDeJugadores.java".
                */
                case 1 -> /* También se puede declarar poniendo "case 1:". */
                    gestorjugadores.registrarJugador();
                case 2 ->
                    gestorjugadores.listarJugadores();
                case 3 ->
                    gestorjugadores.actualizarJugador();
                case 4 ->
                    gestorjugadores.eliminarJugador();
                case 5 ->
                    gestorjugadores.buscarPorPosicion();
                case 6 ->{
                    gestorjugadores.cierreDeConexion();
                    System.out.println("\nGracias por hacer uso del programa 'GJ - Gestor de Jugadores', esperamos que le haya sido de su agrado y utilidad. Bye! ;)");
                }
                default ->
                    System.err.println("ERROR: El valor/opción introducido en el sistema {" + opcion + "} no es válido o no está registrado por el sistema. Por favor, vuelva a intentarlo. Recuerde que el número a introducir deberá estar comprendido en el rango dado entre 1 y 6, ambos incluidos.");
            }
        }

        // Cierra el bucle, lo seguirá ejecutando hasta que el valor recibido por la variable "opcion" sea equivalente a (6).
        while (opcion != 6);
        
        // Cierra el escáner.
        usuario.close();
    }
}