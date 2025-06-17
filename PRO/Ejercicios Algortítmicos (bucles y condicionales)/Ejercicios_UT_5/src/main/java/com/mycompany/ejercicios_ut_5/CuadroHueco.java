/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios.ut5;

/**
 *
 * @author Alumno
 */
public class CuadroHueco {
    public static void main(String[] args) {
        CuadroHueco hueco = new CuadroHueco(7);
        hueco.dibujarCuadrado();
    }
    private int caracter;
    public CuadroHueco(int caracter){
        this.caracter = caracter;
    }
    public void dibujarCuadrado(){
        for (int i = 0; i < caracter + 2; i++){ /*Primeral fila*/
            System.out.print("*");
        }
        System.out.println(); /*Salto de línea*/
        for (int altura = 0; altura <= caracter - 2; altura++){ /*Contenido restante*/
            System.out.print("*"); /*Primer asterisco*/
            for (int espacio = 0; espacio < caracter; espacio++){ /*Espacio vacío*/
                System.out.print(" ");
            }
        System.out.print("*"); /*Último asterisco*/
        System.out.println(); /*Salto de línea*/
        }
        for (int i = 0; i < caracter + 2; i++){ /*Última fila*/
            System.out.print("*");
        }
        System.out.println(); /*Salto de línea*/
    }
}
