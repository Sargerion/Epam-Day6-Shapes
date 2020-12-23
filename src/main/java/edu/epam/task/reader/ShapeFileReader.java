package edu.epam.task.reader;

import edu.epam.task.exception.ShapeFileReaderException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShapeFileReader {

    private static final Logger logger = LogManager.getLogger();

    public List<String> read(String inputFilePath) throws ShapeFileReaderException {
        List<String> lines = new ArrayList<>();
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new ShapeFileReaderException("InputFile didn't exists");
        }
        if (inputFile.length() == 0) {
            throw new ShapeFileReaderException("Your file is empty");
        }
        try (Stream<String> stream = Files.lines(Path.of(inputFilePath))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ShapeFileReaderException("Errors in reading -> " + e.getMessage());
        }
        logger.info("The file -> {} was read,\tResult -> {}", inputFilePath, lines);
        return lines;
    }
}
