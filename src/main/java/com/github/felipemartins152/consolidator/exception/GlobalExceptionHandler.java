package com.github.felipemartins152.consolidator.exception;

import com.github.felipemartins152.consolidator.util.DateTimeUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, Object> buildBody(HttpStatusCode statusCode,
                                          String message, HttpServletRequest request){

        String errorPhrase = statusCode instanceof HttpStatus status
                ? status.getReasonPhrase()
                : "Error";

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", DateTimeUtils.now());
        body.put("status", statusCode.value());
        body.put("error", errorPhrase);
        body.put("message", message);
        body.put("path", request.getServletPath());
        return body;

    }

    private String extractError(MethodArgumentNotValidException ex){

        FieldError error = ex.getBindingResult().getFieldError();
        return error != null
                ? "Campo " + error.getField() + " " + error.getDefaultMessage()
                : "Erro de validação.";

    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex,
                                                                             HttpServletRequest request){

        HttpStatusCode statusCode = ex.getStatusCode();

        return new ResponseEntity<>(buildBody(statusCode, ex.getReason(), request), statusCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                                      HttpServletRequest request){

        HttpStatus status = BAD_REQUEST;
        String message = extractError(ex);

        return new ResponseEntity<>(buildBody(status, message, request), status);

    }

}