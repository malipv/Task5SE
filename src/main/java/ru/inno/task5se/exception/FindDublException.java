package ru.inno.task5se.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FindDublException extends ResponseStatusException {
    public FindDublException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}