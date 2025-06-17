/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicios_ut_5;
/*Se importa el paquete "Scanner"/escáner*/
import java.util.Scanner;
/**
 *
 * @author RODRISTARK17
 */
/*Se crea la clase*/
public class NumeroPerfecto{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Numero Perfecto', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico: ");
        int numero = usuario.nextInt();
        /*Se crean dos bucles o condicionales "if" donde se declara el caso de ruptura en el programa para valores iguales o inferiores a (0)*/
        if (numero <= 0){
            System.err.println("El numero introducido en el sistema no es válido (Recuerda utilizar un numero natural y/o entero, positivo y/o negativo), a excepcion del (0)");
        }
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "NumeroPerfecto" y se genera el método "esPerfecto"*/
        NumeroPerfecto clase = new NumeroPerfecto(numero);
        clase.esPerfecto();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de dos variables numéricas almacenables*/
    private int numero;
    /*Se crea el método "NumeroPerfecto" y el constructor para las dos varibales de dicho método*/
    public NumeroPerfecto(int numero){
        this.numero = numero;
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int suma_divisores_propios (int numero){ /*Se utilizará como un método auxiliar donde aislar los divisores de los numeros introducidos de forma individual*/
        /*Se crea una variable sumatoria*/
        int suma = 0;
        /*Se crea un bucle "for" donde la variable "i" recorre todas las posiciones desde el (1) hasta el numero introducido, excluyendo este mismo*/
        for (int i = 1; i < numero; i++){
            /*Se crea un bucle o condicional "if" donde se comprueba si el número aceptado por el bucle "for" ahora es divisor del numero, es decir, si al dividirlo, el resto da (0)*/
            if (numero % i == 0){
                /*Se incrementa la variable sumatoria "suma"*/
                suma += i;
            }
        }
        /*Se devuelve el valor de la variable "suma" con el último valor obtenido en el bucle "for" tras haber terminado*/
        return suma;
    }
    /*Se crea el método "esPerfecto" donde se encontrará el código funcional del programa*/
    public void esPerfecto(){
        /*Se crea una variable numérica donde su valor será el obtenido tras llamar al método "suma_divisores_propios" y aplicarle el "numero"*/
        int suma_divisores_numero = suma_divisores_propios(numero);
        /*Se crea un bucle o condicional "if" donde se estableecen las condiciones para la variable creada dentro de este método*/
        if (suma_divisores_numero == numero){
            /*Se imprime un mensaje en el caso de que las condicones del "if" se cumplan*/
            System.out.println("El numero (" + numero + ") es un numero perfecto.");
        }else{
            /*Se imprime un mensaje de error en el momento en el que los casaos recorridos por "if" no coincidan o se cumplan*/
            System.out.println("El numero (" + numero + ") no es un numero perfecto.");
        }
    }
}