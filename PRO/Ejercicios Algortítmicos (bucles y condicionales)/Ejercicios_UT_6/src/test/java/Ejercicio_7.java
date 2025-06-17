/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Arrays;

/**
 *
 * @author Alumno
 */
public class Ejercicio_7{
    public static int[] sinRepetidos(int[] t){
        int[] temp = new int[t.length];
        int size = 0;
        for (int i = 0; i < t.length; i++){
            boolean repetido = false;
            for (int j = 0; j < size; j++){
                if (t[i] == temp[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                temp[size++] = t[i];
            }
        }
        int[] resultado = new int[size];
        System.arraycopy(temp, 0, resultado, 0, size);
        return resultado;
    }
    public static void main(String[] args){
        int[] t = {1, 2, 2, 3, 4, 4, 5};
        int[] resultado = sinRepetidos(t);
        System.out.println(Arrays.toString(resultado));
    }
}