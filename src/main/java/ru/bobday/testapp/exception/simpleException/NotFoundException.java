package ru.bobday.testapp.exception.simpleException;

public class NotFoundException extends RequestException{

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

}
