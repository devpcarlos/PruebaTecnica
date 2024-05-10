package com.prueba.tecno.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionHelper {
    public ExceptionHelper() {
    }

    public static Exception notFound() {
        return new Exception(HttpStatus.NOT_FOUND, "Resource not found");
    }

    public static Exception notFound(final String message) {
        return new Exception(HttpStatus.NOT_FOUND, message);
    }

    public static Exception badRequest(final String message) {
        return new Exception(HttpStatus.BAD_REQUEST, message);
    }

    public static Exception unauthorized(final String message){
        return new Exception(HttpStatus.UNAUTHORIZED, message);
    }

    public static Exception forbidden(final String message) {
        return new Exception(HttpStatus.FORBIDDEN, message);
    }

    public static Exception internalServerError() {
        return new Exception(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static Exception internalServerError(final String message) {
        return new Exception(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
    public static Exception iAmATeapot(final String message) {
        return new Exception(HttpStatus.I_AM_A_TEAPOT, message);
    }

    public static Exception createByHttpStatus(final HttpStatus httpStatus, final String message) {
        return new Exception(httpStatus, message);
    }

    public static Exception createByStatusCode(final int statusCode, final String message) {
        switch (statusCode) {
            case 200:
                return new Exception(HttpStatus.OK, message);
            case 201:
                return new Exception(HttpStatus.CREATED, message);
            case 202:
                return new Exception(HttpStatus.ACCEPTED, message);
            case 204:
                return new Exception(HttpStatus.NO_CONTENT, message);
            case 301:
                return new Exception(HttpStatus.MOVED_PERMANENTLY, message);
            case 302:
                return new Exception(HttpStatus.FOUND, message);
            case 400:
                return new Exception(HttpStatus.BAD_REQUEST, message);
            case 401:
                return new Exception(HttpStatus.UNAUTHORIZED, message);
            case 402:
                return new Exception(HttpStatus.PAYMENT_REQUIRED, message);
            case 403:
                return new Exception(HttpStatus.FORBIDDEN, message);
            case 404:
                return new Exception(HttpStatus.NOT_FOUND, message);
            case 405:
                return new Exception(HttpStatus.METHOD_NOT_ALLOWED, message);
            case 418:
                return new Exception(HttpStatus.I_AM_A_TEAPOT, message);
            case 429:
                return new Exception(HttpStatus.TOO_MANY_REQUESTS, message);
            case 500:
                return new Exception(HttpStatus.INTERNAL_SERVER_ERROR, message);
            case 502:
                return new Exception(HttpStatus.BAD_GATEWAY, message);
            default:
                return new Exception(HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
    }
}
