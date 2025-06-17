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
public class Ejercicio5 {
    public static void main (String [] args){
       String A = JOptionPane.showInputDialog ("Introduce un código de la tabla ASCII");        // Creamos la clave JOptionPane como una variable de String
       int codigo = Integer.parseInt(A);                                                        // Creamos la variable int con tradicción para la cadena de carácteres a símbolos numéricos
       char caracter = (char) codigo;                                                           // Creamos la variable char para indicar que lo traducido es un carácter no numérico del código
       System.out.println(caracter);                                                            // Mandamos a imprimir o proyectar el resultaso de la operación
    }
}