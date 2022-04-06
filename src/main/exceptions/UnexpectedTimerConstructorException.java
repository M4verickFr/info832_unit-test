package main.exceptions;

public class UnexpectedTimerConstructorException extends Exception {

    public UnexpectedTimerConstructorException(String errorMessage) {
        super(errorMessage);
    }

}
