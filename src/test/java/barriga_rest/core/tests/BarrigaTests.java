package barriga_rest.core.tests;

import barriga_rest.core.BaseTest;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import util.DataUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BarrigaTests extends BaseTest {

    private String TOKEN;
    private static String CONTA_NAME = "Conta da Patty " + System.nanoTime();
    private static Integer CONTA_ID;
    private static Integer MOV_ID;

    @Before
    public void login(){
        Map<String,String> login = new HashMap<>();
        login.put("email","angra.santos@hotmail.com.br");
        login.put("senha","1234");

        TOKEN = given().
                    body(login).
                when().
                    post("/signin").
                then().
                    statusCode(200).
                    extract().path("token")
                    ;
    }


    @Test
    public void t01_naoDeveAcessarSemToken() {

        given().
        when().
                get("/contas").
        then().
                statusCode(401);
    }

    @Test
    public void t02_deveIncluirConta() {

        CONTA_ID = given().
                header("Authorization", "JWT " + TOKEN).
                body("{ \"nome\": \""+CONTA_NAME+"\" }").
                when().
                post("/contas").
                then().
                statusCode(201).
                extract().path("id")
        ;

    }

    @Test
    public void t03_deveAlterarConta() {
           // String idConta1 = "1108602";

            given().
                    header("Authorization", "JWT " + TOKEN).
                    body("{ \"nome\": \""+CONTA_NAME+" santos\" }").
                    pathParam("id",CONTA_ID).
                    when().
                    put("/contas/{id}").
                    then().
                    statusCode(200).
                   // log().all().
                    body("nome", Matchers.is(CONTA_NAME +" santos"))
                    /*body("id", Matchers.is(1108602)).
                    body("visivel", Matchers.is(true)).
                    body("usuario_id", Matchers.is(28401))*/
            ;
        }


    @Test
    public void t04_deveInserirMovimentacao(){
        Movimentacao mov = getMovimentacao();

        MOV_ID = given().
                header("Authorization","JWT " + TOKEN).
                body(mov).
        when().
                post("/transacoes").
        then().
                statusCode(201).
                log().all().
                extract().path("id")
        ;
    }


    @Test
    public void t05_deveValidarCamposObrigatoriosMovimentacao(){
        given().
                header("Authorization","JWT " + TOKEN).
                body("{}").
        when().
                post("/transacoes").
        then().
                statusCode(400).
                body("msg",Matchers.hasItems(
                        "Data da Movimentação é obrigatório",
                        "Data do pagamento é obrigatório",
                        "Descrição é obrigatório",
                        "Interessado é obrigatório",
                        "Valor é obrigatório",
                        "Valor deve ser um número",
                        "Conta é obrigatório",
                        "Situação é obrigatório"
                ))
        ;
    }

    @Test
    public void t06_deveCalcularSaldoContas() {
        given().
                header("Authorization","JWT " + TOKEN).
                //body("{}").
        when().
                get("/saldo").
        then().
                statusCode(200).
                log().all().
                body("find{it.conta_id == "+CONTA_ID+"}.saldo",Matchers.is("150.00"))
        ;
    }

    @Test
    public void t07_deveRemoverMovimentacao(){

        given().
                header("Authorization","JWT " + TOKEN).
                pathParam("id",MOV_ID).
        when().
                delete("/transacoes/{id}").
        then().
                statusCode(204)
        ;
    }

    private Movimentacao getMovimentacao(){
        Movimentacao mov = new Movimentacao();
        mov.setConta_id(CONTA_ID);
        mov.setDescricao("Descrição da Movimentação");
        mov.setEnvolvido("Envolvido na Movimentação");
        mov.setTipo("REC");
        mov.setData_transacao(DataUtil.getDataDiferencaDias(-1));
        mov.setData_pagamento(DataUtil.getDataDiferencaDias(5));
        mov.setValor(150f);
        mov.setStatus(true);
        return mov;
    }
}
//COMO ESCREVER UM JSON EM UMA LINHA DE CODIGO
// { "nome": "conta da Sabrina" }


