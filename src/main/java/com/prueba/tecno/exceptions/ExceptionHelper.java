package com.prueba.tecno.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionHelper {

    public static Exceptions unauthorized(String message) {
        return new Exceptions(HttpStatus.UNAUTHORIZED, message);
    }

    public static Exceptions forbidden(String message) {
        return new Exceptions(HttpStatus.FORBIDDEN, message);
    }

    public static Exceptions createByHttpStatus(final HttpStatus httpStatus, final String message) {
        return new Exceptions(httpStatus, message);
    }

    public static Exceptions dataIntegrityViolation(String message) {
        return new Exceptions(HttpStatus.CONFLICT, message);
    }

}
