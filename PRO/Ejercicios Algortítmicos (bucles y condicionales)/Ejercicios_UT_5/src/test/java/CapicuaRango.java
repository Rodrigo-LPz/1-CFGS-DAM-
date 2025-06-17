/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author RODRISTARK17
 */
public class CapicuaRango{
    private int numero1, numero2;
    public CapicuaRango(int numero1, int numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    private boolean esCapicua(int numero){
        int original = numero;
        int invertido = 0;
        while (original != 0){
            int digito = original % 10;
            invertido = invertido * 10 + digito;
            original /= 10;
        }
        return numero == invertido;
    }
    public void mostrarCapicuas(){
        for (int i = numero1; i <= numero2; i++){
            if (esCapicua(i)){
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args){
        CapicuaRango tipo = new CapicuaRango(100, 200);
        System.out.println("Estos son los numeros capicua comprendidos entre el 100 y 200: ");
        tipo.mostrarCapicuas();
    }
}