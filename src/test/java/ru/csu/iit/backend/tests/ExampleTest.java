package ru.csu.iit.backend.tests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.DatasetModel;
import ru.csu.iit.backend.models.ErrorDatasetModel;
import ru.csu.iit.backend.models.SearchModel;
import ru.csu.iit.backend.services.DatasetsService;

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
        checkDataProjectionFalseQuery(datasetsService, "sea123rch");

    }


    @Test(groups = "models")
    public void getDatasetId() {
        DatasetsService datasetsService = new DatasetsService(properties);
        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .action("query")
                .list("search")
                .srsearch("Craig Noone")
                .format("json")
                .build();
        DatasetModel dataset = datasetsService.getDataset(requestSpecification);


        for (SearchModel search : dataset.getQuery().getSearch()) {
            assertThat(search.getSnippet(), containsString("Noone"));
        }

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

    private void checkDataProjectionFalseQuery(DatasetsService datasetsService, String listParam) {
        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .action("query")
                .list(listParam)
                .format("json")
                .build();
        ErrorDatasetModel erDataset = datasetsService.getErrorsDataset(requestSpecification);
        assertThat(erDataset.getWarnings().getQuery().getMessage(), containsString(listParam));
    }
}
