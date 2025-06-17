package Manager;

public class Cita{
    private int fecha;
    private int hora;
    private String descripcion;

    public Cita(int fecha, int hora, String descripcion){
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public int getFecha(){
        return fecha;
    }

    @Override
    public String toString(){
        return """
                Cita {"
                    "Fecha = """ + fecha + "." +
                    "Hora = " + hora + "." +
                    "Descripcion = " + descripcion + "." +
               '}';
    }
}