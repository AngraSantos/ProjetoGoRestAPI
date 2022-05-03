package go_rest_api;

import io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class User {
    String uriGoRest = "https://gorest.co.in/public/v2/users";
    private static Integer clienteId;

    public String lerJson(String caminhoUser) throws IOException {
        return new String (Files.readAllBytes(Paths.get(caminhoUser)));
    }

    @Test(priority = 1)
    public void incluirUser() throws IOException {
    String paramToken = "44b3a296b458ebfe2de446c9fe882d44fcd904dc9cd05838b797d4a35f07e32f";
    String jsonBody = lerJson("db/user.json");

                clienteId = given().
                contentType("application/json").
                header("Authorization", "Bearer " + paramToken).
                body(jsonBody).
                log().all().
                when().
                post(uriGoRest).
                then().
                statusCode(201).
                log().all().
                extract().path("id");
    }

    @Test(priority = 2)
    public void consultarUser(){
        String paramToken = "44b3a296b458ebfe2de446c9fe882d44fcd904dc9cd05838b797d4a35f07e32f";

                given().
                contentType("application/json").
                pathParam("id", clienteId).
                header("Authorization", "Bearer " + paramToken).
                log().all().
                when().
                get(uriGoRest + "/{id}").
                then().
                statusCode(200).
                log().all();
    }

    @Test(priority = 3)
    public void alterarUser() throws IOException {
        String paramToken = "44b3a296b458ebfe2de446c9fe882d44fcd904dc9cd05838b797d4a35f07e32f";
        String jsonBody = lerJson("db/useralterar.json");

                given().
                contentType("application/json").
                pathParam("id",clienteId).
                header("Authorization", "Bearer " + paramToken).
                body(jsonBody).
                log().all().
                when().
                put(uriGoRest + "/{id}").
                then().
                statusCode(200).
                log().all();
    }

    @Test(priority = 4)
    public void deletarUser(){
        String paramToken = "44b3a296b458ebfe2de446c9fe882d44fcd904dc9cd05838b797d4a35f07e32f";

                given().
                contentType("application/json").
                pathParam("id",clienteId).
                header("Authorization", "Bearer " + paramToken).
                log().all().
                when().
                delete(uriGoRest + "/{id}").
                then().
                statusCode(204).
                log().all();
    }
}
