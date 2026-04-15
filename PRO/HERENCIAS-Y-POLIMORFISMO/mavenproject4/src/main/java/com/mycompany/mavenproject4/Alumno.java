/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;
/**
 *
 * @author RODRISTARK17
 */
public class Alumno extends Persona{
    protected int nota;
    
    protected Alumno(){
    }

    protected Alumno(int nota, int id, String nombre, String apellido){
        super(id, nombre, apellido);
        this.nota = nota;
    }

    protected int getNota(){
        return nota;
    }

    protected void setNota(int nota){
        this.nota = nota;
    }
    
    public static void main(String[] args){
        
        // Aquí estamos trabajando bajo el constructor definido con parámetos.
        
        Persona alumno1 = new Persona(7, "Rodrigo", "López"); /* Relacionamos la clase de tipo 'anóinima' (new) para "alumno1" con el constructor definido con atributos de "Persona". */
        
        System.out.println("La ID del alumno (1) es: " + alumno1.getId());
        // Otra forma de hacerlo:
        
        /*
        int id = alumno1.getId();
        System.out.println("La ID del alumno 7 es: " + id);
        */
        System.out.println("El nombre del alumno es: " + alumno1.getNombre());
        System.out.println("Su apellido es " + alumno1.getApellido());
        System.out.println("Y su nota fue " + alumno1.getNota());
        
        System.out.println("-------------------------------------------------");
        
        // Aquí estamos trabajando bajo el constructor vacío.
        
        // Llamaos al alumno 2, pues no podemos volverlo a llamar como el anterior, pero sigue trabajando igual para ek ejemplo.
        Persona alumno2 = new Persona(); /* Relacionamos la clase de tipo 'anóinima' (new) para "alumno1" con el constructor vacío de "Persona". */
        alumno2.setId(5);
        alumno2.setNombre("Alejandro");
        alumno2.setApellido("Lorenzo");
        alumno2.setNota(9);
        
        System.out.println("La ID del alumno (2) es: " + alumno2.getId());
        System.out.println("El nombre del alumno es: " + alumno2.getNombre());
        System.out.println("Su apellido es " + alumno2.getApellido());
        System.out.println("Y su nota fue " + alumno2.getNota());
        
        System.out.println("-------------------------------------------------");
        
        // Ahora, supongamos que ya hemos registrado los valores para los respectivos atributos de "alumno1", por lo que ya están almacenados. Pero ahora queremos rescribir alguno de estos parámetros.
        
        alumno1.setNota(9); /* Se mostrará el mismo alumno pero con la nota cambiada o modificada. */
        
        System.out.println("La ID del alumno (1) es: " + alumno1.getId());
        System.out.println("El nombre del alumno es: " + alumno1.getNombre());
        System.out.println("Su apellido es " + alumno1.getApellido());
        System.out.println("Y su nota fue " + alumno1.getNota());
    }
}