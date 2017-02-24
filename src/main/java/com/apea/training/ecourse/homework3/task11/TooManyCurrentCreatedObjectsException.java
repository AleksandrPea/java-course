package com.apea.training.ecourse.homework3.task11;


public class TooManyCurrentCreatedObjectsException extends RuntimeException {

    public TooManyCurrentCreatedObjectsException(String message) {
        super(message);
    }

    public TooManyCurrentCreatedObjectsException(Throwable cause) {
        super(cause);
    }
}
