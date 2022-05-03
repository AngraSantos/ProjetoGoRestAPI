package go_rest_api_refatorado.tests;

import go_rest_api_refatorado.UserBaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRefatoradoTest extends UserBaseTest {

    private static Integer USER_ID;

    @Test
    public void t01_deveIncluirUser() {

    String APP_MASSA_POST = DadosPost.MASSA_POST;

    USER_ID =  given().
               body(APP_MASSA_POST).
               log().all().
        when().
               post(APP_BASE_URL).
        then().
               statusCode(201).
               log().all().
               extract().path("id");
    }

    @Test
    public void t02_deveConsultarUser() {

        given().
                pathParam("id", USER_ID).
                log().all().
        when().
                get(APP_BASE_URL + "/{id}").
        then().
                statusCode(200).
                log().all()
        ;
    }

    @Test
    public void t03_deveAlterarUser() {

        String APP_MASSA_PUT = DadosPut.MASSA_PUT;

        given().
                pathParam("id",USER_ID).
                body(APP_MASSA_PUT).
        when().
                put(APP_BASE_URL + "/{id}").
        then().
                statusCode(200)
        ;
    }

    @Test
    public void t04_deveDeletarUser() {

        given().
                pathParam("id",USER_ID).
        when().
                delete(APP_BASE_URL + "/{id}").
        then().
                statusCode(204)
        ;
    }
}
