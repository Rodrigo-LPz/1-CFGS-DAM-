/**
 *
 * @author Rodrigo
 */

package com.mycompany.persona;


//Clase 'Hijo' o subclase "Estudiante".
public class Estudiante extends Persona{ /* Extendesmos (heredamos) la sublacse "Estudiante" de la superclase "Persona". */
    // Método privado de tipo cadena de caracteres.
    private String curso;
    
    // Método constructor para el método privado y los métodos privados heredados de la clase 'Padre'.
    public Estudiante(String nombre, String correo, String curso){
        super(nombre, correo);
        this.curso = curso;
    }
    
    // Toma/Coge el método abstracto de la superclase para sobreescribir sus atributos.
    @Override
    public void mostrarInformacion(){
        System.out.println("\n\tESTUDIANTE" + "\n\t{Nombre: " + nombre + "}\n\t{Correo: " + correo + "}\n\t{Curso: " + curso + "}");
    }
}