package edu.epam.task.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.epam.task.entity.QuadrangleData;
import edu.epam.task.action.ShapeService;
import edu.epam.task.action.impl.QuadrangleServiceImpl;
import edu.epam.task.constant.QuadrangleType;
import edu.epam.task.entity.Quadrangle;
import edu.epam.task.observer.Observer;
import edu.epam.task.storage.Warehouse;

public class QuadrangleObserver implements Observer<Quadrangle> {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void recalculatePerimeter(Quadrangle quadrangle) {
        String quadrangleId = quadrangle.getQuadrangleId();
        Warehouse warehouse = Warehouse.getInstance();
        ShapeService<QuadrangleType, Quadrangle> shapeService = new QuadrangleServiceImpl();
        double recalculatePerimeter = shapeService.calculatePerimeter(quadrangle);
        QuadrangleData quadrangleData = warehouse.getInfoAboutQuadrangle(quadrangleId);
        quadrangleData.setPerimeter(recalculatePerimeter);
        warehouse.put(quadrangleId, quadrangleData);
        logger.info("Perimeter updated,\t-> new perimeter {}", recalculatePerimeter);
    }

    @Override
    public void recalculateArea(Quadrangle quadrangle) {
        String quadrangleId = quadrangle.getQuadrangleId();
        Warehouse warehouse = Warehouse.getInstance();
        ShapeService<QuadrangleType, Quadrangle> shapeService = new QuadrangleServiceImpl();
        double recalculateArea = shapeService.calculateArea(quadrangle);
        QuadrangleData quadrangleData = warehouse.getInfoAboutQuadrangle(quadrangleId);
        quadrangleData.setArea(recalculateArea);
        warehouse.put(quadrangleId, quadrangleData);
        logger.info("Area updated,\t-> new area {}", recalculateArea);
    }
}
