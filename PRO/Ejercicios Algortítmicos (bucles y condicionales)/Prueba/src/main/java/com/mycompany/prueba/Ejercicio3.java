// Enunciado: "Crea un método llamado “Pesetas”, el cuál lo llamarás desde el método “Main” dentro de la clase “Ejercicio3”. Dentro de dicho método deberás preguntar la cantidad de euros para pasarlos a pesetas. Sabiendo que 1€ son 166,386 pesetas."

/**
 *
 * @author Rodrigo
 */
package com.mycompany.prueba;


// Importa de la biblioteca/librería el paquete "Scanner".
import java.util.Scanner;
// Importa de la biblioteca/librería el paquete "JOptionPane".
import javax.swing.JOptionPane;

// Crea la clase principal del programa.
public class Ejercicio3{
    public static void main(String[] args){
        // Llama al método "Pesetas" desde el método principal, desde el "main".
        Pesetas();
    }
    
    // Crea el método "Pesetas" con la función de ser un conversor de divisas.
    public static void Pesetas(){
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide el nombre del usuario haciendo uso de 'user'.
        System.out.print("Bienvenido/a al programa 'Conversor de Divisas', por favor, ingrese su nombre: ");
        String nombre = user.nextLine();
            // Pide la cantidad de euros a converitr a pesetas haciendo uso de "JOptionPane".
        double euros = Double.parseDouble(JOptionPane.showInputDialog("Bienvenido/a al programa " + nombre + ", ahora, ingrese la cantidad de euros a convertir/pasar a la divisa peseta: "));
        
        // Calcula la conversión de euros a monedas.
        double conversion = euros * 166.386;
        
        // Muestreo del resultado final al usuario
        System.out.println("\n\tEl resultado de la conversión (Euros (" + euros +") → Pesetas) es de: " + conversion + "₧/Ptas");
        
        // Cierra/Finaliza el escáner.
        user.close();
    }
}