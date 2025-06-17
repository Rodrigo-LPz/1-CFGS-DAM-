/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Arrays;
/**
 *
 * @author Alumno
 */
public class Ejercicio_12{
    public static void main (String[] args){
        int t[] [];
        t = new int [5] [5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                t[i] [j] = 10 * i + j;
            }
        }
        System.out.println(Arrays.deepToString(t)); /*".deepToString" es igual al ".toString" peo para convertir cadenas multidimensionales en cadena de caracteres. el ".toString" es para valores enteros*/
        for (int fila[] : t){ /*los dos puntos en un "for" es lo mismo que poner es igual a algo, no podemos ponerr (=) porque en los "for" se utiliza para recorrer posiciones*/
            for (int columna : fila){
                System.out.println(columna + " ");
            }
            System.out.println();
        }
    }
}
