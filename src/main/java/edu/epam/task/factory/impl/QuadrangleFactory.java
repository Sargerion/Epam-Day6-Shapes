package edu.epam.task.factory.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.epam.task.exception.CreateShapeException;
import edu.epam.task.validator.QuadrangleValidator;
import edu.epam.task.entity.Point2D;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.factory.AbstractShapeFactory;

import java.util.List;

public class QuadrangleFactory implements AbstractShapeFactory<Quadrangle> {

    private static final Logger logger = LogManager.getLogger();
    private static QuadrangleFactory factory;

    private QuadrangleFactory() {

    }

    public static QuadrangleFactory getInstance() {
        if (factory == null) {
            factory = new QuadrangleFactory();
            logger.info("Factory created");
        }
        return factory;
    }

    @Override
    public Quadrangle createShape(List<Point2D> points) throws CreateShapeException {
        QuadrangleValidator validator = new QuadrangleValidator();
        if (!validator.isQuadrangle(points)) {
            throw new CreateShapeException("This points are not represent a quadrangle -> " + points);
        }
        Quadrangle quadrangle = new Quadrangle(points);
        logger.info("Quadrangle -> {} was create", quadrangle);
        return quadrangle;
    }
}
