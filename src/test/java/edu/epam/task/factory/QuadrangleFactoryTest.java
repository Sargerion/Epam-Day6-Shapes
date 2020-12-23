package edu.epam.task.factory;

import edu.epam.task.entity.Point2D;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.exception.CreateShapeException;
import edu.epam.task.factory.impl.QuadrangleFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.Arrays;

public class QuadrangleFactoryTest {

    static AbstractShapeFactory<Quadrangle> shapeFactory;


    @BeforeClass
    public static void initialize() {
        shapeFactory = QuadrangleFactory.getInstance();
    }

    @Test
    public void createQuadrangleTest() throws CreateShapeException {
        Quadrangle quadrangleUsualCase = new Quadrangle(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7), new Point2D(7, 3)));
        Quadrangle quadrangleFromFactory = shapeFactory.createShape(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7), new Point2D(7, 3)));
        assertEquals(quadrangleFromFactory, quadrangleUsualCase);
    }

    @AfterClass
    public static void clear() {
        shapeFactory = null;
    }
}
