package br.com.db.bases;

import br.com.db.endpoints.AutorEndpointConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

public class AutorBaseTest extends AutorEndpointConfig {
    public static RequestSpecification autorRegistroRequest;
    public static ResponseSpecification responseSpecStatusCreated;
    public static ResponseSpecification responseSpecStatusBadRequest;

    @BeforeClass
    public void setUp() {
        autorRegistroRequestSpec();
        responseSpecStatusCreated();
        responseSpecStatusBadRequest();
    }

    private void autorRegistroRequestSpec() {
        autorRegistroRequest = new RequestSpecBuilder()
                .setBaseUri(baseUri())
                .setBasePath(basePathAutorRegistro())
                .setContentType(ContentType.JSON)
                .build();
    }

    private void responseSpecStatusCreated() {
        responseSpecStatusCreated = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }

    private void responseSpecStatusBadRequest() {
        responseSpecStatusBadRequest = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
                .build();
    }
}