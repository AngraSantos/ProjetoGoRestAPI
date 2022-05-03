package api_pet_store;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    String uriPetStore = "https://petstore.swagger.io/v2/pet";

    public String lerJsonPet(String caminhoPet) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoPet)));
    }

    @Test(priority = 1)
    public void incluirPet() throws IOException {
        String jsonBodyPet = lerJsonPet("db/pet.json");

        given().
        contentType("application/json").
        body(jsonBodyPet).
        log().all().
        when().
        post(uriPetStore).
        then().
        statusCode(200).
        log().all();
    }

    @Test(priority = 2)
    public void consultarPet(){
        String petId = "1020";

        given().
                contentType("application/json").
                log().all().
                when().
                get(uriPetStore + "/" + petId).
                then().
                statusCode(200).
                log().all().
                body("category.name", Matchers.is("gato")).
                body("status",Matchers.is("available"));
    }


    @Test(priority = 3)
    public void alterarPet() throws IOException {
        String jsonBodyPet = lerJsonPet("db/petAlterar.json");

        given().
                contentType("application/json").
                body(jsonBodyPet).
                log().all().
                when().
                put(uriPetStore).
                then().
                statusCode(200).
                log().all().
                body("category.name", Matchers.is("cachorro"));
    }


    @Test(priority = 4)
    public void excluirPet(){
       String petId = "1020";


        given().
                contentType("application/json").
                log().all().
                when().
                delete(uriPetStore + "/" + petId).
                then().
                statusCode(200).
                log().all();
    }

}
