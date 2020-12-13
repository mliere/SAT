package SAT.data;

import java.io.*;
import java.nio.file.*;

public class Disk{

  public static void toDisk(Object obj, String fileName) {

    try {
      // create file
      File file = new File(fileName);
      if (file.createNewFile()) {
        System.out.println("File created " + file.getName());
      } else {
        System.out.println("File already exists.");
      }

      // write content to file
      FileWriter fileWriter = new FileWriter(fileName);
      fileWriter.write(Xml.toXml(obj));
      fileWriter.close();
      System.out.println("Succesfully wrote to the file.");

    } catch (IOException e) {
      System.out.println("Error during file creation");
      e.printStackTrace();
    }
  }

  public static Object fromDisk(String fileName) {
    Object obj = new Object();
    try {
      obj = Xml.fromXml(Files.readString(Path.of(fileName)));
      System.out.println("Succesfully read file.");
    } catch (IOException e) {
      System.out.println("Unable to read file.");
      e.printStackTrace();
    }
    return obj;
  }

}
