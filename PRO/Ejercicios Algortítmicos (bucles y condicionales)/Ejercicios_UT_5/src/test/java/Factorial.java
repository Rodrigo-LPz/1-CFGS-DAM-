/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class Factorial{
    private int numero;
    public Factorial(int numero){
        this.numero = numero;
    }
    public int calcularFactorial(){
        int secuencia = 1;
        for (int i = 2; i <= numero; i++){
            secuencia *= i;
        }
        return secuencia;
    }
    public static void main(String[] args){
        Factorial sucesion = new Factorial(7);
        System.out.println("El resultado es: " + sucesion.calcularFactorial());
    }
}