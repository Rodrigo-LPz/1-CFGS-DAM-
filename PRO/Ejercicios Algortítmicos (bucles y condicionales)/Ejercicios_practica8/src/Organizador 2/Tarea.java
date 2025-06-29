package com.mycompany.practica2;


public class Tarea{
    private String titulo;
    private int prioridad;
    private boolean completada;

    public Tarea(String titulo, int prioridad, boolean completada){
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public boolean isCompletada(){
        return completada;
    }

    public void setCompletada(boolean completada){
        this.completada = completada;
    }

    @Override
    public String toString(){
        return "Título: " + titulo + ".\nPrioridad: " + prioridad + "./nEstado: " + (completada ? "completada." : "no completada."); /* "(completada ? "completada" : "no completada")" equivale a un bucle o condicional de tipo "if-else". */
    }
}