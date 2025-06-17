/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;
/**
 *
 * @author Alumno
 */
public class Vehiculos{
    private char matricula;
    private String marca;
    private String modelo;

    public Vehiculos(char matrícula, String marca, String modelo){
        this.matricula = matrícula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public char getMatrícula(){
        return matricula;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }

    public void setMatrícula(char matrícula){
        this.matricula = matrícula;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getmostrarInformación(){
        return 
    }

    @Override
    public String toString(){
        return """
               Vehiculos {"
                "Matricula = """ + matricula + "." +
                "Marca = " + marca + "." +
                "Modelo = " + modelo + "." +
              '}';
    }
}