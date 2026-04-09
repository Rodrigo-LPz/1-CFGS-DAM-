// Enunciado: "Realiza un algoritmo que le pida al usuario un número con el que vas a imprimir la tabla de multiplicar. Para ello debes comprobar que el número esté comprendido entre 1 y 10."

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
public class Ejercicio4{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide el nombre del usuario haciendo uso de 'user'.
        System.out.print("Bienvenido/a al programa 'Tablas de multiplicar', por favor ingrese su nombre: ");
        String nombre = user.nextLine();
        // Crea el panel interactivo 'JOptionPane'.
            // Pide el número corerspondiente a una de las tablas de multiplicar.
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido/a al programa " + nombre + ", por favor, ahora introduzca un número para imprimir su tabla de multiplicar.\n\t(Recuerde que el número debe estar comprendido entre el 1 y el 10, ambos incluidos): "));
        
        // Crea un condicional de tipo "if" para confirmar/asegurar que el número introducido por el usuario corresponda con la solicitud de requesitos solicitada anteriormente (Número comprendido entre el 1 y el 10, ambos incluidos).
        if (1 > numero || numero > 10){
            System.err.println("\n\nError. Recuerda que el número a introducir en el programa debe ir/estar comprendido entre 1 y 10, ambos incluidos.");
        } else{
            System.out.println("\n\tTabla de Multiplicar del numero (" + numero + ")");
            // Crea un bucle de tipo "for" para realizar la multiplicación de cada número, recorriendo cada uno de los números desde el 1 hasta el 10.
            for (int i = 1; i <= 10; i++){
                int resultado = numero * i;
                
                // Muestreo del resultado final, de la tabla de multiplicación al usuario.
                System.out.println("\t\t" + i + " x " + numero + " = " + numero * i);
                JOptionPane.showMessageDialog(null, "\n\t\t" + i + " x " + numero + " = " + resultado, "Resultado - Tabla de multiplicar", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        // Cierra/Finaliza el escáner.
        user.close();
        
        
        
        
        
        
        
        /*  // Ejercicio4.1
        
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide el nombre del usuario haciendo uso de 'user'.
        System.out.print("Bienvenido/a al programa 'Tablas de multiplicar', por favor ingrese su nombre: ");
        String nombre = user.nextLine();
        
        int numero;
        
        // Crea un bucle de tipo "while" para repetir la ejecución del programa hasta que el usuario introduzca un número válido para este.
        while (true){
            numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido/a al programa " + nombre + ", por favor, ahora introduzca un número para imprimir su tabla de multiplicar.\n\t(Recuerde que el número debe estar comprendido entre el 1 y el 10, ambos incluidos): "));
        
            // Crea un condicional de tipo "if" para confirmar/asegurar que el número introducido por el usuario corresponda con la solicitud de requesitos solicitada anteriormente (Número comprendido entre el 1 y el 10, ambos incluidos).
            if (1 > numero || numero > 10){
                System.err.println("\n\nError. Recuerda que el número a introducir en el programa debe ir/estar comprendido entre 1 y 10, ambos incluidos.");
            } else{
                // Sale del bucle "while".
                break;
            }
        }
        
        // Crea un bucle de tipo "for" para realizar la multiplicación de cada número, recorriendo cada uno de los números desde el 1 hasta el 10.
        for (int i = 1; i <= 10; i++){
            int resultado = numero * i;

            // Muestreo del resultado final, de la tabla de multiplicación al usuario.
            System.out.println("\t\t" + i + " x " + numero + " = " + numero * i);
            javax.swing.JOptionPane.showMessageDialog(null, "\n\t\t" + i + " x " + numero + " = " + resultado, "Resultado - Tabla de multiplicar", JOptionPane.INFORMATION_MESSAGE);
        }
        
        // Cierra/Finaliza el escáner.
        user.close();
        
        */
    }
}