/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicios_practica2;
import javax.swing.JOptionPane;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println(Bienvenida());
        System.out.println(BienvenidaIntroducida());
    }
    public static String Bienvenida (){
        String nombre = "Rodrigo";
        return "Bienvenido/a " + nombre;
    }
    public static String BienvenidaIntroducida (){
        String A = JOptionPane.showInputDialog("Introduzca su nombre por favor");
        return "Bienvenido/a " + A;
    }
}
