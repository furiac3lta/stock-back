package com.marcedev.stock.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
