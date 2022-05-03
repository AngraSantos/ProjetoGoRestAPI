package api_user_swagger;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserStore {
    String uriUserStore = "https://petstore.swagger.io/v2/user";

    public String lerJsonUser(String caminhoUSER) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoUSER)));
    }

    @Test(priority = 1)
    public void incluirUserStore() throws IOException {
    String jsonBodyUser = lerJsonUser("db/userStore.json");
    String criarUser = "/createWithArray";

    given().
            contentType("application/json").
            body(jsonBodyUser).
            log().all().
    when().
            post(uriUserStore + criarUser).
    then().
            statusCode(200).
            log().all().
            extract().path("username");

    }

    @Test(priority = 2)
    public  void consultarUserStore() {
        String username = "angra1996";

        given().
                contentType("application/json").
                log().all().
        when().
                get(uriUserStore + "/" + username).
        then().
                statusCode(200).
                log().all().
                body("username", Matchers.is("angra1996"));
    }

    @Test(priority = 3)
    public void alterarUserStore() throws IOException {
        String jsonBodyUser2 = lerJsonUser("db/userStoreAlterar.json");
        String usernameAlterar = "angra1996";

        given().
                contentType("application/json").
                body(jsonBodyUser2).
                log().all().
        when().
                put(uriUserStore + "/" + usernameAlterar).
        then().
                statusCode(200).
                log().all();

    }


    @Test(priority = 4)
    public void deletarUserStore(){
    String usernameAlterar = "cleberb1979";

        given().
                contentType("application.json").
                log().all();
        when().
                delete(uriUserStore + "/" + usernameAlterar).
        then().
                statusCode(200).
                log().all();
    }
}
