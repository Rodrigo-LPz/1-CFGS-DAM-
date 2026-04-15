/**
 *
 * @author Rodrigo
 */
package com.mycompany.xmlpartner;


import java.io.File;

public class XMLpartner{
    public static void main(String[] args){
        try{
            JAXBContext ctx = JAXBContext.newInstance(Socio.class);
            Unmarshaller um = ctx.createUnmarshaller();
            Socio s = (Socio) um.unmarshal(new File("Socios.xml"));
            
            Socio s1 = new Socio(25, "Pepe Botella", "Dirección desconocida", "01/01/2025");
            
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, boolean.TRUE);
            m.marshal(s1, new File("socios2.xml"));
        } catch (JAXBException ex){
            System.getLogger(XMLSocios.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}