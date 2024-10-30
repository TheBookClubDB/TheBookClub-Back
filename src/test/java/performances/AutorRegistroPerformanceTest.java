package performances;

import br.com.db.bases.AutorBaseTest;
import br.com.db.stubs.AutorStub;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class AutorRegistroPerformanceTest extends AutorBaseTest {

    @Epic("Teste de Performance")
    @Feature("Teste de alto desempenho resposta com cadastro um autor.")
    @Description("O método de rapido resposta com cadastro autor deve retornar o status 201.")
    @Test
    public void rapidoRespostaCadastroUmNovoAutor201() {
        given()
                    .spec(autorRegistroRequest)
                    .body(AutorStub.getAutorStub())
                .when()
                    .post()
                .then()
                    .spec(responseSpecStatusCreated)
                    .time(lessThan(2000L));
    }
}