package edu.epam.task.entity;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Point2DTest {

    @Test
    public void checkEqualPoints() {
        Point2D point1 = new Point2D(1,2);
        Point2D point2 = new Point2D(1,2);
        assertEquals(point1, point2);
    }

    @Test
    public void checkNotEqualPoints() {
        Point2D point1 = new Point2D(1,2);
        Point2D point2 = new Point2D(2,1);
        assertNotEquals(point1, point2);
    }

}
