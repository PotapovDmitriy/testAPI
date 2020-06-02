package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorArticleModel {

    @JsonProperty(value = "batchcomplete")
    private String batchcomplete;
    @JsonProperty(value = "warnings")
    private WarningsModel warnings;

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public void setWarnings(WarningsModel warnings) {
        this.warnings = warnings;
    }

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public WarningsModel getWarnings() {
        return warnings;
    }
}
