package com.service.earthquake.exception;

public class EarthquakeDateParseException extends RuntimeException {

    public EarthquakeDateParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public EarthquakeDateParseException(String message) {
        super(message);
    }

    public EarthquakeDateParseException(Throwable cause) {
        super(cause);
    }

}
