package com.prueba.tecno.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exceptions.class)
    public ResponseEntity<String> handleExceptions(Exceptions exceptions) {
        return ResponseEntity.status(exceptions.getStatus()).body(exceptions.getMessage());
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
      Exceptions exp= ExceptionHelper.dataIntegrityViolation("El Correo electronico ya existe.");
      return ResponseEntity.ok().body(exp.getMessage());
    }
}
