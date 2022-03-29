package main.exceptions;

public class UnexpectedTimeChangeException extends Exception {

    public UnexpectedTimeChangeException(String errorMessage) {
        super(errorMessage);
    }
}
