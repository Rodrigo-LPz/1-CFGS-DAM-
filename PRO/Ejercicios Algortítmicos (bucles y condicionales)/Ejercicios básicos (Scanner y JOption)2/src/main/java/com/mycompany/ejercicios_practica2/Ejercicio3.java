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
public class Ejercicio3 {
    public static void main (String[] args){
        System.out.println(AreaCirculo());
    }
    public static double AreaCirculo (){
        double radio = Double.parseDouble(JOptionPane.showInputDialog ("Introduzca el radio de la circunferencia"));
        double area = Math.PI*Math.pow(radio, 2);
        return area;
    }
}
