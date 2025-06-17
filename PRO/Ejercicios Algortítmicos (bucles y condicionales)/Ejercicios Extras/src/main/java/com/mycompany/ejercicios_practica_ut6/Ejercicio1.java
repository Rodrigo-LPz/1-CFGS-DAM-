/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicios_practica_ut6;
/*Se importa el paquete "Scanner"/escáner*/
import java.util.Scanner;
/*Se importa el paquete "JOptionPane"/panerl de opciones*/
import javax.swing.JOptionPane;
/**
 *
 * @author Alumno
 */
/*Se crea la clase*/
public class Ejercicio1{
    /*Se crean los distintos métodos privados, uno para cada petición, con atributos de variables numéricas almacenables*/
    private int cadena[];
    private int maximo;
    private int minimo;
    private int suma;
    private double media;
    private int modificacion;
    private int posicion;
    /*Se crea el método "Ejercicio1" y el constructor para las distintas variable de dicho método*/
    public Ejercicio1(){
        /*Declaramos cuantas posiciones tendrá nuestro array*/
        cadena = new int[100];
        /*Se inicializa la variable "suma" con un valor cero (0)*/
        suma = 0;
        /*Se crea un bucle "for" con el que obtener el valor de la "suma" de todos los numeros*/
        int i;
        for (i = 0; i < cadena.length; i++){
            cadena[i] = (int) (Math.random() * 100);
            System.out.println(cadena[i] + " + " + suma);
            suma += cadena[i];
        }
        /*Se inicializa la variable "suma" como una operación (total de la suma de la cantidad de numeros / cantidad de numeros)*/
        media = suma / 100;
        /*Se inicializa la variable "maximo" como la primera posición del array*/
        maximo = cadena[0];
        /*Se crea un bucle "for" con el que obtener el valor del numero más grande ("maximo") de todos los numeros*/
        int j;
        for (j = 0; j < cadena.length; j++){
            /*Se crea un bucle o condiciona "if" donde obtener el numero más grande*/
            if (cadena[i] > maximo){
                maximo = cadena[i];
            }
        }
        /*Hacemos lo mismo que hemos declarado en la variable "maximo" pero ahora para la variable "minimo"*/
        minimo = cadena[0];
        /*Se crea un bucle "for" con el que obtener el valor del numero más pequeño ("minimo") de todos los numeros*/
        int k;
        for (k = 0; k < cadena.length; k++){
            /*Se crea un bucle o condiciona "if" donde obtener el numero más grande*/
            if (cadena[i] < minimo){
                minimo = cadena[i];
            }
        }
        /*Se inicializa la variable "posicion" como una instrucción interactiva para el usuario*/
        posicion = Integer.parseInt(JOptionPane.showInputDialog ("Introduzca la posición a cambiar por el numero que desee: "));
        /*Se inicializa la variable "posicion" como una instrucción interactiva para el usuario*/
        modificacion = Integer.parseInt(JOptionPane.showInputDialog ("Introduzca el numero que desee: "));
        /*Se crea un bucle "for" con el que obtener el valor del numero más pequeño ("minimo") de todos los numeros*/
        int l;
        for (l = posicion; l < cadena.length; l++){
            /*Se crea un bucle o condiciona "if" donde obtener el numero más grande*/
            if (cadena[i] == posicion){
                modificacion = cadena[i];
            }
        }
    }
    /*Se crea el método "ImpresiónBúsquedas" donde imprimir las distintas peticiones*/
    public void ImpresiónBúsquedas(){
        /*Se imprime el último valor obtenido en la variable "suma" tras acaabar el bucle "for"*/
        System.out.println("La suma total de todos los numeros randoms es de " + suma);
        /*Se imprime el último valor obtenido en la variable "media "tras acaabar el bucle "for" por parte de la variable "suma"*/
        System.out.println("La media  total de todos los numeros randoms es de " + media);
        /*Se imprime el último valor obtenido en la variable "maximo "tras acaabar el bucle "for-if"*/
        System.out.println("El valor más grande generado es el " + maximo);
        /*Se imprime el último valor obtenido en la variable "minimo "tras acaabar el bucle "for-if"*/
        System.out.println("El valor más pequeño generado es el " + minimo);
        /*Se imprime el último valor obtenido en la variable "modificacion "tras acaabar el bucle "for-if"*/
        System.out.println("El valor modificado (" + modificacion +") se ha efectuado sobre la poscion (" + posicion + ") del array de los 100 numeros randoms");
    }
    /*Se crea el método principal del programa*/
    public static void main(String[] args){
        /*Se crea el escáner con el que interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Cientos de aleatorios', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido, " + nombre);
        /*Se instancia el método "Ejercicio1" y se genera o se llama al método "ImpresiónBúsquedas"*/
        Ejercicio1 numeros = new Ejercicio1();
        numeros.ImpresiónBúsquedas();
    }
}
