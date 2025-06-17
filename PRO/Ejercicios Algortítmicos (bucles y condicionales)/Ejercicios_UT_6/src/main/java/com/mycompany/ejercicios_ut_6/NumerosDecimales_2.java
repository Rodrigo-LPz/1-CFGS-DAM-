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
public class NumerosDecimales_2{
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Numeros Decimales', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", introduzca tus cinco numeros decimales: ");
        double [] cadena = new double[5];
        for (int i = 0; i < 5; i++){
            double numeros = usuario.nextDouble();
            cadena[i] = numeros;
        }
        System.out.println("\nEl orden de los numeros introducidos es el siguiente: ");
        for (int i = 0; i < 5; i++){
            System.out.println(cadena[i]);
        }
        usuario.close();
    }
}