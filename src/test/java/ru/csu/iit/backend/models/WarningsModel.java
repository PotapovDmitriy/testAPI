package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WarningsModel {

    @JsonProperty(value = "query")
    private ErrorQueryModel query;
    @JsonProperty(value = "main")
    private ErrorMainModel main;

    public void setQuery(ErrorQueryModel query) {
        this.query = query;
    }

    public void setMain(ErrorMainModel main) {
        this.main = main;
    }

    public ErrorQueryModel getQuery() {
        return query;
    }

    public ErrorMainModel getMain() {
        return main;
    }
}
