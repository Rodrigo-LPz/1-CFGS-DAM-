/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Arrays;
/**
 *
 * @author Alumno
 */
public class Ejercicio_10{
    private int t, valor;
    public Ejercicio_10(int t, int valor){
        this.t = t;
        this.valor = valor;
    }
    public static int[] eliminarMayores(int t[], int valor){
        int[] copia = Arrays.copyOf(t, t.length); //copia es un clon de t
        int i = 0;
        while (i < copia.length){ // recorremos la copia
            if (copia[i] > valor){ //Hay que eliminar la copia[i]
                copia[i] = copia[copia.length - 1]; //copiamos el último en copia[i] y decrementamos la longitud de copia en 1. Elimina el último.
                copia = Arrays.copyOf(copia, copia.length -1);//ahora tendremos que volver a comprobar copia[i]. No modificamos i
            }else{
                i++;
            }
        }
        return copia;
    }  
    public static void main(String[] args){
        int[] t = {1, 2, 3, 4, 5};
        int valor = 3;
        int[] resultado = eliminarMayores(t , valor);
        System.out.println(Arrays.toString(resultado));
    }
}