package go_rest_api_refatorado;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class UserBaseTest implements UserConstantes {

    @BeforeClass
    public static void setup() {

        //Declarações no request da interface Constantes
        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;
        RestAssured.oauth2(APP_TOKEN);

        //Builders contrutores de resquest
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        reqBuilder.addHeader("Authorization", "Bearer " + APP_TOKEN);
        RestAssured.requestSpecification = reqBuilder.build();

        //Builders do bloco do response
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}

