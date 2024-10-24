package br.com.db.testcases.funcionais;

import br.com.db.bases.AutorBaseTest;
import br.com.db.utils.JsonFileUtil;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class AutorRegistroTest extends AutorBaseTest {

    @Test
    public void registroDeUmAutorComSucesso201() throws IOException {

        given()
                    .spec(autorRegistroRequest)
                    .body(JsonFileUtil.getFileContent("autor.json"))
                .when()
                    .post()
                .then().log().all()
                    .spec(responseSpecStatusBadRequest);
    }
}