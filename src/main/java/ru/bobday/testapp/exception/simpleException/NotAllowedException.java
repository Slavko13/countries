package ru.bobday.testapp.exception.simpleException;

public class NotAllowedException extends RequestException {

    public NotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowedException(String message) {
        super(message);
    }

}
