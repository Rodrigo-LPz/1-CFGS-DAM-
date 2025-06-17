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
public class Ejercicio3{
    /*Se crea dos métodos privado, uno con un atributo de cadena de caracteres almacenable y el otro con un atributo de variable numérica almacenable*/
    private String texto;
    private int numeroEspacios;
    /*Se crea el método "Ejercicio2" y el constructor para las distintas variable de dicho método*/
    public Ejercicio3(String texto){
        this.texto = texto;
        this.numeroEspacios = numeroEspacios();
    }
    /*Se crea un método privado "numeroEspacios" partiendo de la variable numéica "numeroEspacios" donde declarar la parte 'funcioanl' del programa, donde traabjar con los espacios en blanco o vacíos de "texto"*/
    public int numeroEspacios(){
        /*Se crea una variable numérica con la función de contabilizar*/
        int contador = 0;
        /*Se crea un bucle "for" con el que identificar y recorrer la cantidad de espacio vacíos/en blanco dentro de la variable "texto"*/
        int i;
        for (i = 0; i < 10; i++){
            if (Character.isSpaceChar(texto.charAt(i))){
                contador ++;
            }
        }
        /*Se devuelve el último valor obtenido para "contador" tras finalizar el bucle "for"*/
        return contador;
    }
    /*Se crea el método principal del programa*/
    public static void main(String[] args){
        /*Se crea el escáner con el que interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Espacios en blanco/vacios', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido al programa " + nombre + ", ahora introduzca la oracion, frase o texto que quiera: ");
        String texto = usuario.nextLine();
        /*Se instancia el método "Ejercicio1" y se genera o se llama al método "ImpresiónBúsquedas"*/
        Ejercicio3 cantidad = new Ejercicio3(texto);
        System.out.println("La frase o texto introducido en el sistema tiene " + cantidad.numeroEspacios + " espacios en blanco/vacios");
    }
}