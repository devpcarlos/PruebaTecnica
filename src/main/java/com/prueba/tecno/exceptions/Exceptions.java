package com.prueba.tecno.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final String timestamp;
    private final HttpStatus status;
    private final String error;
    private final String message;

    public CustomException(HttpStatus status, String message) {
        super(message);
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.status = status;
        this.error = status.getReasonPhrase();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
