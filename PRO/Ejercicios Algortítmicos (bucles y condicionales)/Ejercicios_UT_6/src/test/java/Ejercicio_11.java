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
public class Ejercicio_11{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Longitud de la combinacion secreta: ");
        int Longitud = sc.nextInt();
        int CombSecreta[] = new int[Longitud];
        int CombJugada[] = new int[Longitud];
        System.out.println(Arrays.toString(CombSecreta));
        GenerarCombinacion(CombSecreta);
        System.out.println("Escriba una combinacion: ");
        LeerTabla(CombJugada);
        while (!Arrays.equals(CombSecreta, CombJugada)){
            MostrarPisats(CombSecreta, CombJugada);
            System.out.println("Escriba una combinacion: ");
            LeerTabla(CombJugada);
        }
        System.out.println("¡La camara esta abierta!");
    }
    static void GenerarCombinacion(int t[]){
        final int MAX = 5;
        for (int i = 0; i < t.length; i++){
            t[i] = (int) (Math.random() * MAX + 1);
        }
    }
    static void LeerTabla(int t[]){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < t.length; i++) {
            t[i] = sc.nextInt();
        }
    }
    static void MostrarPisats(int secreto[], int jugador[]){
        System.out.println("Pistas: ");
        for (int i = 0; i < jugador.length; i++) {
            System.out.println(jugador[i]);
            if (secreto[i] > jugador[i]){
                System.out.println(" mayor");
            } else if (secreto[i] > jugador[i]){
                System.out.println(" menor");
            } else{
                System.out.println(" igual");
            }
        }
    }
}