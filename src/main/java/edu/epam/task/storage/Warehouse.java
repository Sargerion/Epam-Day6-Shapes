package edu.epam.task.storage;

import edu.epam.task.entity.QuadrangleData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static final Logger logger = LogManager.getLogger();
    private static Warehouse warehouse;
    private Map<String, QuadrangleData> quadrangleData;

    private Warehouse() {
        quadrangleData = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (warehouse == null) {
            warehouse = new Warehouse();
            logger.info("Warehouse created");
        }
        return warehouse;
    }

    public Map<String, QuadrangleData> getQuadrangleData() {
        logger.info("Get copy of warehouse -> {}", quadrangleData);
        return new HashMap<>(quadrangleData);
    }

    public boolean contains(String quadrangleId) {
        return quadrangleData.containsKey(quadrangleId);
    }

    public QuadrangleData getInfoAboutQuadrangle(String quadrangleId) {
        QuadrangleData result = new QuadrangleData(quadrangleData.get(quadrangleId).getArea(), quadrangleData.get(quadrangleId).getPerimeter());
        logger.info("Info about quadrangle with id->{}, {}", quadrangleId, result);
        return result;
    }

    public void put(String quadrangleId, QuadrangleData data) {
        quadrangleData.put(quadrangleId, data);
        logger.info("Quadrangle's data with id->{} was put to warehouse successfully -> {}", quadrangleId, data);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{\n");
        sb.append("Quadrangle data ->\t").append(quadrangleData);
        sb.append("\n}");
        return sb.toString();
    }
}
