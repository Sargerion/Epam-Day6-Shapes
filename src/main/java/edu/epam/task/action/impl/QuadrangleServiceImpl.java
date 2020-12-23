package edu.epam.task.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.epam.task.entity.Point2D;
import edu.epam.task.action.QuadrangleService;
import edu.epam.task.constant.QuadrangleType;
import edu.epam.task.entity.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleServiceImpl implements QuadrangleService {

    private static final Logger logger = LogManager.getLogger();
    public static final double EPSILON = 0.000001;

    //only for described qds
    @Override
    public double calculateArea(Quadrangle quadrangle) {
        List<Double> sides = getSides(quadrangle);
        double quadrangleHalfPerimeter = calculatePerimeter(quadrangle) / 2;
        double area = Math.sqrt((quadrangleHalfPerimeter - sides.get(0)) * (quadrangleHalfPerimeter - sides.get(1)) * (quadrangleHalfPerimeter - sides.get(2)) * (quadrangleHalfPerimeter - sides.get(3)));
        logger.info("Quadrangle -> {},\t area -> {}", quadrangle, area);
        return area;
    }

    @Override
    public double calculatePerimeter(Quadrangle quadrangle) {
        List<Double> sides = getSides(quadrangle);
        double perimeter = sides.stream().mapToDouble(Double::doubleValue).sum();
        logger.info("Quadrangle -> {},\t perimeter -> {}", quadrangle, perimeter);
        return perimeter;
    }

    @Override
    public QuadrangleType identifyType(Quadrangle quadrangle) {
        List<Double> sides = getSides(quadrangle);
        QuadrangleType type = QuadrangleType.NOT_DEFINED;
        if (Math.abs(sides.get(0) - sides.get(1) - sides.get(2) - sides.get(3)) <= EPSILON) {
            type = QuadrangleType.SQUARE;
            logger.info("Quadrangle -> {},\t type -> {}", quadrangle, type);
        }
        return type;
    }

    private List<Double> getSides(Quadrangle quadrangle) {
        List<Double> sides = new ArrayList<>();
        List<Point2D> points = quadrangle.getPoints();
        sides.add(Math.hypot((points.get(0).getX() - points.get(1).getX()), (points.get(0).getY() - points.get(1).getY())));
        sides.add(Math.hypot((points.get(1).getX() - points.get(2).getX()), (points.get(1).getY() - points.get(2).getY())));
        sides.add(Math.hypot((points.get(2).getX() - points.get(3).getX()), (points.get(2).getY() - points.get(3).getY())));
        sides.add(Math.hypot((points.get(3).getX() - points.get(0).getX()), (points.get(3).getY() - points.get(0).getY())));
        return sides;
    }
}