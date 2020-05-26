package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMainModel {
    @JsonProperty(value = "*")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
