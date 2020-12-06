package SAT.repository;

import SAT.model.shape.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShapeRepository implements IShapeRepository {

  private ArrayList<Shape> shapes;

  @Override
  public Shape getShape(UUID id) {
    return new Cube(5,5,5);
  }

  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  @Override
  public boolean saveShape(Shape shape) {

    return false;
  }

  @Override
  public List<Shape> getShapes() {
    return shapes;
  }
}
