/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class TrianguloRectangulo{
    private int numero;
   
    public TrianguloRectangulo(int numero){
        this.numero = numero;
    }
    public void dibujarTriangulo(){
        for (int i = 0; i < numero; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        TrianguloRectangulo dibujo = new TrianguloRectangulo(7);
        dibujo.dibujarTriangulo();
    }
}