package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SearchinfoModel {

    @JsonProperty(value = "totalhits")
    private int totalhits;

    @JsonProperty(value = "suggestion")
    private ArrayList suggestion;

    @JsonProperty(value = "suggestionsnippet")
    private ArrayList suggestionsnippet;

    public int getTotalhits() {
        return totalhits;
    }

    public ArrayList getSuggestion() {
        return suggestion;
    }

    public ArrayList getSuggestionsnippet() {
        return suggestionsnippet;
    }

    public void setTotalhits(int totalhits) {
        this.totalhits = totalhits;
    }

    public void setSuggestion(ArrayList suggestion) {
        this.suggestion = suggestion;
    }

    public void setSuggestionsnippet(ArrayList suggestionsnippet) {
        this.suggestionsnippet = suggestionsnippet;
    }
}
