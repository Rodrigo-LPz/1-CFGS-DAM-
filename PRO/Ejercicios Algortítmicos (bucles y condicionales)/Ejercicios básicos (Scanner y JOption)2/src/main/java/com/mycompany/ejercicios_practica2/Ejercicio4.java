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
public class Ejercicio4 {
    public static void main (String[] args){
        System.out.println(ASCII());
        System.out.println(ASCIICHAR());
    }
    public static String ASCII (){
        String A = JOptionPane.showInputDialog ("Introduzca un caracter numerico de la tabla ASCII");
        int codigo = Integer.parseInt(A);
        char caracter = (char) codigo;
        return "Su equivalencia en caracter es: " + caracter;
    }
    public static String ASCIICHAR (){
        String B = JOptionPane.showInputDialog ("Introduzca un caracter de la tabla ASCII");
        char caracter = B.charAt(0); 
        int numero = (char) caracter;
        return "Su equivalencia numerica es: " + numero;
    }
}
