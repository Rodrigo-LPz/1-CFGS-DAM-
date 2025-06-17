/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_6;
import java.util.Arrays;
/**
 *
 * @author Alumno
 */
public class Primitiva_6{
    public static void main(String[] args){
        int[] NumeroGanador = {1, 14, 17, 25, 10, 37};
        int[] NumeroGenerado = new int [6];
        for (int i = 0; i < NumeroGenerado.length; i++){
            NumeroGenerado[i] = (int) (Math.random() * 49 + 1);            
        }
        int contador = 0;
        String generado = Arrays.toString(NumeroGenerado);
        String ganador = Arrays.toString(NumeroGanador);
        for (int i = 0; i < NumeroGenerado.length; i++){
            if (NumeroGenerado[i] == NumeroGanador[i]){
                contador ++;
            }
        }
        System.out.println("El numero ganador era el " + ganador);
        System.out.println("Tu numero fue el " + generado);
        if (generado == ganador){
            System.out.println("!Enhorabuena¡ Has ganado.");
        }else{
            System.out.println("Has perdido. Vuelva a comprar otro boleto.");
        }
        System.out.println("\nLa cantidad de numeros acertados fue de " + contador);
    }
}