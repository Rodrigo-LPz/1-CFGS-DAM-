/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.holamundo;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio4 {
    public static void main (String [] args){
       double radio, area;                                                  // Creamos la variable double del radio y del área
       Scanner circulo = new Scanner(System.in);                            // Mandamos a imprimir o proyectar la petición del ingreso
       System.out.println("Dame el radio de la circunferencia: ");          // Creamos el scanner
       circulo.useLocale (Locale.US);                                       // Indicamos que el escaner "círculo" se escribirá en el idioma local estadounidense
       radio = circulo.nextDouble ();                                       // Indicamos que radio equivale a almacenar en la variable radio y a leer el resultado
       area = Math.PI*Math.pow(radio, 2);                                   // Indicamos que area equivale a la operación matemática "PI" multiplicado por radio elevado al cuadrado
       System.out.println("El area de la circunferencia es: " + area);      // Mandamos a imprimir o proyectar el resultaso de la operación
    }
}
