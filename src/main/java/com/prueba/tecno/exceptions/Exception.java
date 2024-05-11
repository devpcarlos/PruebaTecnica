package com.prueba.tecno.exceptions;

import org.springframework.http.HttpStatus;

public class Exception extends RuntimeException {


    private final HttpStatus status;


    public Exception(final HttpStatus status) { this.status = status; }

    public Exception(final HttpStatus status, final String message) {
        super(message);
        this.status = status;
    }


    public HttpStatus getStatus () {
        return this.status;
    }
}
