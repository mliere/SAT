package SAT.data;

import java.io.IOException;
import java.io.StringWriter;
import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import SAT.model.shape.*;

// used for writing xml
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

// used for reading xml
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;

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

  public static Shape fromXml(String xml) {
    try {

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();

      DefaultHandler handler = new DefaultHandler() {

        String identifier;
        String shapeType;
        boolean bId=false;
        boolean bAttr=false;

        List<String> attributes = new ArrayList<String>();

        public void startElement(String uri, String localName,String qName, 
            Attributes attributes) throws SAXException {

          System.out.println("Start Element :" + qName);
          if(qName=="id") {bId = true;}

          // assume only 1 shape per document
          if(qName=="Cube") {shapeType = qName;}
          System.out.println(shapeType);

          if(qName=="length") {bAttr = true;}
          if(qName=="width") {bAttr = true;}
          if(qName=="height") {bAttr = true;}
        }

        public void endElement(String uri, String localName,
            String qName) throws SAXException {

          System.out.println("End Element :" + qName);
          if(qName=="Document") {
            String[] attributeArray = new String[attributes.size()];
            attributeArray = attributes.toArray(attributeArray);
            Object object = ShapeFactory.getShape(shapeType,attributeArray);

          }

        }

        public void characters(char ch[], int start, int length) throws SAXException {

          if (bId) {
            identifier = new String(ch, start, length);
            System.out.println("Unique identifier: " + identifier);
            bId = false;
          }

          if (bAttr) {
            attributes.add(new String(ch, start, length));
            bAttr = false;
          }

        }

      };

      saxParser.parse(new InputSource(new StringReader(xml)), handler);


    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}




