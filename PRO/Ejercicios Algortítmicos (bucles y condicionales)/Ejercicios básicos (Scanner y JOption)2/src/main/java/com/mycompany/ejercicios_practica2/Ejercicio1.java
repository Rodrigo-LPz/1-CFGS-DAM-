/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicios_practica2;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        int A = 14;
        int B = 7;
        System.out.println("El resultado de la suma es: " + suma(A, B));
        System.out.println("El resultado de la resta es: " + resta(A, B));
        System.out.println("El resultado de la multiplicacion es: " + multiplicacion(A, B));
        System.out.println("El resultado de la division es: " + division(A, B));
        System.out.println("El resultado del modulo es: " + modulo(A, B));
    }
    public static int suma (int A, int B){
        int suma = A + B;
        return suma;
    }
    public static int resta (int A, int B){
        int resta = A - B;
        return resta;
    }
    public static int multiplicacion (int A, int B){
        int multiplicacion = A * B;
        return multiplicacion;
    }
    public static int division (int A, int B){
        int division = A / B;
        return division;
    }
    public static int modulo (int A, int B){
        int modulo = A % B;
        return modulo;
    }
}
