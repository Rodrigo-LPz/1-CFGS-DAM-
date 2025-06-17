/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Vehiculos;
import java.util.Scanner;
/**
 *
 * @author Alumno
 */
public class Main{
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'Guia para vehiculos', por favor introduzca su nombre: ");
        String nombre = usuario.nextLine();

        // Creamos algunos vehiculos
        Vehiculos coche1 = new Vehiculos("3999NJN", "Audi", "A1 Sportback", true);
        Vehiculos coche2 = new Vehiculos("9454GHF", "Audi", "A1 allstreet", true);
        Vehiculos coche3 = new Vehiculos("1098MMB", "Audi", "RS 7 Sportback", true);
        Vehiculos coche4 = new Vehiculos("2314JMD", "Audi", "RS 7 Sportback performance", true);
        Vehiculos camion1 = new Vehiculos("7888MJH", "VOLVO", "Volvo FH16 Aero", true);
        Vehiculos camion2 = new Vehiculos("5224BJN", "IVECO ", "IVECO S-WAY Rígido", true);
        Vehiculos camion3 = new Vehiculos("0914CJL", "VOLVO", "Volvo FH Aero", true);
        Vehiculos moto1 = new Vehiculos("3284CHB", "Aprilia", "RS 660", true);
        Vehiculos moto2 = new Vehiculos("6871DHG", "KTM", "1190", true);

        String[] Vehiculos = {"Coche", "Camion", "Moto"};
        int[] Cadena = new int[3];
        for (int i = 0; i < Cadena.length; i++){
            
        }
        usuario.close();
    }
}