/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class Main{
    public static void main(String[] args){
        Scanner usuario = new Scanner(System.in);
        System.out.println("Bienvenido al programa 'IES Haria', por favor introduzca su nombre: ");
        String nombre = usuario.nextLine();
        System.out.println("Bienvenido al programa " + nombre + ".");

        // Creamos algunos registros
        Registro alumno1 = new Registro("Susana", "croiwekefawei-6774@gmail.com", true);
        Registro alumno2 = new Registro("Miguel", "reubaussallonneu-2837@gmail.com", true);
        Registro profesor1 = new Registro("Martín", "premaleuveba-8262@gmail.com", true);
        Registro profesor2 = new Registro("Marta", "netanawoleu-9085@gmail.com", true);
        Registro profesor3 = new Registro("Lucía", "noiceidapruroi-4351@gmail.com", true);
        
        int[] Registro = new int [2];
        int[] Cadena = new int[2];
        for (int i = 0; i < Cadena.length; i++){
            if (Cadena[i] == Registro[i]){
                
            }
            Registro[i]++;
        }
        usuario.close();
    }
}