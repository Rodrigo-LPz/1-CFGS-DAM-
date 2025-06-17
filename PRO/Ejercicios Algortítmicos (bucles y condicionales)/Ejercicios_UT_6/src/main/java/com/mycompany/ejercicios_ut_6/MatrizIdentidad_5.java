/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_6;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class MatrizIdentidad_5{
    private int numero;
    public MatrizIdentidad_5(int numero){
        this.numero = numero;
    }
    public void generarMatriz(){
        int [][] matriz = new int[numero] [numero];
        System.out.print("\n");
        for (int i = 0; i < matriz.length; i++){
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println(" |");
        }
    }
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Matriz Identidad', por favor, introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + nombre + ", introduzca un numero con el que crear la matriz: ");
        int numero = usuario.nextInt();
        MatrizIdentidad_5 tipo = new MatrizIdentidad_5 (numero);
        tipo.generarMatriz();
        usuario.close();
    }
}