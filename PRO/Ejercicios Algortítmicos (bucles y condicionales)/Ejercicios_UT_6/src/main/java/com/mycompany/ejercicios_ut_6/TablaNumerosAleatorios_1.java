/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_6;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
/*Se crea la clase*/
public class TablaNumerosAleatorios_1{
    /*Se crea el método principal del sistema*/
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Numeros Decimales', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", esta es tu tabal de numeros randoms\n");
        
        // Se crea un array de 10 elementos para guardar los números aleatorios
        int [] tabla = new int [10];
        /*Se crea una variable numérica contabilizadora*/
        int contador = 0;
        /*Se crea un bcle "for" donde recorrer 10 numeros,veces, del 1 al 100*/
        for (int i = 0; i < tabla.length; i++){
            /*Se genera un número aleatorio entre el 1 y el 100*/
            tabla [i] = (int) (Math.random() * 100 + 1);
            /*se imprime un mensaje junto con las operaciones*/
            System.out.println(tabla [i] + " + " + contador + " = " + (contador + tabla[i]));
            /*Se incrementa la variable "contador"*/
            contador += tabla [i];
        }
        /*Se imprime un mensaje junto con la declaración del último resultado obtenido en la variable "contador"*/
        System.out.println("\nLa suma total de todos los numeros randoms obtneidos entre el 1 y el 100 es de " + contador);
    }
}