package edu.epam.task.observer;

import edu.epam.task.entity.AbstractShape;

public interface Observer<T extends AbstractShape> {

    void recalculatePerimeter(T shape);

    void recalculateArea(T shape);

}
