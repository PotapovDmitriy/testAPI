package ru.csu.iit.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class QueryModel {
    @JsonProperty(value = "searchinfo")
    private SearchinfoModel searchinfo;

    @JsonProperty(value = "search")
    private SearchModel[] search;


    public SearchinfoModel getSearchinfo() {
        return searchinfo;
    }

    public SearchModel[] getSearch() {
        return search;
    }

    public void setSearchinfo(SearchinfoModel searchinfo) {
        this.searchinfo = searchinfo;
    }

    public void setSearch(SearchModel[] search) {
        this.search = search;
    }
}
