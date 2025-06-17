/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_6;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class TablaOrdenadaInversa_3{
    private int numeroInicio, fin;
    public TablaOrdenada_3(int numeroInicio, int fin){
        this.numeroInicio = numeroInicio;
        this.fin = fin;
    }
    public static int[] RellenarPares(int longitud, int fin){
        int[] array = new int[longitud];
        int i = 0;
        while (i < array.length){
            int random = (int) (Math.random() * fin + 1);
            if (random % 2 == 0){
                array[i] = random;
                i++;
            }
        }
        Arrays.sort(array);
        return array;
    }
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Tabla Ordenada', por favor, intoduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", ahora introduzca en forma de entero la longitud de tabla");
        int numero = usuario.nextInt();
        System.out.println("\nPor ultimo, introduzca el numero final, hasta el que quieras llegar en la tabla: ");
        int fin = usuario.nextInt();
        TablaOrdenadaInversa_3 tabla = new TablaOrdenadaInversa_3 (numero, fin);
        System.out.println("\nEl resultado de la tabla con numeros pares es la siguiente: " + Arrays.toString(TablaOrdenada_3.RellenarPares(numero, fin)));
        usuario.close();
    }
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Tabla Ordenada', por favor, intoduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", ahora introduzca los numeros que quiera visualizar en la tabla");
        int numeros = usuario.nextInt();
        int num[] = new int [numeros];
        System.out.println("");
        System.out.println("\nPor ultimo, introduzca el numero final, hasta el que quieras llegar en la tabla: ");
        int fin = usuario.nextInt();
        TablaOrdenadaInversa_3 tabla = new TablaOrdenadaInversa_3 (numero, fin);
        System.out.println("\nEl resultado de la tabla con numeros pares es la siguiente: " + Arrays.toString(TablaOrdenada_3.RellenarPares(numero, fin)));
        usuario.close();
    }
}