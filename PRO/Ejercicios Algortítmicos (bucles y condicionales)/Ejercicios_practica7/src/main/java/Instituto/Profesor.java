/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;
/**
 *
 * @author Alumno
 */
public class Profesor{
    private String departamento;

    public Profesor(String departamento){
        this.departamento = departamento;
    }

    public String getDepartamento(){
        return departamento;
    }

    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    @Override
    public String toString(){
        return """
                Profesor {"
                    "departamento = """ + departamento + "." +
               '}';
    }
    
    
}