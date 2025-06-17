/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;
/**
 *
 * @author Alumno
 */
public class Camion{
    private int CapacidadCarga;

    public Camion(int CapacidadCarga){
        this.CapacidadCarga = CapacidadCarga;
    }

    public int getCapacidadCarga(){
        return CapacidadCarga;
    }

    public void setCapacidadCarga(int CapacidadCarga){
        this.CapacidadCarga = CapacidadCarga;
    }

    @Override
    public String toString(){
        return """
                Camion {
                    "CapacidadCarga = """ + CapacidadCarga + "." +
               '}';
    }
}