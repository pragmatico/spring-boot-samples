package com.example.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    protected static final Logger LOGGER = LogManager.getLogger();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.warn(ex.getMessage(), ex);

        return new ResponseEntity<Object>(proccessErrorsList(ex.getBindingResult()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private List<String> proccessErrorsList(BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return bindingResult.getFieldErrors().stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.toList());
        } else {
            return bindingResult.getGlobalErrors().stream()
                    .map(e -> e.getDefaultMessage())
                    .collect(Collectors.toList());
        }
    }
}
