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
public class ValorMáximo_4{
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Valor Maximo', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", introduzca la cantidad de numeros que quiera introducir: ");
        int cadena = usuario.nextInt();
        int [] numeros = new int [cadena];
        System.out.println("De los numeros introducidos, el de valor mas graqnde es: " + máximo(numeros));
    }
    public static int máximo(int t[]){
        Scanner usuario = new Scanner(System.in);
        int maximo = t [0];
        System.out.println("Introduce tus numeros: ");
        for (int i = 0; i < t.length; i++) {
            t[i] = usuario.nextInt();
            if (t [i] > maximo){
                maximo = t[i];
            }
        }
        return maximo;
    }
}