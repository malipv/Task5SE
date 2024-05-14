package ru.inno.task5se.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExemplarNotFoundException extends ResponseStatusException {
    public ExemplarNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}