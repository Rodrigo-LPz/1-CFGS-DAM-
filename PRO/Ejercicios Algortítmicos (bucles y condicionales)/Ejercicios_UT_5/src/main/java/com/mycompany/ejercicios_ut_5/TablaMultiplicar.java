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
public class TablaMultiplicar{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido a la calculadora de tablas de multiplicacion, por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea un salto de línea*/
        System.out.println("\n");
        System.out.println("Bienvenido al programa " + nombre + ", por favor, introduzca el numero del que quiera ver la tabla de multiplicación: ");
        int numero = usuario.nextInt();
        /*Se crea la instancia del método "TablaMultiplicar" y se genera el método "generarTabla"*/
        TablaMultiplicar tabla = new TablaMultiplicar(numero);
        tabla.generarTabla();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "TablaMultiplicar" y el constructor para las variables de dicho método*/
    public TablaMultiplicar(int numero){
        /*Se instancia el atributo del método privado con la variable del método público*/
        this.numero = numero;
    }
    /*Se crea el método "generarTabla" donde se encontrará el código funcional del programa*/
    public void generarTabla(){
        /*Se crea un salto de línea junto a un mensaje*/
        System.out.println("""
                           
                           Esta es la tabla de multiplicar comprendida entre los numeros 1 y 10 del numero (""" + numero + "):");
        /*Se crea un bucle "for"*/
        for (int i = 1; i <= 10; i++){
            /*Se imprime el programa junto a los distintos resultados de las multiplicaciones*/
            System.out.println(numero + " . " + i + " = " + (numero*i));
        }
    }
}