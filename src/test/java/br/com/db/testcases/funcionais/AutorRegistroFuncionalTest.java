package br.com.db.testcases.funcionais;

import br.com.db.bases.AutorBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

import static br.com.db.utils.JsonFile.*;
import static io.restassured.RestAssured.*;

public class AutorRegistroFuncionalTest extends AutorBaseTest {

    @Epic("Teste de Funcional")
    @Feature("Teste o cadastro um autor duplicado.")
    @Description("O metodo de cadastro de um autor duplicado deve retornar 400, com um arquivo JSON.")
    @Test
    public void registroDeUmAutorComSucesso400() throws IOException {
        given()
                    .spec(autorRegistroRequest)
                    .body(getFileContent("autor.json"))
                .when()
                    .post()
                .then().log().all()
                    .spec(responseSpecStatusBadRequest);
    }
}