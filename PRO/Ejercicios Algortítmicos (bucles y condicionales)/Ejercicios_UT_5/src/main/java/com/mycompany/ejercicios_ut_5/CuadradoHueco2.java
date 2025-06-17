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
public class CuadradoHueco2 {
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
        /*Se instancia el método "CuadradoHueco" y se genera el método "dibujarCuadrado2"*/
        CuadradoHueco2 dibujo = new CuadradoHueco2(numero);
        dibujo.dibujarCuadrado2();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "CuadradoHueco2" y el constructor para la variable de dicho método*/
    public CuadradoHueco2(int numero){
        this.numero = numero;
    }
    /*Se crea el método "dibujarCuadrado2" donde se encontrará el código funcional del programa*/
    public void dibujarCuadrado2(){
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        String caracter = JOptionPane.showInputDialog("Ahora introduzca el caracter con el que desee dibujar el cuadrado hueco: ");
        /*Se crea un bucle "for" para cada fila del cuadrado*/
        for (int i = 0; i < numero; i++){
            /*Se crea un bucle "for" para cada columna del cuadrado*/
            for (int j = 0; j < numero; j++){
                /*Se crea un bucle o condicional "if" para los bordes del cuadro*/
                if (i == 0 || i == numero - 1 || j == 0 ||j == numero - 1){ /*Se dibuja el carácter puesto en la variable "caracter" si en alguno de estos casos el valor es equivalente a (0) o a (numero - 1):
                                                                              "i == 0"             Es la primera fila
                                                                              "i == numero - 1"    Es la última fila
                                                                              "j == 0"             Es la primera columna
                                                                              "j == numero - 1"    Es la última columna
                                                                              En el momento en el que en alguno de estos casos el valor no sea equivalente a (0) o a (numero - 1) se dejará un espacio vacío*/
                    /*Se imprime el mensaje para el espacio vacío en el interior del cuadrado*/
                    System.out.print(caracter);
                /*Se crea el resultado del/los posibles casos que no estén dentro del "if" con un "else"*/
                }else{
                    /*Se imprime el mensaje para el espacio vacío en el interior del cuadrado*/
                    System.out.print(" ");
                }
            }
            /*Se crea un salto de línea*/
            System.out.println();    
        }
    }
}