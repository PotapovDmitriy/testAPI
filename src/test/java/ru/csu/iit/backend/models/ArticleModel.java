package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ArticleModel {

    @JsonProperty(value = "batchcomplete")
    private String batchcomplete;
    @JsonProperty(value = "query")
    private QueryModel query;

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public void setQuery(QueryModel query) {
        this.query = query;
    }

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public QueryModel getQuery() {
        return query;
    }
}
