/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.holamundo;
import java.util.Scanner;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio3 {
    public static void main (String[] args){
        Scanner nombre = new Scanner(System.in);                        // Creamos el scanner
        System.out.println("Ingrese su nombre: ");                      // Mandamos a imprimir o proyectar la petición del ingreso
        String A = nombre.nextLine();                                   // Creamos el String con el nombre de usuario a escribir
        System.out.println("Bienvenido Bat" + A + " a su guarida");        // Mandamos a imprimir o proyectar el resultaso de la operación
    }
}
