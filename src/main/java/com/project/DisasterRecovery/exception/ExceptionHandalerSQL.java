package com.project.DisasterRecovery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandalerSQL extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> DuplicateException(DuplicateException ex, WebRequest request) {
        errorMessage errorDetails = new errorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(409).body(errorDetails);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(NotFoundException ex, WebRequest request) {
        errorMessage errorDetails = new errorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        errorMessage errorDetails = new errorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
