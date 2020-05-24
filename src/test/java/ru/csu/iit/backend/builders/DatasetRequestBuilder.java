package ru.csu.iit.backend.builders;

import io.restassured.specification.RequestSpecification;

public class DatasetRequestBuilder {
    private RequestSpecification requestSpecification;

    public DatasetRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public DatasetRequestBuilder action(String action) {
        requestSpecification.queryParams("action", action);
        return this;
    }
    public DatasetRequestBuilder list(String search) {
        requestSpecification.queryParams("list", search);
        return this;
    }

    public DatasetRequestBuilder srsearch(String srsearch) {
        requestSpecification.queryParams("srsearch", srsearch);
        return this;
    }

//    public DatasetRequestBuilder contains(String attributeName, String attributeValueSubstring) {
//        return filter(String.format("substringof('%s', %s) eq true", attributeValueSubstring, attributeName));
//    }

    public DatasetRequestBuilder format(String format) {
        requestSpecification.queryParam("format", format);
        return this;
    }

    public DatasetRequestBuilder getFields(String... fields) {
        requestSpecification.body(fields);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }
}
