/**
 *
 * @author Rodrigo
 */
package com.mongodb.mavenproject2;

import java.io.util*;


// Se crea la clase.
public class GestorTareas{
    // Se crea el método principal de la clase "GestorTareas".
    public static void main(String[] args){
        Scanner user = Scanner(System.in);
        // Declara una instancia con la que hacer la llamada al objeto "Pantalla".
        Pantalla pantalla = new Pantalla();
        // Visualiza el objeto "pantalla".
        pantalla.setVisible(true);
        // Declara la visualización de la pantalla sin tomar como referencia ninguna localización/coordenada como referencia.
        pantalla.setLocationRelativeTo(null);
    }
}
