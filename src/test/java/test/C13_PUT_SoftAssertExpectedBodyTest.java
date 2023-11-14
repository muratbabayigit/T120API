package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_PUT_SoftAssertExpectedBodyTest {

     /*
    https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
    body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }

            Response Body - Expected Body
            {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
                 */

    @Test
    public void put01(){
        //1- EndPoint Hazırla
        String url="https://dummy.restapiexample.com/api/v1/update/21";
        /*
        {
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }
         */

        JSONObject data=new JSONObject();
        data.put("name","Mustafa");
        data.put("salary","1251");
        data.put("age","18");
        data.put("id",550);


        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",data);

        //2- Expected Data hazırlama

        JSONObject expBody=new JSONObject();
        expBody.put("status","success");
        expBody.put("data",reqBody);
        expBody.put("message","Successfully! Record has been updated.");

    //3-Response Kaydetmek

        Response response=given()
                                .contentType(ContentType.JSON)
                         .when().body(reqBody.toString()).put(url);

       // response.prettyPrint();

        SoftAssert softAssert=new SoftAssert();

        JsonPath resJP=response.jsonPath();
        /*
        {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":"Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
         */

        softAssert.assertEquals(resJP.get("status"),expBody.get("status"));
        softAssert.assertEquals(resJP.get("data.status"),expBody.getJSONObject("data").get("status"));
        softAssert.assertEquals(resJP.get("data.data.name"),expBody.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(resJP.get("data.data.salary"),expBody.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJP.get("data.data.age"),expBody.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(resJP.get("data.data.id"),expBody.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("message"),expBody.get("message"));

        softAssert.assertAll();














    }


}
