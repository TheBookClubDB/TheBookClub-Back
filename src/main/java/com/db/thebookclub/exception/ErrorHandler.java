package com.db.thebookclub.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ErrorHandler {
    
    @ExceptionHandler(AutorJaCadastradoException.class)
    public ResponseEntity<String> handleErrorAutorJaCadastradoException(AutorJaCadastradoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
