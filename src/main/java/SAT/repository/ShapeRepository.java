package SAT.repository;

import SAT.model.shape.*;

public class ShapeRepository implements IShapeRepository {

  private Shape[] shapes;

  @Override
  public Shape getShape() {
    return new Cube(5,5,5);
  }

  @Override
  public boolean saveShape(Shape shape) {

    return false;
  }

  @Override
  public Shape[] getShapes() {
    return shapes;
  }
}
