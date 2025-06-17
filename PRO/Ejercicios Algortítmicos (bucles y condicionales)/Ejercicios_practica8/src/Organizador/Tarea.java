package Organizador;

public class Tarea{
    private String titulo;
    private int prioridad;
    private String completada;

    public Tarea(String titulo, int prioridad, String completada){
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public String getTitulo(){
        return titulo;
    }
    public int getPrioridad(){
        return prioridad;
    }
    public String getCompletada(){
        return completada;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    public void setCompletada(String completada){
        this.completada = completada;
    }
    
    public boolean IsCompletada(){
        if (completada == "Si"){
            return true;
        } else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return """
                Tarea {"
                    "Titulo = """ + titulo + "." +
                    "Prioridad = " + prioridad + "." +
                    "Completada = " + completada + "." +
               '}';
    }
}