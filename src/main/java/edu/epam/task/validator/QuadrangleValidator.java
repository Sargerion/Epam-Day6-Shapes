package edu.epam.task.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.epam.task.entity.Point2D;

import java.util.List;

public class QuadrangleValidator {

    private static final Logger logger = LogManager.getLogger();

    public boolean isQuadrangle(List<Point2D> points2D) {
        boolean flag = false;
        double side1 = Math.hypot((points2D.get(0).getX() - points2D.get(1).getX()), (points2D.get(0).getY() - points2D.get(1).getY()));
        double side2 = Math.hypot((points2D.get(1).getX() - points2D.get(2).getX()), (points2D.get(1).getY() - points2D.get(2).getY()));
        double side3 = Math.hypot((points2D.get(2).getX() - points2D.get(3).getX()), (points2D.get(2).getY() - points2D.get(3).getY()));
        double side4 = Math.hypot((points2D.get(3).getX() - points2D.get(0).getX()), (points2D.get(3).getY() - points2D.get(0).getY()));
        if (!((side1 >= side2 + side3 + side4) || (side2 >= side1 + side3 + side4) || (side3 >= side2 + side1 + side4) || (side4 >= side2 + side3 + side1))) {
            flag = true;
            logger.info("This points -> {} represent quadrangle", points2D);
        } else {
            logger.error("This points -> {} not represent quadrangle", points2D);
        }
        return flag;
    }
}