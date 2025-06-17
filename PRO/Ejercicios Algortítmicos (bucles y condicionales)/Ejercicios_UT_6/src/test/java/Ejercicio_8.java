/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Ejercicio_8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int datos []; //tabla para los datos iniciales

        //creamos las tablas par e impar, inicialmente de longitud 0:
        int par[] = new int [0];
        int impar[] = new int [0];

        System.out.print("Escriba n: ");
        int n = sc.nextInt(); // n es el número de datos a leer
        datos = new int [n]; //creamos la tabla de longitud n

        // leemos del teclado los valores de la tabla
        for (int i = 0; i < datos.length; i++){
            System.out.print ("Introduzca un numero: ");
            datos[i] = sc.nextInt();
        }

        //recorremos los datos para clasificarlos
        for (int numero : datos){
        //al estar la tabla con todos los datos ordenadas, los elementos
        //se insertarán siempre al final de la tabla par o impar.
            if (numero % 2 == 0){//si número es par
                par = Arrays.copyOf (par, par.length+1); //incremento la longitud de par
                par [par.length-1] = numero; //guardo el número en el último elemento
            }else{
                impar = Arrays.copyOf(impar, impar.length+1); //igual con la tabla impar
                impar[impar.length-1] = numero;
            }
        }    
        System.out.println("Pares: " +  Arrays.toString(par));
        System.out.println("Impares: " + Arrays.toString(impar));
    }
}