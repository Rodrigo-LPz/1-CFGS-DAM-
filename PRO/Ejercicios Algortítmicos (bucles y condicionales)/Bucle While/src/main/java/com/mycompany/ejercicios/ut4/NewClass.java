/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicios.ut4;
/**
 *
 * @author Alumno
 */
public class NewClass {
    public static void main(String[] args) {
        Algoritmo();
    }
    public static void Algoritmo() {
        int numero = 1;
        while (numero < 100){
        numero ++;
            if (numero % 2 == 0 || numero % 3 == 0){
                System.out.println(numero);
            }
        }
    }
}