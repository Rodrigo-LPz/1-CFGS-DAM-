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
/*Se crea la clase "ContadorVocales"*/
public class ContadorPalabras{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Contador de Palabras', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        String texto = JOptionPane.showInputDialog("Bienvenido a la aplicacion " + nombre + ", ahora introduzca el texto en el que se desee contabilizar el numero de palabras: ");
        /*Se instancia el método "ContadorPalabras" y se genera el método "contarPalabras" con salida de ventana/mensaje emergente*/
        ContadorPalabras contador = new ContadorPalabras(texto);
        JOptionPane.showMessageDialog(null, "El número total de palabras en el mensaje introducido en la consola (" + texto + ") es de: " + contador.contarPalabras());/*El null se utiliza para no asiganar una ventana al mensaje, en este caso se pone porque no existe dicha ventana, ni tampoco la necesidad de crearla*/
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable no numérica almacenable*/
    private String texto;
    /*Se crea el método "ContadorPalabras" y el constructor para la variable de dicho método*/
    public ContadorPalabras(String texto) {
        this.texto = texto;
    }
    /*Se crea el método "contarPalabras" donde se encontrará el código funcional del programa*/
    public int contarPalabras(){
        /*Se crea un bucle o condicional "if" para descartar texto vacíos o sin relleno*/
        if (texto == null || texto.trim().isEmpty()){ /*(.trim()) = Eliminar los espacios en blanco al principio y al final de la cadena, pero no los que están dentro del texto
                                                        (.isEmpty()) = Comprueba si la cadena está vacía o sin relleno antes de seguir con el programa*/
            return 0;
        }
        /*Actuamos en la variable "texto" dividiendo el contendio de este lecturas individuales, divide la cadena por los espacios*/
        String[] palabras = texto.trim().split("\\s+"); /*(.split()) = Divide la cadena en partes o "trozos" según un delimitador o condición impuesta
                                                          ("\\s+") = Divide la cadena donde haya uno o más espacios en blanco consecutivos*/
        /*Se devuelde el resultado obtenido */
        return palabras.length;
    }
}