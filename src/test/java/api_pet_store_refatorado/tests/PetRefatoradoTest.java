package api_pet_store_refatorado.tests;

import api_pet_store_refatorado.PetBaseTest;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetRefatoradoTest extends PetBaseTest {

    private static Integer PET_ID;

    @Test
    public void t01_incluirPet() throws IOException {
        String APP_MASSA_POST = DadosPostPet.MASSA_POST;

        PET_ID = given().
                contentType(APP_CONTENT_TYPE).
                body(APP_MASSA_POST).
                log().all().
                when().
                post(APP_BASE_URL).
                then().
                statusCode(200).
                log().all().
                extract().path("id");
    }

    @Test
    public void t02_consultarPet() {
        Integer APP_PET_ID = DadosPostPet.ID_PET;

        given().
                contentType(APP_CONTENT_TYPE).
                log().all().
                when().
                get(APP_BASE_URL + "/" + APP_PET_ID).
                then().
                statusCode(200).
                log().all().
                body("category.name", Matchers.is("Gato")).
                body("status", Matchers.is("available"));
    }

    @Test
    public void t03_alterarPet() throws IOException {

        String APP_MASSA_PUT = DadosPutPet.MASSA_PUT;

        given().
                contentType(APP_CONTENT_TYPE).
                body(APP_MASSA_PUT).
                log().all().
                when().
                put(APP_BASE_URL).
                then().
                statusCode(200).
                log().all().
                body("category.name", Matchers.is("cachorro"));
    }

    @Test
    public void t04_excluirPet() {
        Integer APP_PET_ID = DadosPostPet.ID_PET;

            given().
                    contentType(APP_CONTENT_TYPE).
                    log().all().
                    when().
                    delete(APP_BASE_URL + "/" + APP_PET_ID).
                    then().
                    statusCode(200).
                    log().all();
        }
}