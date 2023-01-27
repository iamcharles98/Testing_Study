package Exceptions;

public class InvalidInputException extends RuntimeException {
    String exception;
    public InvalidInputException(String exception) {
        this.exception = exception;
    }
}
