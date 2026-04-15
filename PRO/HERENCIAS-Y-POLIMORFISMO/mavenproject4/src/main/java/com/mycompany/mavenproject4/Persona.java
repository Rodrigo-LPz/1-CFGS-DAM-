/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject4;
/**
 *
 * @author RODRISTARK17
 */
public class Persona{
    private int id;
    private String nombre;
    private String apellido;
    
    // Podemos crear dos tipos de constructor con el mismo nombre, en este caso "Persona", ya que uno está vacío y el otro trabaja con atributos/parámetros.
    
    public Persona(){
    }
    
    public Persona(int id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //  Armamos los métodos "get" para obtener los datos asignados a cada uno de los atributos del constructor y "set" para mostrar esos datos.
    
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }    
    
    
    
    public void mostrarNombre(){ /* Declaramos "void" a fines de que lo que creemmos en la clase sea mostrado por pantalla y no devurlto. */
        System.out.println("Soy un alumno y mi nombre es " + nombre);
    }
}