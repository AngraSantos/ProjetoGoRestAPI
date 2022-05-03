package api_swagger_refatorado.tests;

public interface DadosPostSwagger {

    //String USER_USERNAME = "diego123";

    /*String MASSA_USER_ARRAY_POST =
            "[\n" +
            "  {\n" +
            "    \"username\": \""+USER_USERNAME+"\",\n" +
            "    \"firstName\": \"diego\",\n" +
            "    \"lastName\": \"paulino\",\n" +
            "    \"email\": \"diego.paulino@hotmail.com.br\",\n" +
            "    \"password\": \"123321\",\n" +
            "    \"phone\": \"11970510060\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]";*/

    /*String MASSA_USER_POST =
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
    String NAME_PET_TIPO = "Gato";
    String NAME_PET = "lili";

    String MASSA_PET_POST =
            "{\n" +
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

