/**
 *
 * @author Rodrigo
 */

package com.mycompany.persona;

// Importa la librería "util", ejemplo "java.util.ArrayList" o "java.util.Scanner".
import java.util.Scanner;

//Clase "Main".
public class Main{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Excáner para dar la bienvenida al usuario.
        Scanner user = new Scanner(System.in);
        System.out.print("Bienvenido al programa 'Registro de Personas Educativas', por favor ingrese su nombre: ");
        String name = user.nextLine();
        System.out.println("Bienvenido al programa " + name + ", a continuación siga las instrucciones. ");
            
        // Bucle de tipo "do-while" para comprobar que es lo que quiere empezar a hacer el usuario.
        do{
            System.out.println("\nSi desea seguir con el regisro introduzca la opción ('S') o ('s'), en caso contrario, introduzca ('N') o ('n'). ");
            String election = user.nextLine().trim().toUpperCase();
            
            // Caso validado para salir o detener el programa.
            if (election.equals("N")){
                System.out.println("\nAplicación detenida correctamente, esperamos que haya sido de su agrado. ");
                user.close();
                System.exit(0);
            
            // Caso validado para acceder a la acción de registrar personas.
            }else if (election.equals("S")){
                System.out.println("\nAplicación iniciando correctamente. ");
                break;
            
            // Caso validado para respuestas inesperadas o no cubiertas.
            } else{
                System.err.println("\nEl valor de la elección no es válida o no está registrado por el sistema. Recuerde que sólo puede ser ('S')/('s') para continuar y/o ('N')/('n') para cerrar o detener el programa. ");
            }
        } while (true); /* Repetición del bucle hasta que una de las respuestas cubra una de las opciones válidas. */
        
        System.out.println("\n\n\n\t\t\t\tINTRUCCIONES\n\n1. Si desea introducir un nuevo alumno introduzca la opción ('A') o ('a').\n2. Si desea introducir un nuevo profesor introduzca la opción ('P') o ('p').\n3. Si desea salir del programa introduzca la opción ('S') o ('s')\n");
        String register = user.nextLine().trim().toUpperCase();
            
        // condicional de tipo "switch" para acceder a la acción de registro.
        switch (register){
            // Caso validado para respuestas inesperadas o no cubiertas.
            default:
                System.err.println("\nEl valor de la elección no es válida o no está registrado por el sistema. Recuerde que sólo puede ser ('A') o ('a') para estudiante/s, ('P') o ('p') para profesor/es y/o ('S') o ('s') para cerrar o detener el programa. ");
                user.close();
                System.exit(0);
                break;
                
            // Caso validado para salir o detener el programa.
            case "S":
                System.out.println("\nAplicación detenida correctamente, esperamos que haya sido de su agrado. ");
                user.close();
                System.exit(0);
                break;
                
            // Caso validado para el registro de personas.
            case "A", "P":
                System.out.println("\n\nAhora, ¿Cuántas personas vas a querer registrar?");
                int number = user.nextInt();
                user.nextLine(); /* Limpieza del buffer. */
                        
                // Registro de/para estudiantes.
                if (register.equals("A")){
                    System.out.println("\n\n\n <===== REGISTRO DE ESTUDIANTE/S =====>");
                    
                    Persona[] estudiante = new Persona[number];
                    System.out.println("\nAhora introduce los siguientes datos en nuestro sistema:");
                    
                    for (int i = 0; i < number; i++){
                        System.out.print("\n\t1. Nombre Completo: ");
                        String nombre = user.nextLine();
                        
                        System.out.print("\t2. Correo eléctronico de contacto: ");
                        String correo = user.nextLine();
                        
                        System.out.print("\t3. Curso en prácticas: ");
                        String curso = user.nextLine();

                        estudiante [i] = new Estudiante(nombre, correo, curso);
                    }
                    
                    // Muestreo de la lista.
                    System.out.println("\n\nLISTA CON LA INFORMACIÓN REGISTRADA");
                    for (Persona estudiantes : estudiante){
                        estudiantes.mostrarInformacion();
                    }
                }
                
                // Registro de/para profesores.
                if (register.equals("P")){
                    System.out.println("\n\n\n <===== REGISTRO DE PROFESOR/ES =====>");
                    
                    Persona[] profesor = new Persona[number];
                    System.out.println("\nAhora introduce los siguientes datos en nuestro sistema:\n");
                    for (int i = 0; i < number; i++){
                        System.out.print("\n\t1. Nombre Completo: ");
                        String nombre = user.nextLine();
                        
                        System.out.print("\t2. Correo eléctronico de contacto: ");
                        String correo = user.nextLine();
                        
                        System.out.print("\t3. Departamento de especialización: ");
                        String departamento = user.nextLine();

                        profesor [i] = new Profesor(nombre, correo, departamento);
                    }
                    
                    // Muestreo de la lista.
                    System.out.println("\n\n\n <===== LISTA CON LA INFORMACIÓN REGISTRADA =====>");
                    for (Persona profesores : profesor){
                        profesores.mostrarInformacion();
                    }
                }
        }
    }
}


/*
 *  public class Main{
 *    public static void main(String[] args){
 *      Persona[] personas = new Persona[4];
 * 
 *      personas[0] = new Estudiante("Ana García", "ana@haria.com", "2º DAM");
 *      personas[1] = new Profesor("Carlos Ruiz", "carlos@haria.com", "Informática");
 *      personas[2] = new Estudiante("Luis Pérez", "luis@haria.com", "1º DAM");
 *      personas[3] = new Profesor("Marta López", "marta@haria.com", "Matemáticas");
 *
 *      for (Persona persona : personas){
 *          persona.mostrarInformación();
 *      }
 *    }
 *  }
 * 
 * 
 */