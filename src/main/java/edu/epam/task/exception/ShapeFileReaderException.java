package edu.epam.task.exception;

public class ShapeFileReaderException extends Exception {

    public ShapeFileReaderException() {

    }

    public ShapeFileReaderException(String message) {
        super(message);
    }

    public ShapeFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeFileReaderException(Throwable cause) {
        super(cause);
    }
}
