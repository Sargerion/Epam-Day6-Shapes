package edu.epam.task.action;

import edu.epam.task.entity.AbstractShape;

public interface ShapeService<C ,T extends AbstractShape> {

    double calculateArea(T shape);

    double calculatePerimeter(T shape);

    C identifyType(T shape);
}
