package br.com.db.testcases.contratos;

import br.com.db.bases.AutorBaseTest;
import br.com.db.stubs.AutorStub;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AutorRegistroContratoTest extends AutorBaseTest {

    @Epic("Teste de Contrato")
    @Feature("Teste o cadastro um autor.")
    @Description("O metodo de cadastro um novo autor deve retornar 201.")
    @Test
    public void registroDeUmAutorComSucesso201() {
        given()
                    .spec(autorRegistroRequest)
                    .body(AutorStub.getAutorStub())
                .when()
                    .post()
                .then()
                    .spec(responseSpecStatusCreated);
    }
}