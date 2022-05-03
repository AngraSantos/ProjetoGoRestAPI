package api_pet_store_refatorado;

import io.restassured.http.ContentType;

public interface PetConstantes {

    String APP_BASE_URL = "https://petstore.swagger.io/v2/pet";
    Integer APP_PORT = 443; //Se for porta https, instanciar a 443 caso contrário usar a 80
    String APP_BASE_PATH = "v2"; //Caso a API estiver v1, v2...
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 5000L;
}
