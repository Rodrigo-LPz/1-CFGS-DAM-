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
public class Ejercicio5 {
    public static void main (String[] args){
        System.out.println(IVA());
        System.out.println(IGIC());
    }
    public static String IVA(){
        String A = JOptionPane.showInputDialog ("Introduzca el precio del producto con IVA");
        double precio = Double.parseDouble (A);
        double preciofinal = precio + (precio*0.21);
        return "El precio final del producto es de " + preciofinal + "€";
    }
    public static String IGIC(){
        String A = JOptionPane.showInputDialog ("Introduzca el precio del producto con IGIC");
        double precio = Double.parseDouble (A);
        double preciofinal = precio + (precio*0.07);
        return "El precio final del producto es de " + preciofinal + "€";
    }
}
