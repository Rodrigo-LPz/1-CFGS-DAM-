// Enunciado: "Escribe un programa que calcule el precio final de un producto a partir de su precio sin impuestos y el tipo de impuesto aplicado (IVA o IGIC). El programa debe pedir al usuario el nombre del producto, su precio sin impuestos, y el tipo de impuesto, y luego mostrar el precio final con el impuesto incluido."

/**
 *
 * @author Rodrigo
 */
package com.mycompany.prueba;


// Importa de la biblioteca/librería el paquete "Scanner".
import java.util.Scanner;

// Crea la clase principal del programa.
public class Ejercicio2{
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Crea el escáner 'user'.
        Scanner user = new Scanner(System.in);
            // Pide el nombre del usuario haciendo uso de 'user'.
        System.out.print("Bienvenido al programa 'Calculadora de precios', por favor, ingrese su nombre: ");
        String nombre = user.nextLine();
            // Pide el nombre del producto haciendo uso de 'user'.
        System.out.print("\n\tBienvenido al programa " + nombre + ", a continuación, siga las instrucciones:\n\t\t1. Por favor, indique el nombre del producto a comprar: ");
        String producto = user.nextLine();
            // Pide el precio del producto haciendo uso de 'user'.
        System.out.print("\n\t\t2. Nuevamente, ahora introduzca el precio por unidad del " + producto + " (sin el impuesto añadido): ");
        double precio = user.nextDouble();
        
        // Calcula el precio final del producto en función del impuesto, con IVA, 21%; y, con IGIC, 7%.
        double impuesto_IVA = precio * (1 + 0.21);
        double impuesto_IGIC = precio * (1 + 0.07);
        
        // Muestreo del resultado final al usuario.
        System.out.println("\n\t" + nombre + ", según los datos dados, el precio de " + precio + "€/unidad del " + producto + ". En base a donde tribute fiscalmente, el precio final (con impuesto incluido) es de " + impuesto_IVA + "€ (con IVA) y de " + impuesto_IGIC + "€ (con IGIC).");
        
        // Cierra/Finaliza el escáner.
        user.close();
    }
}