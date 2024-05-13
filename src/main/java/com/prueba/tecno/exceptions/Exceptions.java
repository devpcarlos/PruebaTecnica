package com.prueba.tecno.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Exceptions extends RuntimeException {

    private HttpStatus status;
    private String messages;

    public Exceptions(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.messages = message;
    }


    @Override
    public String getMessage() {
        return messages; // Devuelve el mensaje personalizado
    }
}

