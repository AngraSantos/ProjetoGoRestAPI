package barriga_rest.core;

import io.restassured.http.ContentType;

public interface Constantes {
    String APP_BASE_URL = "http://barrigarest.wcaquino.me/";
    Integer APP_PORT = 80; //Se for porta https, instanciar a 443
    String APP_BASE_PATH = ""; //Caso a API estiver v1, v2...
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 5000L;
}
