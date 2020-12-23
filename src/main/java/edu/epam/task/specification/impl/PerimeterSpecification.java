package edu.epam.task.specification.impl;

import edu.epam.task.action.ShapeService;
import edu.epam.task.action.impl.QuadrangleServiceImpl;
import edu.epam.task.constant.QuadrangleType;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.specification.Specification;

public class PerimeterSpecification implements Specification<Quadrangle> {

    private double leftInterval;
    private double rightInterval;

    public PerimeterSpecification(double leftInterval, double rightInterval) {
        this.leftInterval = leftInterval;
        this.rightInterval = rightInterval;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        ShapeService<QuadrangleType, Quadrangle> service = new QuadrangleServiceImpl();
        double calculatePerimeter = service.calculatePerimeter(quadrangle);
        boolean result = Double.compare(calculatePerimeter, leftInterval) >= 0 && Double.compare(calculatePerimeter, rightInterval) <= 0;
        return result;
    }
}
