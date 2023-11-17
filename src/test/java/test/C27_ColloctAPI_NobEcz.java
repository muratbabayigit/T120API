package test;

import baseUrl.CollectAPIBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C27_ColloctAPI_NobEcz extends CollectAPIBaseUrl {

@Test
    public void NobetciEcz(){
        specCollectApi.pathParams("pp1","health","pp2","dutyPharmacy")
                      .queryParams("ilce","Üsküdar","il","İstanbul");

    String token="0YuQ2qQmEU9EvagZL5sDib:2ATmQTMC6mix2OSEv8QrEq";
    Response response=given()
                            .spec(specCollectApi)
                            .headers("authorization","apikey "+token)
                            .when()
                            .get("/{pp1}/{pp2}");
    System.out.println("statusCode = " + response.statusCode());
    response.prettyPrint();



}




}
