package go_rest_api_refatorado.tests;

public interface DadosPut {

    String USER_NAME = "Angra Santos " + System.nanoTime();
    String USER_EMAIL = "Angra.santos" + System.nanoTime();
    String MASSA_PUT = "{ \"name\": \""+USER_NAME+" Souza\", \"email\": \""+USER_EMAIL+"@hotmail.com\", \"gender\": \"male\", \"status\": \"active\" }";

    // Posso incluir a variável do Gender e do Status, assim como o name e email.
}
