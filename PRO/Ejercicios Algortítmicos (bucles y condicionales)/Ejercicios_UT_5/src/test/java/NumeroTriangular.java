/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RODRISTARK17
 */
public class NumeroTriangular{
    private int numero;
    public NumeroTriangular(int numero){
        this.numero = numero;
    }
    public void mostrarSerie(){
        for (int i = 1; i <= numero; i++) {
            int triangulo = (i * (i + 1)) / 2;
            System.out.println(triangulo);
        }
    }
    public static void main(String[] args){
        NumeroTriangular tipo = new NumeroTriangular(7);
        tipo.mostrarSerie();
    }
}
