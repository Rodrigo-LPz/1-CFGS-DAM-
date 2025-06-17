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
public class ContadorVocales{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Contador de Vocales', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        String texto = JOptionPane.showInputDialog("Bienvenido a la aplicacion " + nombre + ", ahora introduzca una letra o conjunto de estas (texto) para contabilizar el numero de vocales: ");
        /*Se instancia el método "ContadorVocales" y se genera el método "contarVocales" con salida de ventana/mensaje emergente*/
        ContadorVocales contador = new ContadorVocales(texto);
        JOptionPane.showMessageDialog(null, "El número total de vocales en el mensaje puesto en la consola (" + texto + ") es de: " + contador.contarVocales());/*El null se utiliza para no asiganar una ventana al mensaje, en este caso se pone porque no existe dicha ventana, ni tampoco la necesidad de crearla*/
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable no numérica almacenable*/
    private String texto;
    /*Se crea el método "ContadorVocales" y el constructor para la variable de dicho método*/
    public ContadorVocales(String texto) {
        this.texto = texto;
    }
    /*Se crea el método "contarVocales" donde se encontrará el código funcional del programa*/
    public int contarVocales(){
        /*Se crea una variable con las vocales*/
        String vocales = "aAeEiIoOuU";
        /*Se crea una variable para contabilizar*/
        int contador = 0;
        /*Se crea un buble "for"*/
        for (int i = 0; i < texto.length(); i++){
            /*Se crea una variable de tipo carcáter "char" que será igual al caracter recorrido en ese momento por el bucle (recorre letra por letra, cada vez que recorre una, empieza de nuevo y la variable adquiere el valor de esa nueva)*/
            char Texto = texto.charAt(i);
            /*Se crea un bucle o condicional "if" donde se comprueba si en la variable "texto" los caracteres son iguales al valor de la variable "vocales", si lo hay se sumará al contador, sino se devolverá un (-1) como indicador para el contador para que este no sume, pero el (-1) no resta*/
            if (vocales.indexOf(Texto) != -1){ /*"indexOf()"Busca el valor de una valiable, en este caso "vocales", dentro de otra, como es el cado de "texto". El (!= -1) es un valor devuelto por el "if" como indicador para indicar que el caracter leído no es una vocal. Es decir, si el caracter no es igual al de la variable, en este caso "vocales"*/
                /*Se suma un valor al "contador"*/
                contador++;
            }
        }
        /*Se devuelve la variable "contador"*/
        return contador;
    }
}