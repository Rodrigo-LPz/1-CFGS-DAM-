/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_5;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class NumeroPerfecto2 {
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Numero Perfecto', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico: ");
        int numero = usuario.nextInt();
        /*Se crean dos bucles o condicionales "if" donde se declara el caso de ruptura en el programa para valores iguales o inferiores a (0)*/
        if (numero <= 0){
            System.err.println("El numero introducido en el sistema no es válido (Recuerda utilizar un numero natural y/o entero, positivo y/o negativo), a excepcion del (0)");
        }
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "NumeroPerfecto2" y se genera el método "esPerfecto2"*/
        NumeroPerfecto2 clase = new NumeroPerfecto2(numero);
        System.out.println("El numero introducido en el programa (" + numero + ") es un numero perfecto: " + clase.esPerfecto2());
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de dos variables numéricas almacenables*/
    private int numero;
    /*Se crea el método "NumeroPerfecto2" y el constructor para las dos varibales de dicho método*/
    public NumeroPerfecto2(int numero){
        this.numero = numero;
    }
    /*Se crea el método "esPerfecto2" donde se encontrará el código funcional del programa*/
    public boolean esPerfecto2(){
        /*Se crea una variable sumatoria*/
        int suma = 0;
        /*Se crea un bucle "for" donde la variable "i" recorre todas las posiciones desde el (1) hasta el numero introducido, siendo este el propio numero dividido por 2*/
        for (int i = 1; i <= numero/2; i++){
            /*Se crea un bucle o condicional "if" donde se comprueba si el número aceptado por el bucle "for" ahora es divisor del numero, es decir, si al dividirlo, el resto da (0)*/
            if (numero % i == 0){
                /*Se incrementa la variable sumatoria "suma"*/
                suma += i;
            }
        }
        /*Se devuelve el valor de la variable "suma" con el último valor obtenido en el bucle "for" tras haber terminado*/
        return suma == numero;
    }
}
