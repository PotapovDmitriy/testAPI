package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.DatasetRequestBuilder;
import ru.csu.iit.backend.models.DatasetModel;

import java.util.Properties;

public class DatasetsService extends BaseService {
    private static final String ENDPOINT = "datasets";

    public DatasetsService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public DatasetModel getDatasets(RequestSpecification requestSpecification) {

        return executePostDatasets(requestSpecification).then()
                .extract()
                .body().as(DatasetModel.class);
    }

    public Response executePostDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.post(ENDPOINT);
    }
}
