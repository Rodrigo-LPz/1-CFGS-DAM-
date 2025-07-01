/**
 *
 * @author Rodrigo
 */

package com.mycompany.persona;


//Clase 'Hijo' o subclase "Profesor".
public class Profesor extends Persona{
    private String departamento;
    
    // Método constructor para el método privado y los métodos privados heredados de la clase 'Padre'.

    public Profesor(String nombre, String correo, String departamento){
        super(nombre, correo);
        this.departamento = departamento;
    }
    
    
    // Toma/Coge el método abstracto de la superclase para sobreescribir sus atributos.
    @Override
    public void mostrarInformacion(){
        System.out.println("\n\tPROFESOR" + "\n\t{Nombre: " + nombre + "}\n\t{Correo: " + correo + "}\n\t{Departamento: " + departamento + "}");
    }
}