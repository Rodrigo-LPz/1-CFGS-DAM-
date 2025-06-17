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
public class Ejercicio7 {
    public static void main (String [] args){
       String A = JOptionPane.showInputDialog ("Introduce el precio del producto");        // Creamos la clave JOptionPane como una variable de String
       double precio = Double.parseDouble(A);                                              // Creamos la variable double precio para convertir la cadena texto en número de tipo decimal y almacenamiento de la variable precio
       double preciofinal = precio + (precio * 0.21);                                      // Creamos la variable double preciofinal que equivale a la variable percio + la variable precio * 21% (IVA)
       System.out.println(preciofinal);                                                    // Mandamos a imprimir o proyectar el resultaso de la operación
    }
}
