package io.github.lsap.exception;

public class DaoLayerException extends RuntimeException {

    private static final long serialVersionUID = Long.MIN_VALUE + 1;

    public DaoLayerException(String message) {
        super(message);
    }

    public DaoLayerException(Throwable cause) {
        super(cause);
    }

}

