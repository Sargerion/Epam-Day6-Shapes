package edu.epam.task.validator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ToCreateQuadrangleValidatorTest {

    List<String> linesForValidation = Arrays.asList("1 2.4 -3.4 5 5.3 -7 8 5.4", "4 2.4 3.4 5 94aaaaaaa.3 7 8 1.4");
    static ToCreateQuadrangleValidator validator;

    @BeforeClass
    public static void initialize() {
        validator = new ToCreateQuadrangleValidator();
    }

    @Test
    public void validateTest() {
        List<String> actualValidationResult = validator.validate(linesForValidation);
        List<String> expectedValidationResult = Arrays.asList("1 2.4 -3.4 5 5.3 -7 8 5.4");
        assertEquals(actualValidationResult, expectedValidationResult);
    }

    @AfterClass
    public static void clear() {
        validator = null;
    }
}
