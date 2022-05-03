package api_swagger_refatorado.tests;

public interface DadosPutSwagger {

    //String USER_USERNAME = "joao123";

    /*String MASSA_USER_ARRAY_PUT =
            "{\n" +
            "    \"username\": \""+USER_USERNAME+"\",\n" +
            "    \"firstName\": \"joazinho\",\n" +
            "    \"lastName\": \"oliveira\",\n" +
            "    \"email\": \"joaozinho.oliveira@hotmail.com.br\",\n" +
            "    \"password\": \"123321\",\n" +
            "    \"phone\": \"11970510060\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n";*/

    /*String MASSA_USER_PUT =
            "{\n" +
            "  \"username\": \""+USER_USERNAME+"\",\n" +
            "  \"firstName\": \"joaozinho\",\n" +
            "  \"lastName\": \"ferreira\",\n" +
            "  \"email\": \"joao.ferreira@gmail.com\",\n" +
            "  \"password\": \"123321\",\n" +
            "  \"phone\": \"11970510060\",\n" +
            "  \"userStatus\": 0\n" +
            "}";*/

    Integer ID_PET = 8942;
    String NAME_PET_TIPO = "cachorro";
    String NAME_PET = "lulu";

    String MASSA_PET_PUT = "{\n" +
            " \"id\": \""+ID_PET+"\", \n" +
            "\"category\": { \n" +
            "\"id\": 0,\n" +
            " \"name\": \""+NAME_PET_TIPO+"\" \n" +
            "},\n" +
            " \"name\": \""+NAME_PET+"\",\n" +
            " \"photoUrls\": [\n" +
            " \""+NAME_PET_TIPO+"\" \n" +
            "], \n" +
            "\"tags\": [ \n" +
            "{\n" +
            " \"id\": 0,\n" +
            " \"name\": \""+NAME_PET_TIPO+"\" \n" +
            "}\n" +
            "],\n" +
            " \"status\": \"available\"\n" +
            "}";
}
