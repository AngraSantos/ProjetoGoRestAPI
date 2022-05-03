package api_swagger_refatorado;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class SwaggerStoreBaseTest implements SwaggerStoreConstantes {

    @BeforeClass
    public static void setup() {

        //Declarações no request da interface Constantes
        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.baseURI = APP_BASE_URL2;
        RestAssured.baseURI = APP_BASE_URL3;
        RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;

        //Builders contrutores de resquest
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        //Builders do bloco do response
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
