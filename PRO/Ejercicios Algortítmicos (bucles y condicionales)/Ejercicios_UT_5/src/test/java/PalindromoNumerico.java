/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RODRISTARK17
 */
public class PalindromoNumerico {
    private int numero;
    public PalindromoNumerico(int numero){
        this.numero = numero;
    }
    public boolean esPalindromo(){
        int original = numero;
        int invertido = 0;
        while (original != 0){
            int digito = original % 10;
            invertido = invertido * 10 + digito;
            original /= 10;
        }
        return numero == invertido;
    }
    public static void main(String[] args){
        PalindromoNumerico tipo = new PalindromoNumerico(777);
        if (tipo.esPalindromo()){
            System.out.println("Es palindromo");
        }else{
            System.out.println("No es palindromo");
        }
    }
}