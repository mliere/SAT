package SAT.model.shape;

public class Sphere implements IShape {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getVolume() {
        return (4 / 3) * Math.PI * (this.radius * this.radius);
    }
}
