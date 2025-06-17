package Organizador;


// Importamos el paquete "ArrayList".
import java.util.ArrayList;
// Importamos el paquete "HashMap".
import java.util.HashMap;
// Importamos el paquete "Scanner".
import java.util.Scanner;


// Creamos la clase principal del programa.
public class Main{    
    // Creamos el método principal del programa.
    public static void main(String[] args){
        // Creamos el "Scanner" 'usuario'.
        Scanner usuario = new Scanner(System.in);
        System.out.print("Bienvenido al programa 'Organizador de Tareas', por favor introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", ahora siga las instrucciones.");
        System.out.print("\nIntroduce la prioridad de la tarea de tarea {1, 2 o 3}: \n");
        int nTarea = usuario.nextInt();
        
        // Declaramos el "ArrayList" para la 'prioridad'.
        ArrayList<Integer> prioridad = new ArrayList<Integer>();
        
        // Declaramos el "ArrayList" para la 'titulo'.
        ArrayList<String> titulo = new ArrayList<String>();
        
        // Declaramos el "ArrayList" para la 'completada'.
        ArrayList<String> completada = new ArrayList<String>();
        
        switch(nTarea){
            case 1 ->{
                // Añadimos algunas elementos, tareas.
                prioridad.add(1);
                
                // Añadimos algunas elementos, tareas.
                titulo.add("LND");
                
                // Añadimos algunas elementos, tareas.
                completada.add("Si");
            }
            case 2 ->{
                // Añadimos algunas elementos, tareas.
                prioridad.add(2);
                
                // Añadimos algunas elementos, tareas.
                titulo.add("BAE");
                
                // Añadimos algunas elementos, tareas.
                completada.add("No");
            }
            case 3 ->{
                // Añadimos algunas elementos, tareas.
                prioridad.add(3);
                
                // Añadimos algunas elementos, tareas.
                titulo.add("SIF");
                
                // Añadimos algunas elementos, tareas.
                completada.add("No");
            }
            default ->{
                System.err.print("Error: El numero de la priorida introducido es erroneo.");
            }
        }
        
        // Recorremos el bucle con el evento a realizar.
        for (String t : titulo){
            System.out.println("La tarea es de la asignatura: " + t);
        }
        
        // Recorremos el bucle con el evento a realizar.
        for (Integer p : prioridad){
            System.out.println("Con prioridad: " + p);
        }
        
        // Recorremos el bucle con la 'hora' del evento a realizar.
        for (String c : completada){
            System.out.println("Su estado es completada (" + c + ")");
        }
    }
}