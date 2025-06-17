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
public class EspiralNumeros{
    /*Se crea el método principal*/
    public static void main(String[] args){
        /*Se crea el escáner para interactuar con el usuario*/
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Dibujo de Espiral de Numeros', por favor ingrese su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido a la aplicacion " + nombre + ", ahora introduzca un caracter numerico para representar de cuanto sera la altura del dibujo: ");
        int numero_n = usuario.nextInt();
        /*Se crea un bucle o condicional "if" donde se declara el caso de ruptura en el programa para valores no naturales o de valor (0)*/
        if (numero_n <= 0){
            System.err.println("El numero introducido en el sistema no es válido (Recuerda utilizar un numero natural, positivo; y de valor mayor a cero)");
        }
        /*Se crea un salto de línea*/
        System.out.println("\n");
        /*Se instancia el método "EspiralNumeros" y se genera el método "generarEspiral"*/
        EspiralNumeros dibujo = new EspiralNumeros(numero_n);
        dibujo.generarEspiral();
        /*Se cierra el escáner*/
        usuario.close();
    }
    /*Se crea un método privado con un atributo de variable numerica almacenable*/
    private int numero_n;
    /*Se crea el método "EspiralNumeros" y el constructor para la variable de dicho método*/
    public EspiralNumeros(int numero_n){
        this.numero_n = numero_n;
    }
    /*Se crea el método "generarEspiral"*/
    public void generarEspiral(){
        /*Se crea una variable numérica para calcular el total de números que se colocaran en la espiral*/
        int total_numeros = numero_n * numero_n;
        /*Se crea una variable numerica con la que declarar el numero con el que se inicializará el programa/la espira inicializa*/
        int numero = 1;
        /*Se crea una variable para inicializar las coordenadas cartseianas/iniciales (x, y) (dos valores) en la posición [0][0]*/
        int coordenada_cartesianas_x = 0, coordenada_cartesianas_y = 0;
        /*Se crea una variable para inicializar las direcciones de movimiento: dx es el cambio en la coordenada x 
                                                                               dy es el cambio en la coordenada y
                                                                               Comenzamos moviéndonos hacia la derecha (dy = 1)*/
        int coordenada_diferencial_dx = 0, coordenada_diferencial_dy = 1;
        /*Se crea variable-matriz para almacenar la espiral*/
        int[][] espiral = new int[numero_n][numero_n];
        /*Se crea un bucle "while" donde alojar y completar la matriz*/
        while (numero <= total_numeros){
            /*Se asigna el número actual a la posición actual en la matriz*/
            espiral[coordenada_cartesianas_x][coordenada_cartesianas_y] = numero++;
            /*Se crea un bucle o condiciona "if" donde verificar si la próxima posición a colocar un numero se encuentra o está fuera de los límites o ya está ocupada: 1. Si nos movemos fuera del tamaño de la matriz
                                                                                                                                                                        2. Si la próxima celda ya tiene un número (diferente de 0)
                                                                                                                                                                        3. Si ocurre algo de lo anterior, se cambia la dirección*/
            if (coordenada_cartesianas_x + coordenada_diferencial_dx >= numero_n || coordenada_cartesianas_y + coordenada_diferencial_dy >= numero_n || coordenada_cartesianas_x + coordenada_diferencial_dx < 0 || coordenada_cartesianas_y + coordenada_diferencial_dy < 0 || espiral[coordenada_cartesianas_x + coordenada_diferencial_dx][coordenada_cartesianas_y + coordenada_diferencial_dy] != 0){
                /*Se crea una variable numérica para cambiar la dirección del movimiento que se está siguiendo en el que se está poniendo los numeros (en este caso rotación en sentido horario): dx toma el valor de dy, 
                                                                                                                                                                                                  dy toma el valor opuesto de dx (- temporal)*/
                int temporal = coordenada_diferencial_dx;
                coordenada_diferencial_dx = coordenada_diferencial_dy;
                coordenada_diferencial_dy = - temporal; /*(- temporal) = (- coordenada_diferenciales_dx)*/
            }
            /*Se actualizan las coordenadas para moverse a la siguiente celda*/
            coordenada_cartesianas_x += coordenada_diferencial_dx; /*(coordenada_cartesianas_x += coordenada_diferenciales_dx) = (coordenada_cartesianas_x = coordenada_cartesianas_x + coordenada_diferenciales_dx)*/
            coordenada_cartesianas_y += coordenada_diferencial_dy; /*(coordenada_cartesianas_y += coordenada_diferenciales_dy) = (coordenada_cartesianas_y = coordenada_cartesianas_y + coordenada_diferenciales_dy)*/
        }
        /*Se crea un bucle anidado "for" ("for" dentro de "for") donde se imprime la matriz de la espiral en pantalla*/
        for (int i = 0; i < numero_n; i++){ /*Recorre las filas*/
            for (int j = 0; j < numero_n; j++){ /*Recorre las columnas de la fila (i). Aquí es donde se trabaja con cada celda de la matriz [i][j] como si fuese una gráfica (x, y, z) → (i, j, k) solo que si la (z) y por ende la (k)*/
                /*Se imprime cada número con un formato de 4 espacios en blanco para mantener la alineación y la limpieza visual*/
                System.out.printf("%4d", espiral[i][j]);
            }
            /*Se crea un salto de línea*/
            System.out.println();
        }
    }
}