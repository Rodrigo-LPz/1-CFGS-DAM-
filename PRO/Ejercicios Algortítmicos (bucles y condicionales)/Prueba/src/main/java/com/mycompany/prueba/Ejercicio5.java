// Enunciado: "Crea un algoritmo que le muestre al usuario si quiere realizar una suma, una resta, una multiplicación o una división. Una vez elija la opción deberá ingresar dos número para realizar dicha operación. Se le devolverá al usuario el resultado de la operación realizada. Hay que tener en cuenta que no se pueden realizar divisiones con cero."

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
public class Ejercicio5{
    // crea la clase principal del programa.
    public static void main(String[] args){
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide el nombre del usuario haciendo uso de 'user'.
        System.out.print("Bienvenido/a al programa 'Calculadora de operaciones', por favor ingrese su nombre: ");
        String nombre = user.nextLine();
        
        int opcion;
        
        // Crea un bucle de tipo "do-while" para asegurarse de que el programa se ejecuta en su totalidad al menos una vez. Es decir, donde asegurarse que la opción introducida por el usuario se correscponde con la premicia de alguna de las posibles opciones de operaciones a realizar.
        do{
            // Pide selesccionar una de las posibles opciones de operaciones a realizar haciendo uso de 'user'.
            System.out.print("\n\tBienvenido al programa " + nombre + ". A continuación, por favor, de entre las siguientes opciones escoga la operación a realizar:\n\t\t[1] Sumar.\n\t\t[2] Restar.\n\t\t[3] Multiplicar.\n\t\t[4] Dividir.\n\n\tOpción: ");
            opcion = user.nextInt();
            user.nextLine(); /* Limpia el buffer (salto de línea). */

            // Pide los números a operar haciendo uso de 'user'.
            System.out.print("\n\tAhora introduzca el primero de los dos números a operar: ");
            double numeroA = user.nextInt();
            user.nextLine(); /* Limpia el buffer (salto de línea). */

            System.out.print("\n\tAhora introduzca el segundo de los dos números a operar: ");
            double numeroB = user.nextInt();
            user.nextLine(); /* Limpia el buffer (salto de línea). */

            // Crea un condicional de tipo "if" donde asegurarse que la opción introducida por el usuario se correscponde con la premicia de alguna de las posibles opciones de operaciones a realizar.
            if (1 > opcion || opcion > 4){
                // Hay que poner "javax.swing.JOptionPane.showMessageDialog(null, ...);", en vez de JOptionPane.showMessageDialog(null, numeroA); ya que no está importada al principio el paquete "JOptionPane".
                javax.swing.JOptionPane.showMessageDialog(null, "\n\nError. Recuerda que la opción que representa la operación a solicitar es en formato numérico. Así como éste debe ir/estar comprendido entre 1 y 4, ambos incluidos.", "Error en el parámetro de opción.", JOptionPane.ERROR_MESSAGE); /* Para el caso de "Error en el parámetro de opción" es el título que recibe la ventana emergente. En cambio, para el caso de "JOptionPane.ERROR_MESSAGE" es el tipo de mensaje que se espera en la ventana. Por ejemplo, puere ser de información "JOptionPane.INFORMATION_MESSAGE", de error, como es el caso de "ERROR_MESSAGE"; etc. Esto sirve para indicar que la ventana emergente proviene de, en este caso error. Requiere de la importación del paquete "JOptionPane". */
            }

            double resultado;
            //boolean operacionValida = true;

            
            // Crea un condicional de tipo "switch" para obtener el caso de ejecución de la opción introducida
            switch (opcion){
                case 1:
                    resultado = numeroA + numeroB;
                    break; // Uso de "brake" para terminar el "switch" y evitar que se ejecuten los demás "case" sucesorios a este.
                case 2:
                    resultado = numeroA - numeroB;
                    break;
                case 3:
                    resultado = numeroA * numeroB;
                    break;
                case 4:
                    if (numeroB != 0){
                        resultado = numeroA / numeroB;
                        break;
                    } else{
                        javax.swing.JOptionPane.showMessageDialog(null, "\n\nError: No se puede dividir entre cero. Operación/División con resultado indefinido.", /*null*/ "Error al dividir entre cero.", JOptionPane.ERROR_MESSAGE);
                        continue; // Uso de "continue" para volver a pedir los datos.
                    }
                default:
                    throw new AssertionError();
            }
            
            // Muestreo del resultado final al usuario.
            JOptionPane.showMessageDialog(null, "El resultado de la operación. Opción (" + opcion + "). Entre los numeros " + numeroA + " y " + numeroB + " es de " + resultado, "Calculadora", JOptionPane.INFORMATION_MESSAGE);
            
        } while (1 > opcion || opcion > 4);
        
        // Cierra/Finaliza el escáner.
        user.close();
    }
}