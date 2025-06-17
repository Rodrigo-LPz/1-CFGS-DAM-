/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Ejercicio_3{
    public static void main(String[] args){
        System.out.println("Cuantos numeros desea introducir?");
        Scanner sc = new Scanner(System.in);
        int numeros = sc.nextInt();
        int num[] = new int[numeros];
        System.out.println("Introduzca los numeros");
        for (int i = 0; i < numeros; i++){
            num[i] = sc.nextInt();
        }
        System.out.println("Los numeros son:");
        for (int i = num.length-1; i >= 0; i--) {
            System.out.println(num[i]);
        }
    }
}