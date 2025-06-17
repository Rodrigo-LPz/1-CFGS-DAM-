/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_5;
/*Se importa el paquete "Scanner"/escáner*/
import java.util.Scanner;
/*Se importa el paquete "JOptionPane"/panel de opciones*/
import javax.swing.JOptionPane;
/**
 *
 * @author RODRISTARK17
 */
/*Se crea la clase*/
public class SumaImpares{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa de Suma de Limites, por favor introduzca su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        int N_Inferior = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al programa " + nombre + ", ahora, por favor introduzca el valor numerico inferior"));
        int N_Superior = Integer.parseInt(JOptionPane.showInputDialog("Ahora, introduzca el valor numerico superior"));
        /*Se crea la instancia para el método "SumaImpares" y*/
        SumaImpares suma = new SumaImpares(N_Inferior, N_Superior);
        /*Se imprime un mensaje y se genera el método "calcularSuma"*/
        System.out.println("El total de estos numeros impares es de: " + suma.calcularSuma() + "u");
        /*Se imprime un mensje y se genera el método "calcularTotalSuma"*/
        System.out.println("Este es el resultado de la suma de todos los numeros impares: " + suma.calcularTotalSuma() + "u");
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int N_Inferior, N_Superior;
    /*Se crea el método "SumaImpares" y el constructor para las dos vaiables de dicho método*/
    public SumaImpares(int N_Inferior, int N_Superior){
        this.N_Inferior = N_Inferior;
        this.N_Superior = N_Superior;
    }
    /*Se crea el método "calcularSuma" donde se encontrará el código funcional del programa*/
    public int  calcularSuma(){
        /*Se crea la variable "suma"*/
        int suma = 0;
        /*Se imprime un mensje*/
        System.out.println("Estos son los numeros impares comprendidos entre el " + N_Inferior + " y el " + N_Superior + " (ambos incluidos): ");
        /*Se crea un bucle "for" para sumar todos los numeros impares*/
        for (int i = N_Inferior; i <= N_Superior; i++){
            /*Se crea un bucle o condicional "if"*/
            if (i % 2 != 0){
                suma += 1; /*(suma += 1) = (suma = suma + 1)*/
                System.out.println(i);
            }
        }
        /*Se devuelve el último valor de la variable "suma"*/
        return suma;
    }
    /*Se crea el método "calcularTotalSuma" donde se encontrará el código funcional del programa*/
    public int  calcularTotalSuma(){
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se crea la variable "suma"*/
        int suma_Cantidad_Impares = 0;
        /*Se crea un bucle "for" para sumar la cantidad total de numeros impares*/
        for (int i = N_Inferior; i <= N_Superior; i++){
            /*Se crea un bucle o condicional "if"*/
            if (i % 2 != 0){
                /*Se suma el valor a la variable "suma_Cantidad_Impares"*/
                suma_Cantidad_Impares += i;
            }
        }
        /*Se devuelve el último valor de la variable "suma_Cantidad_Impares"*/
        return suma_Cantidad_Impares;
    }
}