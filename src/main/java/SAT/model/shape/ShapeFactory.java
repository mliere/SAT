package SAT.model.shape;

public class ShapeFactory {

  public static Shape getShape(String shapeType,String[] attr) {
    if(shapeType.equalsIgnoreCase("Cube")){
      return new Cube(Double.parseDouble(attr[0])
          ,Double.parseDouble(attr[1])
          ,Double.parseDouble(attr[2]));
    }

    if(shapeType.equalsIgnoreCase("Cylinder")){
      return new Cylinder(Double.parseDouble(attr[0])
          ,Double.parseDouble(attr[1]));
    }

    if(shapeType.equalsIgnoreCase("Sphere")){
      return new Sphere(Double.parseDouble(attr[0]));
    }

    //default in case a empty/nonmatching String gets send in.
    return null;  
  }

}
