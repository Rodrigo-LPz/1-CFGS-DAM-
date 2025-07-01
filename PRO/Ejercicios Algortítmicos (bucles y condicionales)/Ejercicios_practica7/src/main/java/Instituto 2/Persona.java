/**
 *
 * @author Rodrigo
 */

package com.mycompany.persona;


//Clase 'Padre' o superclase "Persona".
public abstract class Persona{ /* La clase será de tipo "abstract" ya que la clase 'Padre' es una idea/referencia genérica, no es una instancia real de un objeto tal como lo pueden ser "Estudiante" y "Profesor". */
    // Dos métodos protegidos de tipo cadena de caracteres.
    protected String nombre, correo; /* Los métodos "protected" a diferencia de los "private" permiten ser usados por sublclases. */
    
    // Método constructor para los métodos privados.
    public Persona(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }
    
    // Método "mostrarInformacion".
    public abstract void mostrarInformacion();
}