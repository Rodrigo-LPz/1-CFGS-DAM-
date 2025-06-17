/**
 *
 * @author Rodrigo
 */

package com.mycompany.ejercicios_practica9;


// Crea la clase "Material" (solicitado en la activivdad) que implementará la interfaz "Serializable".
public class Material implements java.io.Serializable{
    // Declara la variables a usar en la clase.
    private String nombre;
    private int cantidad;
    private double precio;
    
    // Declara el construcor para/de dichas variables.
    public Material(String nombre, int cantidad, double precio){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    // Declara un método "get" con el que obtener una operación dada entre la cantidad del producto multiplicada por su valor de mercado.
    public double getTotal(){
        double gananciaNeta = cantidad * precio;
        return gananciaNeta;
        
    }
    
    // Declara el método "toString" con las variables creadas al principio de la clase.
    @Override
    public String toString(){
        return "Del material {" + nombre + "} tenemos la cantidad de {" + cantidad + "} con precio de {" + precio + "}.\n\tPor tanto del material {" + nombre + "} tendremos una ganancia neta de " + getTotal();
    }
}