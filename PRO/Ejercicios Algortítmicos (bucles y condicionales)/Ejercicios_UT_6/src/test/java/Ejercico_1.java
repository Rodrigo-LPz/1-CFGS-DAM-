/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alumno
 */
public class Ejercico_1{
        public static void main(String[] args){
        int [] array = new int[10];
        int contador = 0;
        for (int i = 0; i < array.length; i++){
            array [i] = (int) (Math.random()*100);
            System.out.println(array[i] + " + " + contador);
            contador += array[i];
        }
        System.out.println("La suma de todos los numeros es " + contador);
    } 
}