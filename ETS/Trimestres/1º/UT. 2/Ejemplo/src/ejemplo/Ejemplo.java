/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alumno
 */
public class Ejemplo extends JFrame {

    public Ejemplo() {
        JLabel lblSaludo = new JLabel("Hola Mundo. Creando mi primer ejemplo");
        add(lblSaludo);
        this.setSize(600, 200);
        this.setTitle("JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo();
    }
}
