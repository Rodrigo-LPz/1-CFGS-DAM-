/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;
/**
 *
 * @author Alumno
 */
public class Coche{
    private int N_Puertas;

    public Coche(int N_Puertas){
        this.N_Puertas = N_Puertas;
    }

    public int getN_Puertas(){
        return N_Puertas;
    }

    public void setN_Puertas(int N_Puertas){
        this.N_Puertas = N_Puertas;
    }

    @Override
    public String toString(){
        return """
                "Coche {"
                    N_Puertas = """ + N_Puertas + "." +
               '}';
    }
}