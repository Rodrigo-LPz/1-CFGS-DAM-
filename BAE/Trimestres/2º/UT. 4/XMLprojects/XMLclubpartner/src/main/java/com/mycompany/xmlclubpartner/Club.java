/**
 *
 * @author Rodrigo
 */
package com.mycompany.xmlclubpartner;


// Importa de la biblioteca/librería el paquete "Arrays".
import java.util.Arrays;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement (name="socio")
@XmlType(propOrder={"nombre", "direccion", "FechaAlta"})
@XmlAccessorType(XmlAccessType.FIELD)
// Crea la clase "Club".
public class Club{
    // Declara los atributos mediante variables privadas.
    private String nombreClub;
    private Socio[] listaSocios; /* Array privado*/
    private String nif;
    
    // Crea el constructor vacío de la clase.
    public Club(){}
    
    // Crea el constructor para los atributos.
    public Club(String nombreClub, Socio[] listaSocios, String nif){
        this.nombreClub = nombreClub;
        this.listaSocios = new Socio[0];
        this.nif = nif;
    }
    
    // Método para integrar nuevos socios, objetos, al array desde el final.
    public void nuevoSocio(Socio socio){
        this.listaSocios = Arrays.copyOf(this.listaSocios, this.listaSocios.length+1); /* Colapsa el array "listaSocios" para crear uno nuevo pero con un espacio de más. */
        this.listaSocios[this.listaSocios.length - 1] = socio; /*  */
    }
    
    // Crea el método "get" para obtener/acceder a los atributos.
    public String getNombreClub(){ return nombreClub; }
    public Socio[] getListaSocios(){ return listaSocios; }
    public String getNif(){ return nif; }
    
    // Crea el método "set" para poner/colocar los atributos.
    public void setNombreClub(String nombreClub){ this.nombreClub = nombreClub; }
    public void setListaSocios(Socio[] listaSocios){ this.listaSocios = listaSocios; }
    public void setNif(String nif){ this.nif = nif; }
    
    // Crea el método "toString" para modificar los atributos.
    @Override
    public String toString(){
        return "Club{" +
                    "\n\tnombreClub: " + nombreClub + "." +
                    "\n\tlistaSocios: " + listaSocios + "." +
                    "\n\tnif:" + nif + "." +
               '}';
    }
}