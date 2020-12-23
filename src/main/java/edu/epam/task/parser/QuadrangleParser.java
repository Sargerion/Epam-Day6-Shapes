package edu.epam.task.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.epam.task.entity.Point2D;
import edu.epam.task.exception.ParseException;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleParser {

    private static final Logger logger = LogManager.getLogger();
    public static final String FOR_SPLIT_REGEX = "\\s";

    public List<Point2D> parseValidPointsToCreate(String line) throws ParseException {
        List<Point2D> pointListToCreate = new ArrayList<>();
        String[] coordinates = line.split(FOR_SPLIT_REGEX);
        for (int i = 0; i < coordinates.length; i += 2) {
            pointListToCreate.add(new Point2D(Double.parseDouble(coordinates[i]), Double.parseDouble(coordinates[i + 1])));
        }
        return pointListToCreate;
    }
}
