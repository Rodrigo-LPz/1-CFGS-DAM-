/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicios.ut4;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Alumno
 */
public class EjerciciosUT4 {
    public static void main(String[] args) {
        String A = JOptionPane.showInputDialog("Por favor, introduzca un numero en funcion del algoritmo que quiera ejecutar o realizar (esto es valido del 1 al 16)");
        switch (A){
            case "1":
                System.out.println(Algoritmo1());
                break;
            case "2":
                System.out.println(Algoritmo2());
                break;
            case "3":
                System.out.println(Algoritmo3());
                break;
            case "4":
                System.out.println(Algoritmo4());
                break;
            case "5":
                System.out.println(Algoritmo5());
                break;
            case "6":
                System.out.println(Algoritmo6());
                break;
            case "7":
                System.out.println(Algoritmo7());
                break;
            case "8":
                System.out.println(Algoritmo8());
                break;
            case "9":
                Algoritmo9();
                break;
            case "10":
                System.out.println(Algoritmo10());
                break;
            case "11":
                System.out.println(Algoritmo11());
                break;
            case "12":
                System.out.println(Algoritmo12());
                break;
            case "13":
                System.out.println(Algoritmo13());
                break;
            case "14":
                System.out.println(Algoritmo14());
                break;
            case "15":
                System.out.println(Algoritmo15());
                break;
            case "16":
                System.out.println(Algoritmo16());
                break;
        } 
    }
    public static String Algoritmo1() {
        Scanner A = new Scanner(System.in);
        System.out.println("Por favor, introduzca un valor numerico: ");
        double B = A.nextDouble();
        if (B == 0) {
            return B + " el numero introducido no es par ni impar";
        } else if (B % (2) == 0) {
            return B + " el numero introducido es par";
        } else {
            return B + " el numero introducido es impar";
        }
    }
    public static String Algoritmo2() {
        Scanner A = new Scanner(System.in);
        System.out.println("Por favor, introduzca un valor numerico: ");
        double B = A.nextDouble();
        if (B % (10) == 0) {
            return B + " el numero es multiplo de 10";
        } else {
            return B + " el numero no es multiplo de 10";
        }
    }
    public static String Algoritmo3() {
        String A = JOptionPane.showInputDialog("Por favor, introduzca un caracter alfabetico");
        char B = A.charAt(0);
        if (Character.isUpperCase(B)) {
            return "El caracter (" + B + ") es o esta en mayuscula";
        } else {
            return "El caracter (" + B + ") no es o esta en mayuscula";
        }
    }
    public static String Algoritmo4() {
        Scanner A = new Scanner(System.in);
        System.out.println("Por favor, introduzca un caracter: ");
        char B = A.nextLine().charAt(0);
        System.out.println("Por favor, introduzca un segundo caracter: ");
        char C = A.nextLine().charAt(0);
        if (B == C) {
            return "El caracter (" + B + ") es igual que el caracter (" + C + ")";
        } else {
            return "El caracter (" + B + ") no es igual que el caracter (" + C + ")";
        }
    }
    public static String Algoritmo5() {
        double A = Double.parseDouble(JOptionPane.showInputDialog("Por favor, introduzca un caracter numerico: "));
        double B = Double.parseDouble(JOptionPane.showInputDialog("Por favor, introduzca un segundo caracter numerico: "));
        if (B == 0) {
            return "La division no se puede ejecutarse, pues el divisor no puede ser cero";
        } else {
            double Division = A / B;
            return "El resultado de la division es: " + Division;
        }
    }
    public static String Algoritmo6() {
        String A = JOptionPane.showInputDialog("Por favor, introduzca un caracter numerico: ");
        int Numero1 = Integer.parseInt(A);
        String B = JOptionPane.showInputDialog("Por favor, introduzca un segundo caracter numerico: ");
        int Numero2 = Integer.parseInt(B);
        String C = JOptionPane.showInputDialog("Por favor, introduzca un tercer caracter numerico: ");
        int Numero3 = Integer.parseInt(C);
        if (Numero1 > Numero2 && Numero1 > Numero3) {
            return "El numero (" + Numero1 + ") es el mayor de los tres numeros";
        } else if (Numero2 > Numero1 && Numero2 > Numero3) {
            return "El numero (" + Numero2 + ") es el mayor de los tres numeros";
        } else if (Numero3 > Numero1 && Numero3 > Numero2) {
            return "El numero (" + Numero3 + ") es el mayor de los tres numeros";
        }
        return null;
    }
    public static String Algoritmo7() {
        Scanner mes = new Scanner(System.in);
        System.out.println("Escribe un valor numerico que vaya del 1 al 12");
        int dias = mes.nextInt();
        switch (dias) {
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;
            default:
                System.out.println("El valor numerico debe estar entre el 1 y el 12");
        }
        return null;
    }
    public static int Algoritmo8() {
        int numero =1;
        while (numero < 100){
            System.out.println(numero);
            numero++;
        }
        return numero;
    }
    public static int Algoritmo9() {
        for (int numero =1; numero <= 100; numero++){
            System.out.println(numero);
    }
    public static void Algoritmo10() {
        int numero = 1;
        while (numero < 100){
        numero ++;
            if (numero%2 == 0 || numero%3 == 0){
                System.out.println(numero);
            }
        }
    }
    public static int Algoritmo11() {
    }
    public static int Algoritmo12() {
    }
    public static int Algoritmo13() {
    }
    public static int Algoritmo14() {
    }
    public static int Algoritmo15() {
    }
    public static int Algoritmo16() {
    }
}