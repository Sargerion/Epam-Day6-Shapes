package edu.epam.task.observer.impl;

import edu.epam.task.action.ShapeService;
import edu.epam.task.action.impl.QuadrangleServiceImpl;
import edu.epam.task.constant.QuadrangleType;
import edu.epam.task.entity.Point2D;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.entity.QuadrangleData;
import edu.epam.task.exception.CreateShapeException;
import edu.epam.task.observer.Observer;
import edu.epam.task.storage.Repository;
import edu.epam.task.storage.Warehouse;
import edu.epam.task.storage.impl.QuadrangleRepository;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class QuadrangleObserverTest {

    static List<Quadrangle> quadrangles;
    static Repository<Quadrangle> quadrangleRepository;
    static Warehouse quadrangleWarehouse;
    static ShapeService<QuadrangleType, Quadrangle> shapeService;

    @BeforeClass
    public static void initialize() {
        quadrangles = Arrays.asList(
                new Quadrangle(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7), new Point2D(7, 3))),
                new Quadrangle(Arrays.asList(new Point2D(1, 2), new Point2D(3, 4), new Point2D(7, 7), new Point2D(7, 5))),
                new Quadrangle(Arrays.asList(new Point2D(3, 6), new Point2D(9, 1), new Point2D(4, 0), new Point2D(7, 5))),
                new Quadrangle(Arrays.asList(new Point2D(8, 2), new Point2D(3, 4), new Point2D(2, 2), new Point2D(0, 5)))
        );
        quadrangleRepository = QuadrangleRepository.getInstance();
        quadrangleRepository.addAll(quadrangles);
        quadrangleWarehouse = Warehouse.getInstance();
        shapeService = new QuadrangleServiceImpl();
        for (int i = 0; i < quadrangleRepository.getSize(); i++) {
            quadrangleWarehouse.put(quadrangleRepository.get(i).getQuadrangleId(), new QuadrangleData(shapeService.calculateArea(quadrangleRepository.get(i)), shapeService.calculatePerimeter(quadrangleRepository.get(i))));
        }
    }

    @Test
    public static void recalculateTest() throws CreateShapeException {
        Quadrangle quadrangle = quadrangleRepository.get(0);
        Map<String, QuadrangleData> quadrangleDataMap = quadrangleWarehouse.getQuadrangleData();
        quadrangle.setPointsToCreate(Arrays.asList(new Point2D(8, 8), new Point2D(8, 12), new Point2D(12, 12), new Point2D(12, 8)));
        Map<String, QuadrangleData> recalculateQuadrangleDataMap = quadrangleWarehouse.getQuadrangleData();
        assertNotEquals(quadrangleDataMap, recalculateQuadrangleDataMap);
    }

    @AfterClass
    public static void clear() {
        quadrangleRepository = null;
        quadrangleWarehouse = null;
        shapeService = null;
    }
}