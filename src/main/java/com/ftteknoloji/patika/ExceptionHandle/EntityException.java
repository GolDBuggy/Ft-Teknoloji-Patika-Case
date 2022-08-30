package com.ftteknoloji.patika.ExceptionHandle;

public class EntityException extends RuntimeException{
    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
