/**
 *
 * @author Rodrigo
 */
package com.mongodb.interfazgraficadeusuariosimple;

// Importa el paquete "Scanner".
import java.util.Scanner;


// Crea la clase principal para la (GUI - Graphical User Interface)
public class InterfazGraficaDeUsuarioSimple{
    // Crea el método principal del programa
    public static void main(String[] args){
        // Crea el scáner con el que interactuar con el usuario.
        Scanner user = new Scanner(System.in);
        
        // Declara las variables a usar.
        String nombre, decision, decisionFinal;
        // Se inicializa la variable "decision" con valor nulo, vacío.
        decision = null;
        
        System.out.println("Bienvenido a la aplicación 'Nombres del Revés', por favor, introduzca su nombre.");
        nombre = user.nextLine();
        System.out.println("Bienvenido al programa, {" + nombre + "}, Ahora decida si quiere abrir o no la app. (Sí / No)");
        decision = user.nextLine();
        decisionFinal = Character.toUpperCase(decision.charAt(0)) + decision.substring(1).toLowerCase();
        //if (decisionFinal != "Sí" || !decisionFinal != "Si"){
            if (decisionFinal != "No" ){
                System.err.println("La App no se ha abierto.");
            }
            System.out.println("La App no se ha abierto.");
        }
        
        // Crea un objeto para llamar a la clase "Pantalla".
        Pantalla pantalla = new Pantalla();
        // LLama al objeto "pantalla".
        //pantalla.setVisible(true);
        // Posiciona el objeto "pantalla" en el centro de la pantalla.
       // pantalla.setLocationRelativeTo(null); /* Se inicializa con valor "null" para que la aparición no tome ninuna localización/coordenadas como referencia. */
        
        // Cierra el escáner.
       // user.close();
    }
//}