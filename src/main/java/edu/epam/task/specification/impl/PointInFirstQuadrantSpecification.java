package edu.epam.task.specification.impl;

import edu.epam.task.entity.Point2D;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.specification.Specification;

import java.util.List;

public class PointInFirstQuadrantSpecification implements Specification<Quadrangle> {

    @Override
    public boolean specify(Quadrangle quadrangle) {
        List<Point2D> points = quadrangle.getPoints();
        boolean result = (points.get(0).getX() > 0 && points.get(0).getY() > 0) && (points.get(1).getX() > 0 && points.get(1).getY() > 0)
                && (points.get(2).getX() > 0 && points.get(2).getY() > 0) && (points.get(3).getX() > 0 && points.get(3).getY() > 0);
        return result;
    }
}
