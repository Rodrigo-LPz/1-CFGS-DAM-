package Manager;


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
        
        // Declaramos el "ArrayList" para la 'descrpcion'.
        ArrayList<String> citaD = new ArrayList<String>();
        
        // Declaramos el "ArrayList" para la 'fecha'.
        ArrayList<Integer> citaF = new ArrayList<Integer>();
        
        // Declaramos el "ArrayList" para la 'hora'.
        ArrayList<Integer> citaH = new ArrayList<Integer>();
        
        switch(nTarea){
            case 1 ->{
                // Añadimos algunas elementos, citas.
                citaD.add("Comercial/Patrocinio");
                
                // Añadimos algunas elementos, citas.
                citaF.add(14);
                
                // Añadimos algunas elementos, citas.
                citaH.add(18);
            }
            case 2 ->{
                // Añadimos algunas elementos, citas.
                citaD.add("Lanzamiento nuevo disco");
                
                // Añadimos algunas elementos, citas.
                citaF.add(20);
                
                // Añadimos algunas elementos, citas.
                citaH.add(8);
            }
            case 3 ->{
                // Añadimos algunas elementos, citas.
                citaD.add("FanFest");
                
                // Añadimos algunas elementos, citas.
                citaF.add(21);
                
                // Añadimos algunas elementos, citas.
                citaH.add(11);
            }
            default ->{
                System.err.print("Error: El numero introducido no concuarda con ningun evento.");
            }
        }
        
        // Recorremos el bucle con el evento a realizar.
        for (String d : citaD){
            System.out.println("El evento del dia es: " + d);
        }
        
        // Recorremos el bucle con la 'fecha' del evento a realizar.
        for (Integer f : citaF){
            System.out.println("Sera el dia: " + f);
        }
        
        // Recorremos el bucle con la 'hora' del evento a realizar.
        for (Integer h : citaH){
            System.out.println("A la hora: " + h);
        }
    }
}