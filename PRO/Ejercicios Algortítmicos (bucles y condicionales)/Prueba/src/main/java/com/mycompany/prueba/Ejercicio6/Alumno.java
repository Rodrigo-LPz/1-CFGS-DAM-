/**
 *
 * @author Rodrigo
 */
package com.mycompany.prueba.Ejercicio6;


// Crea la clase "Alumno" donde almacenar todas los objetos, variables... privados correscpondientes y, por tanto, únicamente accesibles desde "Alumno".
public class Alumno{
    // Crea las distintas variables privadas del alumno.
    private String nombre;
    private String primerApellido;
    private int edad;
    private String curso;
    
    // Crea el constructor de la clase con sus respectivas variables/atributos privados.
    public Alumno(String nombre, String primerApellido, int edad, String curso) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.edad = edad;
        this.curso = curso;
    }
    
    // Crea los distintos métodos "get" con el que poder recuperar y/o leer el valor para cada una de las variables privadas del objeto alumno. 
    public String getNombre(){ return nombre; }
    public String getPrimerApellido(){ return primerApellido; }
    public int getEdad(){ return edad; }
    public String getCurso(){ return curso; }
    
    // Crea los distintos métodos "toString" donde poder sobrescribir dentro de una cadena el último valor obtenido por las variables privadas de "Alumno".
    @Override
    public String toString(){
        return """
               \t\tAlumno {Nombre: """ + " " + nombre + "." + 
                "Primer_Apellido: " + primerApellido + "." +
                "Edad: " + edad + "." +
                "Curso:" + curso + ". }";
    }
}