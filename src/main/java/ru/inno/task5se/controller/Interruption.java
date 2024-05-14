package ru.inno.task5se.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interruption {
    private String message;
    private String debugMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public Interruption(String message, String debugMessage){
        this.message = message;
        this.debugMessage = debugMessage;
    }
}