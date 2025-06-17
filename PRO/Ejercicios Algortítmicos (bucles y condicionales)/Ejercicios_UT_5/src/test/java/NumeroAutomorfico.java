/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alumno
 */
public class NumeroAutomorfico{
    private int numero;
    public NumeroAutomorfico(int numero){
        this.numero = numero;
    }
    public boolean esAutomorfico(){
        int cuadrado = numero * numero;
        String Numero = String.valueOf(numero); /*"valueOf" = Transforma el valor entero en cadena*/
        String Cuadrado = String.valueOf(cuadrado);
        return Cuadrado.endsWith(Numero); /*"end.Switch" = Comprueba/Verifica si la cadena "Cuadrado" termina igual que la secuencia "Numero"*/
    }
    public static void main(String[] args){
        NumeroAutomorfico tipo = new NumeroAutomorfico(5);
        if (tipo.esAutomorfico()){
            System.out.println("Es automorfico");
        }else{
            System.out.println("No es automorfico");
        }
    }
}