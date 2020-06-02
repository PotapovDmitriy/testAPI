package ru.csu.iit.backend.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.csu.iit.backend.builders.DatasetRequestBuilder;
import ru.csu.iit.backend.models.ArticleModel;
import ru.csu.iit.backend.models.ErrorArticleModel;

import java.util.Properties;

public class ArticlesService extends BaseService {
    private static final String ENDPOINT = "article";

    public ArticlesService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public ArticleModel getArticle(RequestSpecification requestSpecification) {

        return executePostDatasets(requestSpecification).then()
                .extract()
                .body().as(ArticleModel.class);
    }

    public ErrorArticleModel getErrorsAnswers(RequestSpecification requestSpecification) {

        return executePostDatasets(requestSpecification).then()
                .extract()
                .body().as(ErrorArticleModel.class);
    }

    public Response executePostDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.post(ENDPOINT);
    }
}
