package SAT.data;

import java.io.IOException;
import java.io.StringWriter;
import java.io.BufferedReader;
import java.io.*;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Xml{

  public static String toXml(Object obj) {

    String xmlString = new String();

    String objType = "" + obj.getClass();
    // only interested in class name, not qualified name
    objType = objType.substring(objType.lastIndexOf(".") + 1);

    try {
      StringWriter stringWriter = new StringWriter();

      XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
      XMLStreamWriter xMLStreamWriter =
        xMLOutputFactory.createXMLStreamWriter(stringWriter);

      // root node
      xMLStreamWriter.writeStartDocument();
      xMLStreamWriter.writeStartElement("Document");

      // object contained in document by class name
      xMLStreamWriter.writeStartElement(objType);

      // use BufferedReader to loop over lines in object serialized to text
      BufferedReader objReader = new BufferedReader(new StringReader(obj.toString()));
      
      // loop over contents
      String line=null;
      while( (line=objReader.readLine()) != null )
      {
        xMLStreamWriter.writeStartElement(line.substring(0,line.lastIndexOf(":")));
        xMLStreamWriter.writeCharacters(line.substring(line.lastIndexOf(":") + 1));
        xMLStreamWriter.writeEndElement();
      }

      xMLStreamWriter.writeEndElement();
      xMLStreamWriter.writeEndDocument();

      String xml = stringWriter.getBuffer().toString();

      stringWriter.close();
      xmlString = xml;

    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return xmlString;
  }
}
