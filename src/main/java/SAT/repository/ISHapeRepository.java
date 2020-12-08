package SAT.repository;

import SAT.model.shape.*;

import java.util.List;
import java.util.UUID;

interface IShapeRepository {

    public Shape getShape(UUID id);
    public boolean saveShape(Shape shape);
    public List<Shape> getShapes();
}
