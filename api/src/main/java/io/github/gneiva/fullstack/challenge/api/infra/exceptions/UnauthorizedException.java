package io.github.gneiva.fullstack.challenge.api.infra.exceptions;

public class UnauthorizedException extends  RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
