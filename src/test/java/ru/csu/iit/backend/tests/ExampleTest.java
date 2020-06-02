package ru.csu.iit.backend.tests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import ru.csu.iit.backend.models.ArticleModel;
import ru.csu.iit.backend.models.ErrorArticleModel;
import ru.csu.iit.backend.models.SearchModel;
import ru.csu.iit.backend.services.ArticlesService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ExampleTest extends BaseTest {
    @Test(groups = "test")
    public void dataProjectionQuery() {
        ArticlesService articlesService = new ArticlesService(properties);
        RequestSpecification requestSpecification = articlesService.requestBuilder()
                .action("query")
                .list("search")
                .srsearch("Craig Noone")
                .format("json")
                .build();
        ValidatableResponse response = articlesService.executePostDatasets(requestSpecification)
                .then()
                .assertThat()
                .body("query.search.snippet", everyItem(containsString("Noone")));

        response.assertThat().body("query.search.ns", everyItem(equalTo(0)));
    }

    @Test(groups = "testFalse")
    public void dataProjectionFalseQuery() {
        ArticlesService articlesService = new ArticlesService(properties);
        RequestSpecification requestSpecification = articlesService.requestBuilder()
                .action("query")
                .list("sea123rch")
                .format("json")
                .build();
        ErrorArticleModel errorsAnswers = articlesService.getErrorsAnswers(requestSpecification);
        assertThat(errorsAnswers.getWarnings().getQuery().getMessage(), containsString("sea123rch"));
    }


    @Test(groups = "models")
    public void getDatasetId() {
        ArticlesService articlesService = new ArticlesService(properties);
        RequestSpecification requestSpecification = articlesService.requestBuilder()
                .action("query")
                .list("search")
                .srsearch("Craig Noone")
                .format("json")
                .build();
        ArticleModel articles = articlesService.getArticle(requestSpecification);

        for (SearchModel search : articles.getQuery().getSearch()) {
            assertThat(search.getSnippet(), containsString("Noone"));
        }
    }
}
