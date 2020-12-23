package edu.epam.task.reader;

import edu.epam.task.exception.ShapeFileReaderException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ShapeFileReaderTest {

    public static final String TEST_FILE_PATH = "input_files/test_quadrangles_input.txt";
    List<String> expectedLines = Arrays.asList("1 2.4 -3.4 5 5.3 -7 8 5.4","4 2.4 3.4 5 94aaaaaaa.3 7 8 1.4");
    static ShapeFileReader shapeFileReader;

    @BeforeClass
    public static void initialize() {
        shapeFileReader = new ShapeFileReader();
    }

    @Test
    public void readTest() throws ShapeFileReaderException {
        List<String> actualLines = shapeFileReader.read(TEST_FILE_PATH);
        assertEquals(actualLines, expectedLines);
    }

    @AfterClass
    public static void cleat() {
        shapeFileReader = null;
    }
}
