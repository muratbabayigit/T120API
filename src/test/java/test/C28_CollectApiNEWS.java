package test;

import baseUrl.CollectAPIBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C28_CollectApiNEWS extends CollectAPIBaseUrl {

@Test
    public void heberler(){
    specCollectApi.pathParams("pp1","news","pp2","getNews")
                  .queryParams("country","tr","tag","health");
    String token="0YuQ2qQmEU9EvagZL5sDib:2ATmQTMC6mix2OSEv8QrEq";


    Response response=given()
                            .spec(specCollectApi)
                            .header("authorization","apikey "+token)
                            .when().get("/{pp1}/{pp2}");

    response.prettyPrint();









}




}
