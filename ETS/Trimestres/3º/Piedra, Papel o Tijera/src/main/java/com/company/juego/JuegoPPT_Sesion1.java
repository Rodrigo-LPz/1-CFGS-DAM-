package com.company.juego;

import java.util.Random;
import java.util.Scanner;

public class JuegoPPT_Sesion1{
    // Método privado para la entrada de elección del usuario.
    private static String usuario(Scanner usuario){
        System.out.println("\nEscoga su arma de ataque:\n    1.'Piedra'.\n    2.'Papel'.\n    3.'Tijera'.\n    4.'Aleatorio'.");
        String eleccion = usuario.nextLine().toLowerCase();
        return eleccion;
    }

    // Método privado con elección aleatoria para la computadora.
    private static String computadora(String[] opciones){
        Random Aleatorio = new Random();
        int eleccion = Aleatorio.nextInt(3);
        return opciones[eleccion];
    }

    // Método para volver a jugar.
    private static boolean jugarNuevamente(){
        System.out.println("\n¿Desea continuar? (s/n)\n    Sí → s\n    No → n");
        Scanner Reinicio = new Scanner(System.in);
        String respuesta = Reinicio.nextLine().toLowerCase();
        Reinicio.close();
        if (respuesta.equals("s")){
            System.out.println("\n¡Continuemos!");
            return true;
        } else {
            System.out.println("\n¡Gracias por jugar!");
            return false;
        }
    }

    public static void main (String[] args){
        // Introducción al programa.
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Piedra, papel o tijera', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + " a continuación siga las instrucciones para jugar: ");
        System.out.println("\nInstrucciones del juego:\n    1. Elija una de las opciones como tu arma de ataque: 'Piedra', 'Papel', 'Tijera' o 'Aleatorio' si quieres que el destino sea tu aliadeo o enemigo.\n    2. El ordenador también elegirá una opción de forma alatoria y no basada en su elección, posibilitando así la opción de ganar o perder para el usuario.\n    3. Las reglas son las siguientes:\n        - Piedra vence a Tijera.\n        - Tijera vence a Papel.\n        - Papel vence a Piedra.\n    4. Si ambas elecciones son iguales, es un empate.\n    5. Puede jugar tantas veces como desee.\n\n¡Buena suerte!\n\n\n");

        // Creación de las posibles opciones.
        String[] opciones = {"Piedra", "Papel", "Tijera", "Agua", "Humanoide", "Aleatorio"};
        
        // Creación de un objeto/"entidad", para leer la entrada del usuario
        Scanner partida = new Scanner(System.in);
        boolean jugar = true;

        // Creación de un bucle de tipo "while" con el que leer los valores obtenidos de los métodos privados 'usuario', 'computadora' y 'jugarNuevamente' y parsear las distintas salidas posibles tras cotejar los resultados.
        while (jugar == true){
            String jugador = usuario(partida);
            if (!jugador.equals("piedra") && !jugador.equals("papel") && !jugador.equals("tijera") && !jugador.equals("aleatorio")){
                System.out.println("\nOpción no válida. Por favor, elija una opción válida: 'Piedra', 'Papel', 'Tijera' o 'Aleatorio'.");
                jugador = usuario(partida);
            }

            if (jugador.equals("aleatorio")){
                jugador = computadora(opciones);
            }
            String ordenador = computadora(opciones);

            // Cotejamos los resultados.
            System.out.println("\nJugador (tu elección): " + jugador);
            System.out.println("\nOrdenador: " + ordenador);

            // Determinamos los posibles caminos existentes para los resultados obtenidos.
            String resultados;
            if (jugador.equals(ordenador)){ /* También podemos ponerlo como "jugador == ordenador". */
                resultados = "\nResultado final: Empate";
            } else if ((jugador.equals("Piedra") && (ordenador.equals("Tijera") || ordenador.equals("Agua"))) || (jugador.equals("Papel") && (ordenador.equals("Piedra") || ordenador.equals("Agua"))) || (jugador.equals("Tijera") && (ordenador.equals("Papel") || ordenador.equals("Humanoide"))) || (jugador.equals("Agua") && (ordenador.equals("Humanoide") || ordenador.equals("Tijera"))) || (jugador.equals("Humanoide") && (ordenador.equals("Piedra") || ordenador.equals("Papel")))){
                resultados = "\nResultado final: ¡Ganaste!";
            } else{
                resultados = "\nResultado final: ¡Perdiste!";
            }
            
            // Muestreo de los resultados.
            System.out.println(resultados);
            
            // Opción a volver a jugar.
            jugar = jugarNuevamente();
        }

        // Cierre del scanner.
        usuario.close();
    }
    public static String obtenerResultado(String jugador, String ordenador) {
        if (jugador.equalsIgnoreCase(ordenador)) {
            return "Empate";
        } else if (
            (jugador.equalsIgnoreCase("Piedra") && (ordenador.equalsIgnoreCase("Tijera") || ordenador.equalsIgnoreCase("Agua"))) ||
            (jugador.equalsIgnoreCase("Papel") && (ordenador.equalsIgnoreCase("Piedra") || ordenador.equalsIgnoreCase("Agua"))) ||
            (jugador.equalsIgnoreCase("Tijera") && (ordenador.equalsIgnoreCase("Papel") || ordenador.equalsIgnoreCase("Humanoide"))) ||
            (jugador.equalsIgnoreCase("Agua") && (ordenador.equalsIgnoreCase("Humanoide") || ordenador.equalsIgnoreCase("Tijera"))) ||
            (jugador.equalsIgnoreCase("Humanoide") && (ordenador.equalsIgnoreCase("Piedra") || ordenador.equalsIgnoreCase("Papel")))
        ) {
            return "Ganaste";
        } else {
            return "Perdiste";
        }
    }
}
