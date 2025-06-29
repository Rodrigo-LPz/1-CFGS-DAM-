package com.mycompany.practico;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        String nombre, fecha;

        Scanner usuario = new Scanner(System.in);
        System.out.print("Bienvenido a la aplicación 'Mi calendario-agenda 2025-2026', por favor, registre su nombre: ");
        nombre = usuario.nextLine();

        ArrayList<Cita> listaCitas = new ArrayList<>();
        listaCitas.add(new Cita("14/10/2025", "18:15", "Cumpleaños en la playa."));
        listaCitas.add(new Cita("07/03/2025", "12:33", "Cita con el médico."));
        listaCitas.add(new Cita("24/12/2025", "21:00", "Cena de Navidad en casa de mis padres."));

        do{
            System.out.println("\nBienvenido a tu agenda 2025-2026 " + nombre + " ¿Qué evento esta buscando? (actualmente tiene 3 eventos guardados para este año: 14/10/2025, 07/03/2025 y 24/12/2025)");
            System.out.println("\n\n(Para acceder a la fecha en cuestión introduzca el día, mes y año siguiendo el siguiente formato: DD/MM/AAAA. Ejemplo: 14/10/2025)");
            System.out.println("(Si desea cerrar la búsqueda introduzca el valor numérico cero ('0').");
            fecha = usuario.nextLine();

            if (fecha.equals("0")){
                System.out.println("\nHas salido de la búsqueda.");
                break;
            }

            boolean fechaEncontrada = false; /* Inicializamos la búsqueda en falso. */

            for (Cita cita : listaCitas){
                if (cita.getfecha().equals(fecha)){
                    System.out.println("\nCita encontrada: \n" + cita.toString());
                    fechaEncontrada = true; /* Cambiamos el valor a verdadero. */
                    break;
                }
            }

            if (!fechaEncontrada){ /* " ! " convierte el valor false a true, haciendo que se ejecute/imprima el mensaje. */
                System.out.println("\nCita no encontrada.");
            }
            
        } while (true);

        usuario.close();
    }
}