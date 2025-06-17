/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_practica2;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio1_2 {
    public static void main(String[] args) {
        System.out.println(Operaciones());
    }
    public static String Operaciones() {
        int A = 20;
        int B = 5;
        int suma = A + B;
        int resta = A - B;
        int multiplicacion = A * B;
        int division = A / B;
        int modulo = A % B;
        // "\n = newLine"
        return "Suma: " + suma + "\n" +
               "Resta: " + resta + "\n" +
               "Multiplicacion: " + multiplicacion + "\n" +
               "Division: " + division + "\n" +
               "Modulo: " + modulo;
    }
}