package api_swagger_refatorado.tests;

import api_swagger_refatorado.SwaggerStoreConstantes;
import groovy.transform.Internal;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SwaggerStoreTest implements SwaggerStoreConstantes {

    @Test
    public void t01_incluir() throws IOException {
        String APP_MASSA_USER = DadosPostSwagger.MASSA_PET_POST;

        given().
                contentType(APP_CONTENT_TYPE).
                body(APP_MASSA_USER).
                log().all().
        when().
                post(APP_BASE_URL3).
        then().
                statusCode(200).
                log().all().
                extract().path("id")
        ;

    }

    @Test
    public  void t02_consultar() {
        Integer APP_MASSA_CONSULTAR = DadosPostSwagger.ID_PET;

        given().
                contentType(APP_CONTENT_TYPE).
                log().all().
        when().
                get(APP_BASE_URL3 + "/" + APP_MASSA_CONSULTAR).
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void t03_alterar() throws IOException {
        String APP_MASSA_PUT = DadosPutSwagger.MASSA_PET_PUT;

        given().
                contentType(APP_CONTENT_TYPE).
                body(APP_MASSA_PUT).
                log().all().
        when().
                put(APP_BASE_URL3).
        then().
                statusCode(200).
                log().all()
        ;

    }

    @Test
    public void t04_deletar(){
        Integer APP_MASSA_DELETE = DadosPutSwagger.ID_PET;

        given().
                contentType(APP_CONTENT_TYPE).
                log().all();
        when().
                delete(APP_BASE_URL3 + "/" + APP_MASSA_DELETE).
        then().
                statusCode(200).
                log().all();
    }
}
