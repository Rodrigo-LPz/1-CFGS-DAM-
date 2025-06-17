/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_5;
/*Se importa el paquete "Scanner"/escáner*/
import java.util.Scanner;
/*Se importa el paquete "JOptionPane"/panel de opciones*/
import javax.swing.JOptionPane;
/**
 *
 * @author RODRISTARK17
 */
/*Se crea la clase "CuadradoHueco"*/
public class CuadradoHueco {
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Dibujo de Cuadro Hueco', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico para representar de cuanto sera la altura del dibujo: "));
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "CuadradoHueco" y se genera el método "dibujarCuadrado"*/
        CuadradoHueco dibujo = new CuadradoHueco(numero);
        dibujo.dibujarCuadrado();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "CuadradoHueco" y el constructor para la variable de dicho método*/
    public CuadradoHueco(int numero){
        this.numero = numero;
    }
    /*Se crea el método "dibujarPiramide" donde se encontrará el código funcional del programa*/
    public void dibujarCuadrado(){
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        String caracter = JOptionPane.showInputDialog("Ahora introduzca el caracter con el que desee dibujar el cuadrado hueco: ");
        /*Se crea un bucle "for" para la primera línea*/
        for (int i = 0; i < numero + 2; i++){
            /*Se imprime el mensaje o resultado de la variable "caracter"*/
            System.out.print(caracter);
        }
        /*Se crea un salto de línea*/
        System.out.println();    
        /*Se crea un bucle "for" para el contenido intermedio*/
        for (int i = 0; i <= numero - 2; i++){
            /*Se imprime el mensaje o resultado de la variable "caracter"*/
            System.out.print(caracter); /*Primer carácter*/
            /*Se crea un bucle "for" para generar el vacío dentro del contenido del intermedio*/
            for (int j = 0; j < numero; j++){
                /*Se imprime el mensaje para el espacio vacío en el interior del cuadrado*/
                System.out.print(" ");
            }
            /*Se imprime el mensaje o resultado de la variable "caracter"*/
            System.out.print(caracter); /*Últimp carácter*/
            /*Se crea un salto de línea*/
            System.out.println();    
        }
        /*Se crea un bucle "for" para la última línea*/
        for (int i = 0; i < numero + 2; i++){
            /*Se imprime el mensaje o resultado de la variable "caracter"*/
            System.out.print(caracter);
        }
        /*Se crea un salto de línea*/
        System.out.println();    
    }
}