package org.example.entities.exceptions;

public class IllegalBetException extends Throwable {
    @Override
    public String getMessage() {
        return "incorrect bid";
    }
}
