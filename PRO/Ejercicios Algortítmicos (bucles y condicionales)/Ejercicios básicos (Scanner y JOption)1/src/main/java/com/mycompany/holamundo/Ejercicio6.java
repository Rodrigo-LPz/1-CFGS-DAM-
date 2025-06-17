/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.holamundo;
import javax.swing.JOptionPane;

/**
 *
 * @author RODRISTARK17
 */
public class Ejercicio6 {
    public static void main (String [] args){
       String A = JOptionPane.showInputDialog ("Introduce un carácter");        // Creamos la clave JOptionPane como una variable de String
       char caracter = A.charAt(0);                                             // Creamos la variable char con tradicción a su semejante en la tabla ASCII y almacenamiento de la cadena
       int numero = (char) caracter;                                            // Creamos la variable int para indicar que lo traducido es un carácter numérico del código
       System.out.println(numero);                                              // Mandamos a imprimir o proyectar el resultaso de la operación
    }
}
