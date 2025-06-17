/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class NumeroPerfecto{
    private int numero;
    public NumeroPerfecto(int numero){
        this.numero = numero;
    }
    public boolean esPerfecto(){
        int contador = 0;
        for (int i = 1; i <= numero / 2; i++){
            if (numero % i == 0){
                contador += i;
            }
        }
        return contador == numero;
    }
    public static void main(String[] args){
        NumeroPerfecto tipo = new NumeroPerfecto(28);
        System.out.println("Es perfecto" + tipo.esPerfecto());
    }
}