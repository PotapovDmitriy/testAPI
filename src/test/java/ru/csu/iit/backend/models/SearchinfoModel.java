package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SearchinfoModel {

    @JsonProperty(value = "totalhits")
    private int totalhits;

    @JsonProperty(value = "suggestion")
    private String suggestion;

    @JsonProperty(value = "suggestionsnippet")
    private String suggestionsnippet;

    public int getTotalhits() {
        return totalhits;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public String getSuggestionsnippet() {
        return suggestionsnippet;
    }

    public void setTotalhits(int totalhits) {
        this.totalhits = totalhits;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public void setSuggestionsnippet(String suggestionsnippet) {
        this.suggestionsnippet = suggestionsnippet;
    }
}
