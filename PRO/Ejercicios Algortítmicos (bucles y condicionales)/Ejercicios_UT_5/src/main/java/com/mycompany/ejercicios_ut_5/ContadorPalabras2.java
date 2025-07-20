/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class ContadorPalabras{
    private String texto;
    public ContadorPalabras(String texto){
        this.texto = texto;
    }
    public int contarPalabras(){
        String[] contador = texto.trim().split("\\s+");
        return contador.length;
    }
    public static void main(String[] args){
        ContadorPalabras cuenta = new ContadorPalabras ("No puedo más con este tema");
        System.out.println("El numero de palabras es: " + cuenta.contarPalabras());
    }
}