import java.util.Random;
import java.util.Scanner;

public class JuegoPPT_Sesion1{
    // Método privado para la entrada de elección del usuario.
    private static String usuario(Scanner usuario){
        System.out.println("\nListado de armas de ataque:\n    1. Piedra.\n    2. Papel.\n    3. Tijera.\n    4. Agua.\n    5. Humanoide.\n    6. Aleatorio.");
        System.out.print("\nEscoga su arma de ataque: ");
        String eleccion = usuario.nextLine().toLowerCase();
        return eleccion;
    }

    // Método privado con elección aleatoria para la computadora.
    private static String computadora(String[] opciones){
        Random aleatorio = new Random();
        int eleccion = aleatorio.nextInt(5);
        return opciones[eleccion];
    }

    // Método para volver a jugar.
    private static boolean jugarNuevamente(Scanner reinicio){
        System.out.println("\n¿Desea continuar? (s/n)\n    Sí → s\n    No → n");
        System.out.print("\n¿Quieres jugar de nuevo?: ");
        String respuesta = reinicio.nextLine().toLowerCase();
        if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")){
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
        Scanner reinicio = new Scanner(System.in);
        System.out.print("Bienvenido al programa 'Piedra, papel o tijera', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine().trim();

        // Bucle de tipo "while" para validar que el nombre solo contenga letras y no esté vacío. 
        while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") || nombre.isEmpty()){
            System.out.println("\nError: El nombre solo debe contener letras y no puede estar vacío.");
            System.out.print("Por favor, ingrese un nombre válido: ");
            nombre = usuario.nextLine().trim();
        }

        System.out.println("\nBienvenido al programa " + nombre + " a continuación siga las instrucciones para jugar: ");
        System.out.println("\nInstrucciones del juego:\n    1. Elija una de las opciones como tu arma de ataque: 'Piedra', 'Papel', 'Tijera' o 'Aleatorio' si quieres que el destino sea tu aliadeo o enemigo.\n    2. El ordenador también elegirá una opción de forma alatoria y no basada en su elección, posibilitando así la opción de ganar o perder para el usuario.\n    3. Las reglas son las siguientes:\n        - Piedra vence a Tijera.\n        - Tijera vence a Papel.\n        - Papel vence a Piedra.\n    4. Si ambas elecciones son iguales, es un empate.\n    5. Puede jugar tantas veces como desee.\n\n¡Buena suerte!\n\n\n");

        // Creación de las posibles opciones.
        String[] opciones = {"piedra", "papel", "tijera", "agua", "humanoide", "aleatorio"};
        
        // Creación de un objeto/"entidad", para leer la entrada del usuario
        Scanner partida = new Scanner(System.in);
        boolean jugar = true;

        // Creación de un bucle de tipo "while" con el que leer los valores obtenidos de los métodos privados 'usuario', 'computadora' y 'jugarNuevamente' y parsear las distintas salidas posibles tras cotejar los resultados.
        while (jugar == true){
            String jugador = usuario(partida);

            while (!jugador.equals("piedra") && !jugador.equals("papel") && !jugador.equals("tijera") && !jugador.equals("agua") && !jugador.equals("humanoide") && !jugador.equals("aleatorio")){
                System.out.println("\nOpción no válida. Por favor, elija una opción válida: 'Piedra', 'Papel', 'Tijera', 'Agua', 'Humanoide' o 'Aleatorio'.");
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
            } else if ((jugador.equals("piedra") && (ordenador.equals("tijera") || ordenador.equals("humanoide"))) || (jugador.equals("papel") && (ordenador.equals("piedra") || ordenador.equals("agua"))) || (jugador.equals("tijera") && (ordenador.equals("papel") || ordenador.equals("humanoide"))) || (jugador.equals("agua") && (ordenador.equals("piedra") || ordenador.equals("tijera"))) || (jugador.equals("humanoide") && (ordenador.equals("agua") || ordenador.equals("papel")))){
                resultados = "\nResultado final: ¡Ganaste!";
            } else{
                resultados = "\nResultado final: ¡Perdiste!";
            }
            
            // Muestreo de los resultados.
            System.out.println(resultados);
            
            // Opción a volver a jugar.
            jugar = jugarNuevamente(reinicio);
        }

        // Cierre/Finalización de los scanners.
        usuario.close();
        reinicio.close();
    }
}
