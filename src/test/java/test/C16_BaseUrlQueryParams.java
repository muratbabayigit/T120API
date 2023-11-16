package test;

import baseUrl.HerOkuAppBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C16_BaseUrlQueryParams extends HerOkuAppBaseURL {
    // Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 956 id'ye sahip bir booking oldugunu test edin
     */

     /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */

    /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
         parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri
         “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
         donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip
         en az bir booking oldugunu test edin.
    */

    @Test
    public void get01(){
        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve Response’ta 956 id'ye sahip bir booking oldugunu test edin
     */
        specHerOkuApp.pathParam("pp1","booking");
        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("bookingid", hasItem(956));

    }
    @Test
    public void get02(){
          /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak “firstName” degeri “Eric” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un
        status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
    */
        specHerOkuApp.pathParam("pp1","booking").queryParam("firstName","Eric");
        Response response=given().spec(specHerOkuApp).when().get("/{pp1}");

       // response.prettyPrint();
       //response.then().assertThat().statusCode(200).body("bookingid",notNullValue());
        response.then().assertThat().statusCode(200).body("bookingid",hasSize(greaterThan(0)));




    }

    public void get03(){

    }

}
