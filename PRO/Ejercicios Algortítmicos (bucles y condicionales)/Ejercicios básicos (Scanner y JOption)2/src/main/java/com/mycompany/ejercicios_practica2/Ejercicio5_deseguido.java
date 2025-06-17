/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_practica2;
import javax.swing.JOptionPane;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio5_deseguido {
    public static void main (String[] args){
        String A = JOptionPane.showInputDialog ("Introduzca el precio del producto");
        System.out.println(IVA(A));
        System.out.println(IGIC(A));
    }
    public static String IVA(String A){
        double precio = Double.parseDouble (A);
        double preciofinal = precio + (precio*0.21);
        return "El precio final del producto con IVA es de " + preciofinal + "€";
    }
    public static String IGIC(String A){
        double precio = Double.parseDouble (A);
        double preciofinal = precio + (precio*0.07);
        return "El precio final del producto con IGIC es de " + preciofinal + "€";
    }
}