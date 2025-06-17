/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_5;
/*Se importa el paquete "JOptionPane"/Panel de opciones*/
import javax.swing.JOptionPane;
/**
 *
 * @author RODRISTARK17
 */
/*Se crea la clase*/
public class Factorial{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crean las ventanas/mensajes emergentes para interactuar con el usuario*/
        String nombre = JOptionPane.showInputDialog("Bienvenido al programa 'Factorial', por favor ingrese su nombre: ");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al programa " + nombre + ", ahora por favor introduzca el numero del que quiera ver su secuencia factorial: "));
        if (numero <= 0) {
            System.err.println("El numero introducido en el sistema no es valido (Recuerda utilizar un numero natural, positiv, y mayor o distinto del valor (0))");
        }
        Factorial secuencia = new Factorial(numero);
        System.out.println(secuencia.calcularFactorial()); /*Se pone un "sout" dado que en el método "calcularFactorial" se devuelve una variable de tipo "String"*/
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "Factorial" y el constructor para la variable de dicho método*/
    public Factorial(int numero){
        this.numero = numero;
    }
    /*Se crea el método "calcularFactorial"*/
    public String calcularFactorial(){
        /*Se crea una variable numérica contabilizadora*/
        int secuencia = 1;
        /*Se crea una variable no numérica contabilizadora*/
        String secuencia_escrita = "";
        /*Se crea un bucle "for" donde la variable "i" recorre todas las posiciones desde el (1) hasta el numero introducido*/
        for (int i = 1; i <= numero; i++){
            /*Se incrementa el valor de la variable "secuencia" de forma factorial*/
            secuencia *= i; /*(secuencia *= i) = (secuencia = secuencia * i)*/
            secuencia_escrita += i; /*Se añade el número a la secuencia*/
            /*Se crea un bucle o condicional "if" donde se cumple que la variable "i" es menor al valor de la variable "numero"*/
            if (i < numero){
                /*Se incrementa el valor de la variable "secuencia_escrita"*/
                secuencia_escrita += " x ";
            }
        }
        /*Se devuelve la variable "secuencia" con el último valor obrtenido del bucle "for" tras haber finalizado junto a un mensaje*/
        return "Secuencia factorial del numero (" + numero + "):\n" + secuencia_escrita + " = " + secuencia; /*(\n) = salto de línea*/
    }
}