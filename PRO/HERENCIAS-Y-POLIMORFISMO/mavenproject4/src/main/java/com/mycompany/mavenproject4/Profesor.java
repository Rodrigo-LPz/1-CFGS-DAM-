/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;
/**
 *
 * @author RODRISTARK17
 */
public class Profesor extends Persona{ /* Declaramos la clase "Profesor" como una clase hijo o subclase procedente (EXTENDIDA) de la clase "Persona". */
    protected String asignatura;
    protected int curso;
    protected double sueldo;

    protected Profesor(){
    }

    protected Profesor(String asignatura, int curso, double sueldo, int id, String nombre, String apellido){
        super(id, nombre, apellido);
        this.asignatura = asignatura;
        this.curso = curso;
        this.sueldo = sueldo;
    }

    protected String getAsignatura(){
        return asignatura;
    }
    protected int getCurso(){
        return curso;
    }
    protected double getSueldo(){
        return sueldo;
    }

    protected void setAsignatura(String asignatura){
        this.asignatura = asignatura;
    }
    protected void setCurso(int curso){
        this.curso = curso;
    }
    protected void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    
    
}