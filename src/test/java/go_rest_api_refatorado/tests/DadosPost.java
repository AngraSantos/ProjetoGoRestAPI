package go_rest_api_refatorado.tests;

public interface DadosPost {

    String USER_NAME = "Angra Santos " + System.nanoTime();
    String USER_EMAIL = "Angra.santos" + System.nanoTime();
    String MASSA_POST = "{ \"name\": \""+USER_NAME+"\", \"email\": \""+USER_EMAIL+"@gmail.com\", \"gender\": \"male\", \"status\": \"active\" }";

    // Posso incluir a variável do Gender e do Status, assim como o name e email.
}
