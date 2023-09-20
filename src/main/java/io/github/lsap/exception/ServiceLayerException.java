package io.github.lsap.exception;

public class ServiceLayerException extends RuntimeException {

    public ServiceLayerException(String message) {
        super(message);
    }

    public ServiceLayerException(Throwable cause) {
        super(cause);
    }

}

