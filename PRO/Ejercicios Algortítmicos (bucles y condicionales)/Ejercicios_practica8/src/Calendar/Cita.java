package com.mycompany.practico;

public class Cita{
    private String fecha, hora, descripcion;

    public Cita(String fecha, String hora, String descripcion){
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public String getfecha(){
        return fecha;
    }

    public void setfecha(String fecha){
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return "Fecha: " + fecha + ".\nHora: " + hora + ".\nDescripción: " + descripcion + ".";
    }
}