/**
 *
 * @author Rodrigo
 */


@XmlRootElement (name = "socio")
@XmlType(propOrder = {"nombre", "ddireccion", "fechaAlta"})
@XmlAccessoryType(XmlAccessType.Field)
public class Socios{
    @XmlAttribute(name = "id", requeried = true)
    private int id;
    
    @XmlElement (name = "nombre")
    private String nombre;
    
    @XmlElement (name = "direccion")
    private String direccion;
    
    @XmlElement (name = "alta")
    private String fechaAlta;

    public Socios(){
    }

    public Socios(int id, String nombre, String direccion, String fechaAlta){
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
    }
    
    public int getId(){ return id; }
    public String getNombre(){ return nombre; }
    public String getDireccion(){ return direccion; }
    public String getFechaAlta(){ return fechaAlta; }

    public void setId(int id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDireccion(String direccion){ this.direccion = direccion; }
    public void setFechaAlta(String fechaAlta){ this.fechaAlta = fechaAlta; }

    @Override
    public String toString(){
        return "Socios{" + 
               "\n\tid: " + id + "\n\t\tnombre: " + nombre + ".\n\t\tdireccion: " + direccion + ".\n\t\tfechaAlta: " + fechaAlta +
               '}';
    }
}