/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;
/**
 *
 * @author Alumno
 */
public class Moto{
    private int Cilindrada;

    public Moto(int Cilindrada){
        this.Cilindrada = Cilindrada;
    }

    public int getCilindrada(){
        return Cilindrada;
    }

    public void setCilindrada(int Cilindrada){
        this.Cilindrada = Cilindrada;
    }

    @Override
    public String toString(){
        return """
                Moto {
                    "Cilindrada = """ + Cilindrada + "." +
               '}';
    }
}