package SAT.model.shape;

import java.util.UUID;

public class Cylinder extends Shape {

  private UUID id;
  private double radius;
  private double height;

  public Cylinder(double radius, double height) {
    this.id = UUID.randomUUID();
    this.radius = radius;
    this.height = height;
  }

  // override toString, used for serializing class.
  @Override
  public String toString() {
    StringBuilder sb=new StringBuilder();
    sb.append("id:" + this.id + "\n");
    sb.append("radius:" + this.radius + "\n");
    sb.append("height:" + this.height);
    return sb.toString();
  }


  public double getRadius() {
    return radius;
  }

  public double getHeight() {
    return height;
  }

  public double getVolume() {
    return  Math.PI * (this.radius * this.radius) * this.height;
  }
}
