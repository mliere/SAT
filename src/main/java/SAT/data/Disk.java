package SAT.data;

import java.io.*;

public class Disk{

  public static void toDisk(Object obj, String filename) {

    try {
      // create file
      File file = new File(filename);
      if (file.createNewFile()) {
        System.out.println("File created " + file.getName());
      } else {
        System.out.println("File already exists.");
      }

      // write content to file
      FileWriter fileWriter = new FileWriter(filename);
      fileWriter.write(Xml.toXml(obj));
      fileWriter.close();
      System.out.println("Succesfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("Error during file creation");
      e.printStackTrace();
    }

  }

}
