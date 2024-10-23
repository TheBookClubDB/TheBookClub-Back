package br.com.db.bases;

import br.com.db.reqres.AutorSpecConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class AutorRegistroBaseTest extends AutorSpecConfig {
    public static RequestSpecification baseUrl;

    @BeforeClass
    public void setUp() {
        baseUrl();
        autorRequest();
    }

    private void baseUrl() {
        baseUrl = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .build();
    }

    private void autorRequest() {
        autorRegistroRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathAutorRegistro())
                .setContentType(ContentType.JSON)
                .build();
    }
}