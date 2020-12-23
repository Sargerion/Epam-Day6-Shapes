package edu.epam.task.specification.impl;

import edu.epam.task.action.ShapeService;
import edu.epam.task.action.impl.QuadrangleServiceImpl;
import edu.epam.task.constant.QuadrangleType;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.specification.Specification;

public class AreaSpecification implements Specification<Quadrangle> {

    private double leftInterval;
    private double rightInterval;

    public AreaSpecification(double leftInterval, double rightInterval) {
        this.leftInterval = leftInterval;
        this.rightInterval = rightInterval;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        ShapeService<QuadrangleType, Quadrangle> service = new QuadrangleServiceImpl();
        double calculateArea = service.calculateArea(quadrangle);
        boolean result = Double.compare(calculateArea, leftInterval) >= 0 && Double.compare(calculateArea, rightInterval) <= 0;
        return result;
    }
}
