package SAT.repository;

import SAT.model.shape.*;

interface IShapeRepository {

    public Shape getShape();
    public void saveShape(Shape shape);
    public Shape[] getShapes();
}
