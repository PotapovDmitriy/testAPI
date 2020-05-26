package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchModel {
    @JsonProperty(value = "ns")
    private int ns;
    @JsonProperty(value = "title")
    private String title;
    @JsonProperty(value = "pageid")
    private String pageid;
    @JsonProperty(value = "size")
    private String size;
    @JsonProperty(value = "wordcount")
    private int wordcount;
    @JsonProperty(value = "snippet")
    private String snippet;
    @JsonProperty(value = "timestamp")
    private String timestamp;


    public void setNs(int ns) {
        this.ns = ns;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWordcount(int wordcount) {
        this.wordcount = wordcount;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getNs() {
        return ns;
    }

    public String getTitle() {
        return title;
    }

    public String getPageid() {
        return pageid;
    }

    public String getSize() {
        return size;
    }

    public int getWordcount() {
        return wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
