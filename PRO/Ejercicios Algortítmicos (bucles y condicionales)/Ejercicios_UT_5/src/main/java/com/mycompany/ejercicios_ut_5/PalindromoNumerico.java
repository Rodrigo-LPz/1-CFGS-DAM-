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
public class PalindromoNumerico {
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Palindromo Numerico', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        /*Se crea la ventana/mensaje emergente para interactuar con el usuario*/
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico para visualizar/conocer si dicho numero es palindromo o no: "));
        /*Se crean un bucle o condicional "if" donde se declara el caso de que el valor de la variable introducida "numero" tenga menos de dos cifras*/
        if (numero <=9){
            System.err.println("El numero introducido en el sistema no es valido (Recuerda utilizar un numero natural, positivo; y de mas de 2 cifras, es decir, superior a (9))");
            return;
        }
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "PalindromoNumerico" y se genera el método "esPalindromo"*/
        PalindromoNumerico dibujo = new PalindromoNumerico(numero);
        dibujo.esPalindromo();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numérica almacenable*/
    private int numero;
    /*Se crea el método "PalindromoNumerico" y el constructor para la variable de dicho método*/
    public PalindromoNumerico(int numero){
        this.numero = numero;
    }
    /*Se crea el método "esPalindromo" donde se encontrará el código funcional del programa*/
    public void esPalindromo(){
        /*Se crea una variable para guardar el número original*/
        int original = numero;
        /*Se crea una variable para guardar el número invertido*/
        int invertido = 0;
        /*Se crea una variable para contabilizar los dígitos/números del número original*/
        int digitos = (int) Math.log10(numero) + 1; /*El logaitmo en base 10 (log10) de un numero da el número de dígitos. (int) se utiliza para obtener un entero en caso de decimales después del logaritmo*/
        /*Se crea un bucle "for" para obtener los dígitos de la variable "numero" en orden inverso*/
        for (int i = 0; i < digitos; i++){
            /*Se crea una variable equivalente o con el valor del último dígito*/
            int digito = numero % 10; /*Se divide el numero entre 10 y cogemos el resto*/
            /*Se opera a la variable "invertido" y se le agrega el dígito al numero invertido*/
            invertido = invertido * 10 + digito; /*Se multiplica el "invertido" por 10 = 0, ya que invertido = 0. Resultando en que invertido = al dígito de la variable anterior "digito". Esto hace que el 3 quede como primer número, quedando a la izquierda
                                                   Ejemplo: numero = 123 → original = 123; invertido = 0; digitos = log10(123)≈ 2,089 → 10^2,089 ≈ 123
                                                            1º digito = 123 % 10 = 3 (Resto de la división)
                                                            2º invertido = 0 *10 + 3 → 3 (el 3 pasa de la posición 003 a la 300)*/
            /*Se opera a la variable "numero" para quitar el íltimo dígito*/
            numero = numero / 10; /*numero = 123 / 10 = 12. Después de obtener el 12 se repetíria el proceso poniendo después de la nueva posición del 3 el resto de números*/
        }
        /*Se crea un bucle o condicional "if" con el que comparar el numero original y el obtenido tras el bucle "for"*/
        if (original == invertido){
            /*Se imprime un mensaje en caso de que la condición del "if" se cumpla*/
            System.out.println("El numero introducido en el programa (" + original +") es un numero palindromo");
         /*Se crea una respuesta para los casos en los que no se han cumplido las condiciones del "if"*/
        }else{
            /*Se imprime un mensaje de erro en caso de que no se cumpla la condición del "if"*/
            System.err.println("El numero introducido en el programa (" + original +") no es un numero palindromo");
        }
    }
}