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
public class Ejercicio8 {
    public static void main (String []args){
        String A = JOptionPane.showInputDialog ("Introduce el precio del producto");            // Creamos la clave JOptionPane como una variable de String en introduce precio
        String B = JOptionPane.showInputDialog("Introduce Península (P) o Cnarias (C)");        // Creamos la clave JOptionPane como una variable de String en introduce lugar
        char lugar = B.charAt(0);                                                               // Creamos la la variable char para almacernar la respuesta de la clave JOptionPane de lugar
        double precio = Double.parseDouble(A);                                                  // Creamos la variable double precio para convertir la cadena texto de la clave JOptionPane de precio en número de tipo decimal y almacenamiento de la variable precio
        double preciofinal;                                                                     // Creamos la variable double preciofinal como una condicional/variable
            if(lugar=='P'){                                                                     // Creamos la condicional Península (P)
            preciofinal = precio + (precio * 0.21);                                             // Definimos la condicional como el resultado del precio + el precio * 21% (IVA)
            System.out.println(preciofinal);                                                    // Mandamos a imprimir o proyectar el resultaso de la operación de la condicional Península (P)
            } else if(lugar=='C'){                                                              // Creamos la condicional restante, contraria a la condicional Península (P); la condicional Península (C)
            preciofinal = precio + (precio * 0.07);                                             // Definimos la condicional como el resultado del precio + el precio * 7% (IGIC)
            System.out.println(preciofinal);                                                    // Mandamos a imprimir o proyectar el resultaso de la operación de la condicional Península (C)
            }
    }
}
