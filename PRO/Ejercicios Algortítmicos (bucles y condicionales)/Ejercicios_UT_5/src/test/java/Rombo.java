/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class Rombo{
    private int numero;
    public Rombo(int numero){
        this.numero = numero;
    }
    public void dibujarRombo(){
        /*Primera piramide*/
        for (int i = 1; i <= numero; i++){
            for (int j = 1; j <= numero - i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = numero - 1; i >= 1; i--){
            for (int j = 1; j <= numero - i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Rombo dibujo = new Rombo(7);
        dibujo.dibujarRombo();
    }
}