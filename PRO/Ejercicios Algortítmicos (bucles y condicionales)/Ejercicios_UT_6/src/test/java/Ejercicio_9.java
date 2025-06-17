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
public class Ejercicio_9{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int puntos [] = new int [5]; //inicialmente intervienen 5 programadores
        for (int i = 0; i < 5; i++){
            System.out.print ("Puntos programador (" + (i + 1) + "): ");
            puntos[i] = sc.nextInt(); //leemos los datos, que no están ordenados
        }    
        Arrays.sort (puntos); //ordenamos
        System.out.println("Puntuacion: "+ Arrays.toString(puntos));
        System.out.print("Puntos del programador de exhibicion:");
        int puntosProgExh = sc.nextInt (); //puntuación del prog. de exhibición 
        while (puntosProgExh != -1){
            int pos = Arrays.binarySearch (puntos, puntosProgExh); //buscamos
            int indiceInsercion; //donde insertar para que la tabla siga ordenada
            if (pos < 0){
                indiceInsercion = -pos - 1; //indice para que la tabla esté ordenada
            }else {
                indiceInsercion = pos;//puntuación repetida, ya está en la tabla
            }
            int copia[] = new int [puntos.length + 1]; //nueva tabla con longitud+1
            //copiamos los elementos antes del "hueco"
            System.arraycopy (puntos, 0, copia, 0, indiceInsercion);
            //copiamos desplazados los elementos tras el "hueco"
            System.arraycopy (puntos, indiceInsercion, copia, indiceInsercion + 1, puntos.length- indiceInsercion);

            copia[indiceInsercion] = puntosProgExh; //asignamos el nuevo elemento
            puntos = copia; //puntos referencia la nueva tabla

            System.out.print("Puntos del programador de exhibicion: ");
            puntosProgExh = sc.nextInt (); //puntuacióndel prog. de exhibición
        }
        System.out.println("Puntuacion final:" + Arrays.toString(puntos));
    }
}