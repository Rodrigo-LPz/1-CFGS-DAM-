/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ayuntamientoharia;
/* Se importa el paquete "ArrayList"/lista de conjuntos o conjunto de matrices. */
 import java.util.ArrayList;
 /* Se importa el paquete "Collections"/colecciones. */
 import java.util.Collections;
 /* Se importa el paquete "Scanner"/escáner. */
 import java.util.Scanner;
 /* Se importa el paquete "JOptionPane"/panel de opciones. */
 import javax.swing.JOptionPane;
/**
 *
 * @author Alumno
 */

/*
En el ayuntamiento de Haría quieren registrar los datos de sus empleados, para ello quieren guardar los nombres, la edades y los salarios. Realiza un programa que introduzca el nombre, la edad y el salario de cada empleado. El proceso de lectura de datos terminará cuando se introduzca como nombre un asterisco (*) Al finalizar se mostrará los siguientes datos: (2 Puntos)
    •Toda la información recogida de todos los empleados.
    •Todos los empleados mayores de 55 años.
    •El salario medio del ayuntamiento.
    •Cuál es el menor de todos los empleados.
    •Cuál es el mayor de todos los empleados.
*/







public class AyuntamientoHaria{
    /* Se crean los distintos métodos privados con su respectiva variable numérica almacenable. */
    private ArrayList<Integer> sueldos; /* Utilizamos un "ArrayList<Integer>" en vez de un array fijo ya que nos permite insertar un número dinámico de sueldos, es decir, un numero no fijo de sueldos. */
    private ArrayList<String> nombres;
    private int edad;
    private double maximo;
    private double minimo;
    private double media;
    /* Se crea el método "Ejercicio2" y el constructor para las distintas variable de dicho método. */
    public AyuntamientoHaria(){ /* No seguimos la estructura clásica al crear constructores ("this maximo = maximo.....") ya que si lo hacemos así estaríamos declarando constructores con valores fijos. */
        /* Repetimos proceso para nombre. */
        nombres = new ArrayList<>();
        while (true){
            String nombre = JOptionPane.showInputDialog("Por favor, introduzca el nombre del empleado (Recuerde que para finalizar debe ingresar el valor '*'): ");
            if (nombre == "*"){
                break;
            } else{
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ahora ingrese su edad:"));
            }
            nombres.add(nombre);
        }
        /* Declaramos la creación de una lista dinámica, es el sustituto de usar "int []" para arrays de tamaño fijo. */
        sueldos = new ArrayList<>();
        /* Se crea un bucle de tipo "while" con la condición "true", esta condició es declarada para asignar que el bucle, en un principio, siempre será infinito, ya que no sabesmos cuántos sueldos se han obtenido. */
        while (true){ /* También podemos declarar la consición como "!= -1" pero para ello habría que definir "sueldo" antes del bucle, "int sueldo = 0". */
            /* Usamos "JOptionPane" para interactuar con el usuario.*/
            int sueldo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, introduzca el numero de sueldos obtenidos (Recuerde que para finalizar debe ingresar el valor '-1'): "));
            if (sueldo == -1 || sueldo < 0){ /*También se puede hacer declarando la condición del "if" así "sueldo.isEmpty", teniendo que cambiar el "int sueldo = encuestas.nextInt();" por el "String sueldo = encuestas.nextLine();". */
                break;
            }
            sueldos.add(sueldo);
        }
        /* Se crea un bucle o condicional del tipo "if" donde, si la lista de "sueldos" no está vacía llamamos al método privado "calcularEstadisticas". */
        if (!sueldos.isEmpty()){
            CalcularEstadisticas();
        } else{
            maximo = minimo = 0;
            media = 0.0;
        }
    }
    /* Se crea el método "CalcularEstadisticas" donde se encontrarán los distintos puntos pedidos por el enunciado del ejercicio. */
    public void CalcularEstadisticas(){
        /* Con el paquete "Collections" utilizamos la función "sort" para ordenar la lista "sueldos". */
        Collections.sort(sueldos);
        /* De igual forma, utilizamos las funciones ".get" y ".size" para obtener el valor máximo partiendo de que la lista "sueldos" ya se ha ordenado de menor a mayor. */
        maximo = sueldos.get(sueldos.size() -1); /* Obtiene el último elemento de la lista "sueldos" ya ordenada de menor a mayor.
                                                        "(sueldos.size())" devuelve el tamaño de la lista en un entero, por ejemplo: si la lista tiene 5 elementos, sueldos.size() devolverá 5.
                                                        "(sueldos.size() - 1)" el "- 1" ayuda a marcar la última posición, índice, de la lista, por ejemplo: si la lista tiene 5 elementos, el índice del último elemento será 5 - 1 = 4 (porque el último índice es siempre el total de elementos menos 1. Posiciones de un array, índice).
                                                        "sueldos.get(sueldos.size() - 1)" Si partimos del último ejemplo, .get(4). ".get" se usa para obtener el valor que se encuentra en el índice 4, es decir, el último índice y por tanto el valor más alto, máximo.
                                                */
        /* De igual forma, utilizamos la función ".get" para obtener el valor mínimo partiendo de que la lista "sueldos" ya se ha ordenado de menor a mayor. */
        minimo = sueldos.get(0);
        /* Obtenemos el valor de la media sumando todo y dividiéndolo por el número de sueldos obtenidos. */
        int suma = 0;
        for (int sueldo : sueldos){
            suma += sueldo;
        }
        media = suma / sueldos.size();
    }
    /* Se crea un último método "ImprimirResultados" donde imprimir los resultados. */
    public void ImprimirResultados(){
        System.out.println("\nLos sueldos obtenidos ordenados de menor a mayor queda de la siguiente forma: " + sueldos + "\n\n    El sueldo mas alto, de valor maximo es de " + maximo + "€\n    El sueldo mas bajo, de valor minimo es de " + minimo + "€\n    El sueldo medio de la localidad/municipio como computo de todos los sueldos sumados es de " + media + "€");
    }
    /* Se crea el método principal. */
    public static void main(String[] args){
        /* Se crea el escáner para interactuar con el usuario. */
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa del ayuntamiento de Haria 'Encuestas Estadisticas', por favor introduzca su nombre: ");
        String Nombre = usuario.nextLine();
        System.out.println("\nBienvenido al programa " + Nombre + ", por favor, a continuacion siga las instrucciones: ");
        /* Se instancia el método "Ejercicio2" y se genera el método"ImprimirResultados". */
        AyuntamientoHaria estadisticas = new AyuntamientoHaria();
        estadisticas.ImprimirResultados();
        /* Se cierra el escáner. */
        usuario.close();
    }
 }