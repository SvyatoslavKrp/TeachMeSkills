package org.example.entities.exceptions;

public class NoSuchPairException extends Throwable {
    @Override
    public String getMessage() {
        return "no such pair";
    }
}
