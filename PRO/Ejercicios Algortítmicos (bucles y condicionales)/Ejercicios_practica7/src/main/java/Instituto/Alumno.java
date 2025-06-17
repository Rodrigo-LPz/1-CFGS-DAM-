/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instituto;
/**
 *
 * @author Alumno
 */
public class Alumno{
    private int curso;

    public Alumno(int curso){
        this.curso = curso;
    }

    public int getCurso(){
        return curso;
    }

    public void setCurso(int curso){
        this.curso = curso;
    }

    @Override
    public String toString(){
        return """
                Alumno {"
                    "curso = """ + curso + "º." +
               '}';
    }
}