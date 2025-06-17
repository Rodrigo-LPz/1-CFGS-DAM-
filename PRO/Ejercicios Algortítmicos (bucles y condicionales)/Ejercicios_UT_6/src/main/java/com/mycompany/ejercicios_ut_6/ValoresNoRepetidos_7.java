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
public class ValoresNoRepetidos_7{
    public static int [] sinRepetidos (int t[]){
        int[] cadena = new int [t.length];
        int contador = 0;
        for (int i = 0; i < t.length; i++){
            boolean NumeroRepetido = false;
            for (int j = 0; j < contador; j++){
                if (t[i] == cadena[j]){
                    NumeroRepetido = true;
                    break;
                }
            }
            if (!NumeroRepetido){
                cadena[contador++] = t[i];
            }
        }
        int[] resultado = new int[contador];
        System.arraycopy(cadena, 0, resultado, 0, contador);
        return resultado;
    }
    public static void main(String[] args){
        int[] t = {1, 2, 2, 2, 3, 4, 4, 5};
        int [] resultado = sinRepetidos(t);
        System.out.println(Arrays.toString(resultado));
    }
}