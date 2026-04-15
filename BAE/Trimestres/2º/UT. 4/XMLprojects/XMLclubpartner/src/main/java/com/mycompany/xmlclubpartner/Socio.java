/**
 *
 * @author Rodrigo
 */
package com.mycompany.xmlclubpartner;


import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement (name="socio")
@XmlType(propOrder={"nombre", "direccion", "FechaAlta"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Socio{
  @XmlAttribute(name = "id", required=true)
  private int id;
  @XmlElement(name = "nombre")
  private String nombre;
  @XmlElement(name = "direccion")
  private String direccion;
  @XmlElement(name = "alta")
  private String FechaAlta;

    public Socio(){}
    
    public Socio(int id, String nombre, String direccion, String FechaAlta){
      this.id = id;
      this.nombre = nombre;
      this.direccion = direccion;
      this.FechaAlta = FechaAlta;
    }

    public int getId(){ return id; }
    public String getNombre(){ return nombre; }
    public String getDireccion(){ return direccion; }
    public String getFechaAlta(){ return FechaAlta; }
    
    public void setId(int id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDireccion(String direccion){ this.direccion = direccion; }
    public void setFechaAlta(String FechaAlta){ this.FechaAlta = FechaAlta; }

    @Override
    public String toString(){
        return "Socio{" +
                    "\n\tid: " + id + "." +
                    "\n\tNombre: " + nombre + "." +
                    "\n\tDireccion: " + direccion + "." +
                    "FechaAlta: " + FechaAlta + "." +
               '}';
    }
}