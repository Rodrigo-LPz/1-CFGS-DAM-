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
public class NumerosAmistosos{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Numeros Amistosos', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico: ");
        int numero1 = usuario.nextInt();
        System.out.println("Ahora introduzca un segundo numero: ");
        int numero2 = usuario.nextInt();
        /*Se crean dos bucles o condicionales "if" donde se declara el caso de ruptura en el programa para valores iguales a (0)*/
        if (numero1 == 0){
            System.err.println("El numero introducido en el sistema no es válido (Recuerda utilizar un numero natural y/o entero, positivo y/o negativo), a excepcion del (0)");
        }
        /*Se crea un bucle o condicional "if" donde se declara el caso de ruptura en el programa para valores no naturales o de valor (0)*/
        if (numero2 == 0){
            System.err.println("El numero introducido en el sistema no es válido (Recuerda utilizar un numero natural y/o entero, positivo y/o negativo), a excepcion del (0)");
        }
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "NumerosAmistosos" y se genera el método "sonAmistosos"*/
        NumerosAmistosos dibujo = new NumerosAmistosos(numero1, numero2);
        dibujo.sonAmistosos();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de dos variables numéricas almacenables*/
    private int numero1, numero2;
    /*Se crea el método "NumerosAmistosos" y el constructor para las dos varibales de dicho método*/
    public NumerosAmistosos(int numero1, int numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
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
    /*Se crea el método "sonAmistosos" donde se encontrará el código funcional del programa*/
    public void sonAmistosos(){
        /*Se crea una variable numérica donde su valor será el obtenido tras llamar al método "suma_divisores_propios" y aplicarle el "numero1"*/
        int suma_divisores_numero1 = suma_divisores_propios(numero1);
        /*Se crea una variable numérica donde su valor será el obtenido tras llamar al método "suma_divisores_propios" y aplicarle el "numero2"*/
        int suma_divisores_numero2 = suma_divisores_propios(numero2);
        /*Se crea un bucle o condicional "if" donde se estableecen las condiciones para las dos variables creadas dentro de éste método*/
        if (suma_divisores_numero1 == numero2 && suma_divisores_numero2 == numero1){
            /*Se imprime un mensaje en el caso de que las condicones del "if" se cumplan*/
            System.out.println("Los numeros (" + numero1 + ") y (" + numero2 + ") son una pareja de numeros amistosos.");
        }else{
            /*Se imprime un mensaje de error en el momento en el que los casaos recorridos por "if" no coincidan o se cumplan*/
            System.err.println("Los numeros (" + numero1 + ") y (" + numero2 + ") no son una pareja de numeros amistosos.");
        }
    }
}