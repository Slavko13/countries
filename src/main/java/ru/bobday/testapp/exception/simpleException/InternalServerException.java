package ru.bobday.testapp.exception.simpleException;

public class InternalServerException extends RequestException {

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(String message) {
        super(message);
    }

}
