/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class AnioBisiesto{
    private int numero;
    public AnioBisiesto(int numero){
        this.numero = numero;
    }
    public boolean esBisiesto(){
        return numero % 4 == 0;
    }
    public static void main(String[] args){
        AnioBisiesto tipo = new AnioBisiesto (2024);
        System.out.println("Es un año bisiesto" + tipo.esBisiesto());
    }
}