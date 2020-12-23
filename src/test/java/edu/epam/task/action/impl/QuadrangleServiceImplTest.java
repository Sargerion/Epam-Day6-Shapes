package edu.epam.task.action.impl;

import edu.epam.task.action.ShapeService;
import edu.epam.task.constant.QuadrangleType;
import edu.epam.task.entity.Point2D;
import edu.epam.task.entity.Quadrangle;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;


public class QuadrangleServiceImplTest {

    static ShapeService<QuadrangleType, Quadrangle> service;
    Quadrangle quadrangle = new Quadrangle(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7), new Point2D(7, 3)));

    @BeforeClass
    public static void initialize() {
        service = new QuadrangleServiceImpl();
    }

    @Test
    public void calculatePerimeterTest() {
        double actualPerimeterResult = service.calculatePerimeter(quadrangle);
        double expectedPerimeterResult = 16;
        assertEquals(actualPerimeterResult, expectedPerimeterResult);
    }

    @Test
    public void calculateAreaTest() {
        double actualAreaResult = service.calculateArea(quadrangle);
        double expectedAreaResult = 16;
        assertEquals(actualAreaResult, expectedAreaResult);
    }

    public void typeIdentifyTest() {
        QuadrangleType actualTypeResult = service.identifyType(quadrangle);
        QuadrangleType expectedTypeResult = QuadrangleType.SQUARE;
        assertEquals(actualTypeResult, expectedTypeResult);
    }

    @AfterClass
    public static void clear() {
        service = null;
    }
}
