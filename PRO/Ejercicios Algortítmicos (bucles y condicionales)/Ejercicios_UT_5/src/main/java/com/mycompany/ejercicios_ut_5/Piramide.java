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
/*Se crea la clase "Piramide"*/
public class Piramide{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Dibujo de Piramide', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico para representar de cuanto sera la altura del dibujo: "));
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "Piramide" y se genera el método "dibujarPiramide"*/
        Piramide dibujo = new Piramide(numero);
        dibujo.dibujarPiramide();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "Piramide" y el constructor para la variable de dicho método*/
    public Piramide(int numero){
        this.numero = numero;
    }
    /*Se crea el método "dibujarPiramide" donde se encontrará el código funcional del programa*/
    public void dibujarPiramide(){
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        String Caracter = JOptionPane.showInputDialog("Ahora introduzca el caracter con el que desee dibujar la piramide: ");
        /*Se crea un bucle "for" para la altura de la piramide*/
        for (int altura = 1; altura <= numero; altura++){
            /*Se crea un bucle "for" para los espacios en blanco de la piramide*/
            for (int espacio = 1; espacio <= numero - altura; espacio++){
                /*Se imprime un mensaje*/
                System.out.print(" ");
            }
            /*Se crea un bucle "for" para el caracter(dibujo) de la piramide*/
            for (int caracter = 1; caracter <= altura * 2 - 1; caracter++){
                /*Se imprime el mensaje o resultado de la variable "Caracter"*/
                System.out.print(Caracter);
            }
            /*Se crean las capas o niveles de la pirámide*/
            System.out.println(""); /*También se puede hacer con (System.out.println("\n") aunque habrá un pequeño espacio entre las líneas de los distintos niveles del dibujo; )*/
        }
    }
}