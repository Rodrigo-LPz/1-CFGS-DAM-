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
/*Se crea la clase "VerificadorPrimo"*/
public class VerificadorPrimo{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Verificador de Numeros Primos', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un valor numerico para saber si es primo o no: "));
        /*Se instancia el método "VerificadorPrimo" y se genera el método "esPrimo"*/
        VerificadorPrimo verificador = new VerificadorPrimo(numero);
        verificador.esPrimo();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "VerificadorPrimo" y el constructor para la variable de dicho método*/
    public VerificadorPrimo(int numero){
        this.numero = numero;
    }
    /*Se crea la clase "esPrimo" donde se encontrará el código funcional del programa*/
    public boolean esPrimo(){
        /*Se crea un bucle o condicional "if"*/
        if (numero <= 1){
            /*Se imprime un mensaje de eror*/
            System.err.println("El numero introducido no entra o no es reconocido por nuestro sistema (verifica si el caracter introducido es numerico y si es mayor a 1)");
            /*Se devuelve un valor falso y se detiene la ejecución del programa*/
            return false;
          /*Se replica o da una condición contraria a la condición original del "if" anterior*/
        } else{
            /*Se crea un bucle "for"*/
            for (int i = 2; i <= Math.sqrt(numero); i++){
                /*Se crea un bucle o condicional "if"*/
                if (numero % i == 0){
                    /*Se imprime un mensaje de eror*/
                    System.err.println("El numero introducido en la consola (" + numero + ") no es un numero primo.");
                   /*Se devuelve un valor falso y se detiene la ejecución del programa*/
                   return false;
                } else{
                    /*Se imprime un mensaje*/
                    System.out.println("El numero introducido en la consola (" + numero + ") es un numero primo.");
                    /*Se devuelve un valor verdadero y se termina de ejecutar el programa*/
                    return true;
                }
            }
        }
        /*Se devuelve un valor verdadero y se termina de ejecutar el programa*/
        return true;
    }
}