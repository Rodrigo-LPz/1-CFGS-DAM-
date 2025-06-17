/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Ejercicio_2 {
            public static void main(String[] args){
        System.out.println("Introduca 5 numeros decimales por teclado");
        Scanner sc = new Scanner (System.in);
        double num[] = new double[5];

        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextDouble();
        }
        
        System.out.println("Los numeros son:");
        for (int i = 0; i < 5; i++) {
            System.out.println(num[i]);
        }
    }
}