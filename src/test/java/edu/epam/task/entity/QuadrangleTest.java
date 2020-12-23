package edu.epam.task.entity;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class QuadrangleTest {

    Quadrangle quadrangle = new Quadrangle(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7), new Point2D(7, 3)));

    @Test
    public void checkEqualQuadrangles() {
        Quadrangle quadrangleCopy = new Quadrangle(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7), new Point2D(7, 3)));
        assertEquals(quadrangle, quadrangleCopy);
    }

    @Test
    public void checkNotEqualQuadrangles() {
        Quadrangle quadrangle1 = new Quadrangle(Arrays.asList(new Point2D(1, 2), new Point2D(3, 4), new Point2D(7, 7), new Point2D(7, 5)));
        assertNotEquals(quadrangle, quadrangle1);
    }
}
