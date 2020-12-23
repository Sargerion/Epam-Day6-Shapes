package edu.epam.task.factory;

import edu.epam.task.entity.AbstractShape;
import edu.epam.task.entity.Point2D;
import edu.epam.task.exception.CreateShapeException;

import java.util.List;

public interface AbstractShapeFactory<T extends AbstractShape> {

    T createShape(List<Point2D> points) throws CreateShapeException;

}
