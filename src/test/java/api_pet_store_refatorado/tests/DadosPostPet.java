package api_pet_store_refatorado.tests;

public interface DadosPostPet {

    Integer ID_PET = 8942;
    String NAME_PET_TIPO = "Gato";
    String NAME_PET = "lili";
    String MASSA_POST = "{\n" +
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
