package com.n11.graduationproject.exception;

import com.n11.graduationproject.exception.customer.CustomerAlreadyExistException;
import com.n11.graduationproject.exception.customer.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handler(CustomerNotFoundException exception) {
        ExceptionResponse errorResponse = errorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handler(CustomerAlreadyExistException exception) {
        ExceptionResponse errorResponse = errorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleException(HttpMessageNotReadableException exception) {
        return new ResponseEntity("Incorrect value!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<List<ValidationErrorResponse>> handleException(MethodArgumentNotValidException e) {
        List<ValidationErrorResponse> response = new ArrayList<>();
        for (FieldError err : e.getFieldErrors()) {
            response.add(new ValidationErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    err.getField(),
                    err.getDefaultMessage(),
                    LocalDateTime.now()));
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private ExceptionResponse errorResponse(HttpStatus httpStatus, String message) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(message);
        response.setStatus(httpStatus.value());
        response.setErrorDate(LocalDateTime.now());
        return response;
    }

}

