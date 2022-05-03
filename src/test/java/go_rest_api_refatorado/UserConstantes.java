package go_rest_api_refatorado;

import io.restassured.http.ContentType;

public interface UserConstantes {

        String APP_BASE_URL = "https://gorest.co.in/public/v2/users";
        Integer APP_PORT = 443; //Se for porta https, instanciar a 443 caso contrário usar a 80
        String APP_BASE_PATH = "v2"; //Caso a API estiver v1, v2...
        String APP_TOKEN = "44b3a296b458ebfe2de446c9fe882d44fcd904dc9cd05838b797d4a35f07e32f";
        ContentType APP_CONTENT_TYPE = ContentType.JSON;
        Long MAX_TIMEOUT = 5000L;
    }
