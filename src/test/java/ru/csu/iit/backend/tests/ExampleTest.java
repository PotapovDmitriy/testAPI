package ru.csu.iit.backend.tests;

import com.fasterxml.jackson.databind.node.ArrayNode;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.DatasetModel;
import ru.csu.iit.backend.services.DatasetsService;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ExampleTest extends BaseTest {
    @Test(groups = "test")
    public void dataProjectionQuery() {
        DatasetsService datasetsService = new DatasetsService(properties);
        checkDataProjectionQuery(datasetsService, "ns", "snippet");
        checkDataProjectionQuery(datasetsService, "ns", "snippet", "title", "wordcount");

    }

    @Test(groups = "testFalse")
    public void dataProjectionFalseQuery() {
        DatasetsService datasetsService = new DatasetsService(properties);
        checkDataProjectionFalseQuery(datasetsService);

    }

    private void checkDataProjectionQuery(DatasetsService datasetsService, String... fields) {
        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .action("query")
                .list("search")
                .srsearch("Craig Noone")
                .format("json")
                .getFields(fields)
                .build();
        ValidatableResponse response = datasetsService.executePostDatasets(requestSpecification)
                .then()
                .assertThat()
                .body("query.search.snippet", everyItem(containsString("Noone")));

        response.assertThat().body("query.search.ns", everyItem(equalTo(0)));


    }

    private void checkDataProjectionFalseQuery(DatasetsService datasetsService, String... fields) {
        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .action("query")
                .list("sea123rch")
                .format("json")
                .getFields(fields)
                .build();
        ValidatableResponse response = datasetsService.executePostDatasets(requestSpecification)
                .then()
                .assertThat()
                .body("warnings.query.*" , containsString("sea123rch"));


    }

    @Test(groups = "models")
    public void getDatasetId() {
        DatasetsService datasetsService = new DatasetsService(properties);
        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .action("query")
                .list("search")
                .srsearch("Craig Noone")
                .format("json")
//                .getFields("batchcomplete", "query")
                .build();
        DatasetModel dataset = datasetsService.getDatasets(requestSpecification);

//        for (DatasetModel dataset : datasets) {
//            assertThat(dataset.getCaption(), containsString("имена"));
//        }
    }

}
