/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_practica2;
import java.util.Scanner;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio5_escaner {
    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        System.out.println(IVA(A));
        System.out.println(IGIC(A));        
    }

    public static String IVA(Scanner A) {
        System.out.print("Introduzca el precio del producto con IVA: ");
        double precio = A.nextDouble();
        double preciofinal = precio + (precio * 0.21);        
        return "El precio final del producto es de " + preciofinal + "€";
    }
    public static String IGIC(Scanner A){
        System.out.println("Introduzca el precio del producto con IGIC: ");
        double precio = A.nextDouble();
        double preciofinal = precio + (precio*0.07);
        return "El precio final del producto es de " + preciofinal + "€";
    }
}