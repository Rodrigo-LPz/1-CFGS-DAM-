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
public class Ejercicio2_escaner {
    public static void main (String[] args){
        System.out.println(Bienvenida());
    }
    public static String Bienvenida (){
        Scanner A = new Scanner(System.in);
        System.out.println("Introduzca su nombre por favor:");
        String B = A.nextLine();
        return "Bienvenido/a " + B;
    }
}
