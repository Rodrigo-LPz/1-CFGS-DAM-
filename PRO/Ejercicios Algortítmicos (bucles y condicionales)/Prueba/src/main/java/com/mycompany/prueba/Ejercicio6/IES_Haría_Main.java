// Enunciado: "Vamos a realizar una aplicación para guardar la información de los alumnos del IES Haría. Para ello, queremos guardar el nombre, el primer apellido, la edad y el curso. Deberemos pedirle al usuario que nos inserte toda la información. El usuario decidirá terminar el proceso de lectura de datos cuando introduzca como nombre un asterisco (*) Al finalizar se mostrará los siguientes datos:"
/*

• Toda la información recogida de todos los alumnos.
• Todos lo alumnos mayores de edad.
• La edad media del alumnado del centro.
• Cuál es el menor de todos los alumnos.
• Cuál es el mayor de todos los alumnos.

*/

/**
 *
 * @author Rodrigo
 */
package com.mycompany.prueba.Ejercicio6;

// Importa de la biblioteca/librería el paquete "ArrayList".
import java.util.ArrayList;
// Importa de la biblioteca/librería el paquete "List".
import java.util.List;
// Importa de la biblioteca/librería el paquete "Scanner".
import java.util.Scanner;
import javax.swing.JOptionPane;

// Crea la clase principal del rpograma.
public class IES_Haría_Main{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide el nombre del usuario haciendo uso de 'user'.
        System.out.print("Bienvenido/a al programa 'Lista/Registro de alumnos - IES Haría', por favor, ingrese su nombre: ");
        String nombre = user.nextLine();
        System.out.println("\n\tBienvenido/a al programa " + nombre + ", por favor, a continuación siga las instrucciones dadas:");
        
        // Crea una lista genérica, "List", ésta contendrá los objetos del tipo "Alumno".
        List<Alumno> listaAlumnos = new ArrayList<>(); /* Similar a un array pero a diferencia de éste, las listas no tienen un tamaño fijo, pues son colecciones dinámicas. */
        
        // Crea un bucle de tipo "while" con el que poder ir añadiendo de forma sucesiva y contínua los datos de los alumnos, a guardar en los objetos de "Alumno".
        while (true){
            // Pide el nombre del alumno a ingresar en el programa haciendo uso de 'user'.
            System.out.print("\n\t\tIntroduzca el nombre del alumno [Si desea terminar inserte el siguiente caracter: (*)]: ");
            String nombreAlumno = user.nextLine();
            
            // Crea un bucle de tipo "if" para el caso de finalizar el ingreso de alumnos al programa.
            if (nombreAlumno.equals("*")){
                break;
            }
            
            // Pide el primer apellido del alumno a ingresar en el programa haciendo uso de 'user'.
            System.out.print("\n\t\tNuevamente, introduzca el primer apellido del alumno: ");
            String primerApellido = user.nextLine();
            
            // Pide la edad del alumno a ingresar en el programa haciendo uso de 'user'.
            System.out.print("\n\t\tAhora, introduzca la edad del alumno: ");
            int edad = user.nextInt();
            user.nextLine(); /* Limpia el buffer (salto de línea). */
            
            // Pide el curso del alumno a ingresar en el programa haciendo uso de 'user'.
            System.out.print("\n\t\tFinalmente, introduzca el curso a cursar o que está cursando el alumno: ");
            String curso = user.nextLine();
            
            // Ingresa todos estos nuevos datos en "Alumno" como una nueva iteración e objeto de la lista.
            listaAlumnos.add(new Alumno(nombreAlumno, primerApellido, edad, curso));
            
            // Aviso al usuario de que el prceso ha finalizado para ese objeto.
            System.out.println("\n\tRegistro del alumno " + nombreAlumno + primerApellido + " ha sido añadido/almacenado en el sistema del programa.");
        }
        
        // Muestreo de todos los alumnos almacenados/registrados.
        System.out.println("\n\n\t\t\t\t<======= Alumnos matriculados IES Haría =======>");
            // Crea un bucle de tipo "for" para recorrer y mostrar uno a uno todos los alumnos almacenados/registrados en la lista de "Alumno".
        for (Alumno listaAlumno : listaAlumnos){
            System.out.println(listaAlumno);
        }
        
        // Muestreo de todos los alumnos mayores de edad almacenados/registrados.
        System.out.println("\n\n\t\t\t\t<======= Alumnos (mayores de edad) matriculados IES Haría =======>");
            // Crea un bucle de tipo "for" para recorrer y mostrar uno a uno todos los alumnos almacenados/registrados en la lista de "Alumno".
        for (Alumno listaAlumno : listaAlumnos){
            // Crea un condicional de tipo "if" con el que separar a los alumnos mayores de edad de los que no dentro de la lista y obtener aquellos que tienen 18 años o más.
            if (listaAlumno.getEdad() >= 18){
                System.out.println(listaAlumno);
            }
        }
        
        // Muestreo de la edad media, más alta/mayor y más baja/menor de todos los alumnos almacenados/registrados.
            // Comprueba, inicialmente, si la lista de alumnos está vacía o no.
            /*
            
            !alumnos.isEmpty() → el "!" es el operador lógico de negación.
            alumnos.isEmpty() devuelve true si la lista está vacía.
            Con "!" negamos ese valor, así que la condición será true solo si la lista NO está vacía.

            */
        if (!listaAlumnos.isEmpty()){
            int totalEdad = 0; /* Inicialización en 0 porque es el elemento neutro tanto de la suma como de la resta. */
            
            // Crea un bucle de tipo "for" para recorrer uno a uno todos los alumnos almacenados/registrados en la lista de "Alumno" e ir aumentando el total de edad, "totalEdad".
            for (Alumno listaAlumno : listaAlumnos){
                totalEdad += listaAlumno.getEdad();
            }
            
            // Calcula la media de edad.
            double mediaEdad = (double) totalEdad / listaAlumnos.size();
            
            // Muestreo del resultado final (de la media de edad) al usuario.
            System.out.println("\n\n\tLa media de edad total obtenida entre todos los alumnos (" + listaAlumnos.size() + " alumos) es de: " + mediaEdad + " años.");
            
            // Obtiene la posición del primer alumno según el orden de registro, partiendo de la primera posición como punto de partida.
            Alumno menor = listaAlumnos.get(0);
            Alumno mayor = listaAlumnos.get(0);
            
            // Crea un bucle de tipo "for" para recorrer uno a uno todos los alumnos almacenados/registrados en la lista de "Alumno" e ir comparando de a uno la edad entre los alumnos para obtener la más pequeña y/o más grande.
            for (Alumno listaAlumno : listaAlumnos){
                // Crea dos condicionales de tipo "if" para ir tomando a medida que avanza el bucle el alumno con la edad más baja y alta respectivamente con cada uno de los dos condicionales.
                if (listaAlumno.getEdad() < menor.getEdad()) { menor = listaAlumno; }
                if (listaAlumno.getEdad() > mayor.getEdad()) { mayor = listaAlumno; }
            }
            
            // Muestreo del resultado final (de la edad más baja/pequeña/menor y de la más alta/grande/mayor) al usuario.
            System.out.println("\n\tLa edad más baja/pequeña/menor de entre todos los alumnos es de " + menor.getNombre() + " correspondiente a una edad de " + menor.getEdad());
            System.out.println("\n\tLa edad más alta/grande/mayor de entre todos los alumnos es de " + mayor.getNombre() + " correspondiente a una edad de " + mayor.getEdad());
        } else{
            javax.swing.JOptionPane.showMessageDialog(null, "Error. La lista de alumnos está vacía o no la puede leer el sistema.", "Error en la lectura de la lista de alumnos IES Haría", JOptionPane.ERROR_MESSAGE);
        }
        
        // Cierra/Finaliza el escáner.
        user.close();
    }
}