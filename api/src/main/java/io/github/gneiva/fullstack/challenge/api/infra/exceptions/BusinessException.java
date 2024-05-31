package io.github.gneiva.fullstack.challenge.api.infra.exceptions;

public class BusinessException extends  RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
