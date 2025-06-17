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
public class ContadorVocales1{
    /*Se crea el método principal*/
    public static void main (String[] args){
        /*Se crean los escáneres para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Contador de Vocales', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido a la aplicacion " + nombre + ", ahora introduzca una letra o conjunto de estas (texto) para contabilizar el numero de vocales: ");
        String texto = usuario.nextLine();
        /*Se instancia el método "ContadorVocales1" y se genera el método "contarVocales1" con un mensaje*/
        ContadorVocales1 contador = new ContadorVocales1(texto);
        System.out.println("El total de vocales dentro del texto o del caracter introducido es de: " + contador.contarVocales1());
        /*Se ciera el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributa de variable no numerica almacenable*/
    private String texto;
    /*Se crea el método "ContadorVocales1" y el constructor para la variable de dicho método*/
    public ContadorVocales1(String texto){
        this.texto = texto;
    }
    /*Se crea el método "contarVocales1" donde se encontrará el código funcional del programa*/
    public int contarVocales1(){
        /*Se crea la variable "contador" para contabilizar*/
        int contador = 0;
        /*Se crea el bucle "for"*/
        for (int i = 0; i < texto.length(); i++){
            /*Se crea una variable de tipo carácter "char" donde tendrá o será igual al valor del caracter que se esté leyendo en ese momento dentro del bucle*/
            char vocales = Character.toLowerCase(texto.charAt(i)); /*"Character.toLowerCase(texto.charAt(i));" primero coge la cadena de texto y por cada carácter asigna la posición (i) "texto.charAt(i)", después convierte ese caracter de forma INDIVISUAL en minúscula "Character.toLowerCase()"
                                                                      También se puede hacer así:
                                                                     "texto.toLowerCase().charAt(i);" primero convierte DE GOLPE toda la cadena de texto en minúscula "texto.toLowerCase()", después obtiene el caracter traducido a múscula en la posición (i)*/
            /*Se crea la estructura de control "switch"*/
            switch (vocales){
                /*Se crean los distintos casos para la estructura de control "switch" a la qué, en caso de cumplirse se le irá incrementando el valor a la variable "contador" y después de ello, con una sentencia o declaración "break", se dentrndrá el switch para ese carácter leído, no para el bucle en su totalidad*/
                case 'a':
                    contador++;
                    break;
                case 'e':
                    contador++;
                    break;
                case 'i':
                    contador++;
                    break;
                case 'o':
                    contador++;
                    break;
                case 'u':
                    contador++;
                    break;
            }
        }
        /*Una vez terminado, se devuelve el valor obtenido de la variable "contador"*/
        return contador;
    }
}