/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject2;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
// Se crea la clase principal.
public class Mavenproject2{
    // Método privado para la entrada de elección del usuario.
    private static String usuario(Scanner usuario){
        System.out.println("\nEscoga su mvimiento:\n    1.'Piedra'.\n    2.'Papel'.\n    3.'Tijera'.");
        String eleccion = usuario.nextLine().toLowerCase();
        /*if ((eleccion != "piedra") || (eleccion != "papel") || (eleccion != "tijera")){
            System.err.println("Valor introducido no válido");
        }*/
        return eleccion;
    }

    // Método privado con elección aleatoria para la computadora.
    private static String computadora(String[] opciones){
        Random Aleatorio = new Random();
        int eleccion = Aleatorio.nextInt(3); // opciones.length
        return opciones[eleccion];
    }

    // Método para volver a jugar.
    private static boolean jugarNuevamente(){
        System.out.println("\n¿Desea continuar? (s/n)\n    Sí → s\n    No → n");
        Scanner usuario = new Scanner(System.in);
        String respuesta = usuario.nextLine().toLowerCase();
        if (respuesta.equals("s")){
            System.out.println("\nContinuemos!");
            return true;
        } else {
            System.out.println("\nGracias por jugar!");
            return false;
        }
    }

    public static void main (String[] args){
        // Introducción al programa.
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Piedra, papel o tijera', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + " a continuación siga las instrucciones para jugar: ");

        // Creación de las posibles opciones.
        String[] opciones = {"piedra", "papel", "tijera"};
        
        // Creación de un objeto/"entidad", para leer la entrada del usuario
        Scanner partida = new Scanner(System.in);
        boolean jugar = true;

        // Creación de un bucle de tipo "while" con el que leer los valores obtenidos de los métodos privados 'usuario', 'computadora' y 'jugarNuevamente' y parsear las distintas salidas posibles tras cotejar los resultados.
        while (jugar == true){
            String jugador = usuario(partida);
            String ordenador = computadora(opciones);

            // Cotejamos los resultados.
            System.out.println("Jugador (tu elección): " + jugador);
            System.out.println("Ordenador: " + ordenador);

            // Determinamos los posibles caminos existentes para los resultados obtenidos.
            String resultados;
            if (jugador.equals(ordenador)){ /* También podemos ponerlo como "jugador == ordenador". */
            resultados = "\nResultado final: Empate";
            } else if ((jugador.equals("piedra") && ordenador.equals("tijera")) || (jugador.equals("papel") && ordenador.equals("piedra")) || (jugador.equals("tijera") && ordenador.equals("papel"))){
                resultados = "\nResultado final: Ganaste";
            } else{
                resultados = "\nResultado final: Perdiste";
            }
            
            // Muestreo de los resultados.
            System.out.println(resultados);
            
            // Opción a volver a jugar.
            jugar = jugarNuevamente();
        }

        // Cierre del scanner.
        usuario.close();
    }
}