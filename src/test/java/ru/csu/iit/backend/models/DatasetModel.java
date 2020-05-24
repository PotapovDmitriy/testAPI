package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DatasetModel {
    @JsonProperty(value = "batchcomplete")
    private int batchcomplete;
    @JsonProperty(value = "query")
    private String query;

    public void setBatchcomplete(int batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getBatchcomplete() {
        return batchcomplete;
    }

    public String getQuery() {
        return query;
    }
//    @JsonProperty(value = "ns")
//    private int ns;
//    @JsonProperty(value = "title")
//    private ArrayList title;
//    @JsonProperty(value = "pageid")
//    private String pageid;
//    @JsonProperty(value = "wordcount")
//    private String wordcount;
//    @JsonProperty(value = "snippet")
//    private String snippet;
//
//
//    public void setNs(int ns) {
//        this.ns = ns;
//    }
//
//    public void setTitle(ArrayList title) {
//        this.title = title;
//    }
//
//    public void setPageid(String pageid) {
//        this.pageid = pageid;
//    }
//
//    public void setWordcount(String wordcount) {
//        this.wordcount = wordcount;
//    }
//
//    public void setSnippet(String snippet) {
//        this.snippet = snippet;
//    }
//
//    public int getNs() {
//        return ns;
//    }
//
//    public ArrayList getTitle() {
//        return title;
//    }
//
//    public String getPageid() {
//        return pageid;
//    }
//
//    public String getWordcount() {
//        return wordcount;
//    }
//
//    public String getSnippet() {
//        return snippet;
//    }
//
//    @Override
//    public String toString() {
//        return "DatasetModel{" +
//                "ns=" + ns +
//                ", title='" + title + '\'' +
//                ", pageid='" + pageid + '\'' +
//                ", snippet='" + snippet + '\'' +
//                '}';
//    }
}
