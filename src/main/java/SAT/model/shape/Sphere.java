package SAT.model.shape;

import java.util.UUID;

public class Sphere extends Shape {

  private UUID id;
  private double radius;

  public Sphere(double radius) {
    this.id = UUID.randomUUID();
    this.radius = radius;
  }

  public Sphere(String id, double radius) {
    this.id = UUID.fromString(id);
    this.radius = radius;
  }

  // override toString, used for serializing class.
  @Override
  public String toString() {
    StringBuilder sb=new StringBuilder();
    sb.append("id:" + this.id + "\n");
    sb.append("radius:" + this.radius);
    return sb.toString();
  }


  public double getRadius() {
    return radius;
  }

  public double getVolume() {
    return (4 / 3) * Math.PI * (this.radius * this.radius);
  }
}
