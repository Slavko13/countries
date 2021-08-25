package ru.bobday.testapp.exception.simpleException;

public class TeapotException extends RequestException{

    public TeapotException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeapotException (String message) {
        super(message);
    }

}
