package io.github.lsap.exception;

public class DaoLayerException extends RuntimeException {

    public DaoLayerException(String message) {
        super(message);
    }

    public DaoLayerException(Throwable cause) {
        super(cause);
    }

}

