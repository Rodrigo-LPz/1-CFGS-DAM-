/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class SumaDigitos{
    private int numero;
    public SumaDigitos(int numero){
        this.numero = numero;
    }
    public int calcularSuma(){
        int original = numero;
        int contador = 0;
        while (original > 0){
            contador += original % 10;
            original /= 10;
        }
        return contador;
    }
    public static void main(String[] args){
        SumaDigitos cuenta = new SumaDigitos(777);
        System.out.println("La suma de los digitos es de: " + cuenta.calcularSuma());
    }
}