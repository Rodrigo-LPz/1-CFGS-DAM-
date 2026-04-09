// Enunciado: "Escribe un programa que calcule la nota final de un alumno a partir de las notas obtenidas en los tres trimestres. El programa debe pedir al usuario el nombre del alumno y las notas de cada trimestre, y luego mostrar la nota final calculada como la media de las tres notas."

/**
 *
 * @author Rodrigo
 */
package com.mycompany.prueba;


// Importa de la biblioteca/librería el paquete "Scanner".
import java.util.Scanner;

import javax.swing.JOptionPane;

// Crea la clase principal del programa.
public class Ejercicio1{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Llama al método "NotaFinal" desde el método principal, desde el "main".
        NotaFinal();
    }
        
    // Crea el método "NotaFinal" con la función de/para calcular la nota final.
    public static void NotaFinal(){
        // Crea el panel interactivo 'JOptionPane'.
            // Pide el nombre del usuario haciendo uso del "JOptionPane".
        String nombre = JOptionPane.showInputDialog ("Bienvenido al programa 'Calculadora de notas/calificaciones', por favor, ingrese su nombre: ");
            // Pide el nombre del alumno haciendo uso del "JOptionPane".
        String nombreAlumno = JOptionPane.showInputDialog ("\n\tBienvenido al programa profesor/a " + nombre + ", por favor, ahora introduzca el nombre de su alumno a calcular la nota: ");
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide las notas de los tres trimestres del alumno en cuestión haciendo uso de 'user'.
        System.out.print("\n\t\tFinalmente, introduzca la nota obtenida en el primer trimestre: ");
        double notaPrimerTrimestre = user.nextDouble();
        System.out.print("\n\t\tFinalmente, introduzca la nota obtenida en el segundo trimestre: ");
        double notaSegundoTrimestre = user.nextDouble();
        System.out.print("\n\t\tFinalmente, introduzca la nota obtenida en el tercer trimestre: ");
        double notaTercerTrimestre = user.nextDouble();

        // Calcula nota final del curso en función a la media obtenida a lo largo de todo el curso, de la obtenida entre el cómputo de todos los trimestres.
        double notaFinal = (notaPrimerTrimestre + notaSegundoTrimestre + notaTercerTrimestre) / 3;
        
        // Muestreo del resultado final al usuario.
            //System.out.println("\n\tProfesor/a" + nombre + ", la nota final obtenida por el alumno " + nombreAlumno + ", es de "+ notaFinal + " puntos en la materia.");
            //System.out.printf("\n\tProfesor/a " + nombre + ", la nota final obtenida por el alumno " + nombreAlumno + ", es de %.2f puntos en la materia.", notaFinal);
            //System.out.printf("\n\tProfesor/a %s, la nota final obtenida por el alumno %s, es de %.2f puntos en la materia.", nombre, nombreAlumno, notaFinal);
        
        // Muestreo del resultado final al usuario mediante el panel por pantalla 'JOptionPane'.
        String resultado = String.format("\n\tProfesor/a %s, la nota final obtenida por el alumno %s, es de %.2f puntos en la materia.", nombre, nombreAlumno, notaFinal);
        JOptionPane.showMessageDialog(null, resultado, "Resultado final de la evaluación", JOptionPane.INFORMATION_MESSAGE);

        // Cierra/Finaliza el escáner.
        user.close();
    }
}