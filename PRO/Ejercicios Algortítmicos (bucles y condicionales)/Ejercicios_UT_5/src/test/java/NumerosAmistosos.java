/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class NumerosAmistosos{
    private int numero1, numero2;
    public NumerosAmistosos(int numero1, int numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    private int suma_divisores_propios(int numero){
        int contador = 0;
        for (int i = 1; i <= numero / 2; i++){
            if (numero % i == 0) {
                contador += i;
            }
        }
        return contador;
    }
    public boolean sonAmistosos(){
        int suma_divisores_numero1 = suma_divisores_propios(numero1);
        int suma_divisores_numero2 = suma_divisores_propios(numero2);
        return suma_divisores_numero1 == numero2 && suma_divisores_numero2 == numero1;
    }
    public static void main(String[] args){
        NumerosAmistosos tipo = new NumerosAmistosos(220, 284);
        if (tipo.sonAmistosos()){
            System.out.println("Son amistosos");
        }else{
            System.out.println("No son amistosos");  
        }
    }
}