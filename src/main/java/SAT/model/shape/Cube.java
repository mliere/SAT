package SAT.model.shape;

public class Cube extends Shape {

    private double length;
    private double width;
    private double height;

    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // override toString, used for serializing class.
    @Override
    public String toString() {
      StringBuilder sb=new StringBuilder(); 
      sb.append("length:" + this.length + "\n");
      sb.append("width:" + this.width + "\n");
      sb.append("height:" + this.height);
      return sb.toString();
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }
}
