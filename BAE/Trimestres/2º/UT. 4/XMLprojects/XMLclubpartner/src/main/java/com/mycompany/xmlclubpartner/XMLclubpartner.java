/**
 *
 * @author Rodrigo
 */
package com.mycompany.xmlclubpartner;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class XMLclubpartner{
  public static void main(String[] args){
    JAXBContext ctx;
    try{
      ctx = JAXBContext.newInstance(Club.class);
      
      //De XML a Java.
      Unmarshaller um = ctx.createUnmarshaller();
      Club c = (Club) um.unmarshal(new File("club.xml"));
      System.out.println(c);
    } catch (JAXBException ex){
      System.getLogger(XMLclubpartner.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
  }
}