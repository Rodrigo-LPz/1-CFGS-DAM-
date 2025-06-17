/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_practica_ut6;
/*Se importa el paquete "Scanner"/escáner*/
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
/*Se crea la clase*/
public class Ejercicio2{
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int[] numeroEncuestados;
    private int maximo;
    private int minimo;
    private double media;
    /*Se crea el método "Ejercicio2" y el constructor para las distintas variable de dicho método*/
    public Ejercicio2(){
        /*Se crea el escáner con el que interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Por favor, introduzca el numero de encuestados, encuestas realizadas: ");
        int cantidadEncuestas = usuario.nextByte();
        numeroEncuestados = new int[cantidadEncuestas]; /*Se relaciona dentro del escáner el numero o cantidad de encuestas realizadas con el numero de encuenstas obtenidas*/
        System.out.println("Ahora, vaya introduciendo los sueldos obtenidos: ");
        /*Se crea un bucle "for" con el que recorrer la cantidad de personas enuestadas*/
        int i;
        for (i = 0; i < 10; i++){
            numeroEncuestados[i] = usuario.nextInt();
        }
    }
    /*Se crea el método "ImpresiónBúsquedas" donde imprimir las distintas peticiones*/
    /*Se crea el método principal del programa*/
    public static void main (String[] args){
        /*Se crea el escáner con el que interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Encuesats Patrimonio (Arrecife)', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido, " + nombre);
        /*Se instancia el método "Ejercicio2" y se genera o se llama al método "ImpresiónEncuestas"*/
        Ejercicio2 numeros = new Ejercicio2();
    }
}