package io.github.lsap.exception;

public class ServiceLayerException extends RuntimeException {

    private static final long serialVersionUID = Long.MIN_VALUE + 2;
    
    public ServiceLayerException(String message) {
        super(message);
    }

    public ServiceLayerException(Throwable cause) {
        super(cause);
    }

}

