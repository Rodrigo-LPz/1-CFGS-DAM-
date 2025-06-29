package com.mycompany.practica2;

import java.util.ArrayList;


public class Main{
    public static void main(String[] args){
        ArrayList<Tarea> listaTareas = new ArrayList<>();

        listaTareas.add(new Tarea("Comprar", 1, true));
        listaTareas.add(new Tarea("Leer", 4, false));
        listaTareas.add(new Tarea("Cocinar", 2, true));
        listaTareas.add(new Tarea("Fregar", 3, false));

        for (Tarea tarea : listaTareas){
            if (tarea.isCompletada() == false){
                System.out.println("Tus tareas pendientes son:" + tarea.toString());
            }
        }
    }
}