/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_5;
/*Se importa el paquete "Scanner"/escáner*/
import java.util.Scanner;
/**
 *
 * @author RODRISTARK17
 */
/*Se crea la clase*/
public class Fibonacci{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programag 'sucesion de Fibonacci', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea un salto de línea*/
        System.out.println("\n");
        System.out.println("Bienvenido al programa " + nombre + ", ahora, por favor introduzca un numero acorde a la cantidad de terminos que desea generar o visualizar dentro de la sucesion de Fibonacci: ");
        int numero = usuario.nextInt();
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "Fibonacci" y se genera el método "generarSecuencia"*/
        Fibonacci sucesion = new Fibonacci(numero);
        sucesion.generarSecuencia();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "Fibonacci" y el constructor para la variable de dicho método*/
    public Fibonacci(int numero){
        this.numero = numero;
    }
    /*Se crea el método "generarSecuencia" donde se encontrará el código funcional del programa*/
    public void generarSecuencia(){
        /*Se crean las variables numéricas "a" y "b"*/
        int a = 0, b = 1;
        /**/
        System.out.println("Sucession de Fibonacci hasta el termino (" + numero + "):");
        /*Se crea un bucle "for"*/
        for (int i = 2; i <= numero; i++){
            /*Se crea la variable numerica "secuencia"*/
            int secuencia = a + b;
            /*Se imprime la variable "secuencia"*/
            System.out.println(secuencia);
            /*Se cambia el valor de la variable "a"*/
            a = b;
            /*Se cambia el valor de la variable "b"*/
            b = secuencia;
        }
    }
}