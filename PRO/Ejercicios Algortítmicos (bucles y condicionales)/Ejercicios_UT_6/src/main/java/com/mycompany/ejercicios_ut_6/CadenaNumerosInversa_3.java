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
public class CadenaNumerosInversa_3 {
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Cadena Numeros Inversa', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", introduzca la cantidad de numeros que quiera ordenar: ");       
        int cadena = usuario.nextInt();
        int inversa[] = new int[cadena];
        System.out.println("\nAhora introduzca los numeros: ");
        for (int i = 0; i < cadena; i++){
            inversa[i] = usuario.nextInt();
        }
        System.out.println("\nEl orden inverso de los numeros introducidos es el siguiente: ");
        for (int i = inversa.length -1; i >= 0; i--){
            System.out.println(inversa[i]);
        }
    }
}