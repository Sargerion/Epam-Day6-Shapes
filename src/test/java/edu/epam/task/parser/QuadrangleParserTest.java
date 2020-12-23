package edu.epam.task.parser;

import edu.epam.task.entity.Point2D;
import edu.epam.task.exception.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleParserTest {

    List<String> validLinesToParse = Arrays.asList(
            "1 2.4 -3.4 5 5.3 -7 8 5.4",
            "4 2.4 3.4 5 94.3 7 8 1.4",
            "8 6.4 -5.4 3 2.3 -1 8 5.4",
            "1 2.4 -54.4 5 1.2 -1 8 5.4");
    static QuadrangleParser parser;

    @BeforeClass
    public static void initialize() {
        parser = new QuadrangleParser();
    }

    @Test
    public void parseTest() throws ParseException {
        List<List<Point2D>> actualParseResult = new ArrayList<>();
        for (String line : validLinesToParse) {
            List<Point2D> quadrangle = parser.parseValidPointsToCreate(line);
            actualParseResult.add(quadrangle);
        }
        List<List<Point2D>> expectedParseResult = Arrays.asList(
                Arrays.asList(new Point2D(1, 2.4), new Point2D(-3.4, 5), new Point2D(5.3, -7), new Point2D(8, 5.4)),
                Arrays.asList(new Point2D(4, 2.4), new Point2D(3.4, 5), new Point2D(94.3, 7), new Point2D(8, 1.4)),
                Arrays.asList(new Point2D(8, 6.4), new Point2D(-5.4, 3), new Point2D(2.3, -1), new Point2D(8, 5.4)),
                Arrays.asList(new Point2D(1, 2.4), new Point2D(-54.4, 5), new Point2D(1.2, -1), new Point2D(8, 5.4))
        );
        assertEquals(actualParseResult, expectedParseResult);
    }

    @AfterClass
    public static void clear() {
        parser = null;
    }
}
