package io.github.lsap.exception;

public class NoEntityWithSuchIdException extends RuntimeException {

    private static final long serialVersionUID = Long.MIN_VALUE;

    public NoEntityWithSuchIdException(String message) {
        super(message);
    }
}

