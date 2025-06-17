/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;
/**
 *
 * @author Alumno
 */
public class Registro{
    private String nombre;
    private String correo;
    
    public Registro(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    Registro(String susana, String croiwekefawei6774gmailcom, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getCorreo(){
        return correo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    @Override
    public String toString(){
        return """
                Registro {"
                    "nombre = """ + nombre + "." +
                    "correo = " + correo + "." +
               '}';
    }
}