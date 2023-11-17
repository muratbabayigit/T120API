package test;

import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPOJO;
import pojos.DummyExpDataPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Get_POJOKullanimi extends DummyBaseUrl {
     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	Response Body-Expected Data
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */
@Test
    public void Get01(){
    specDummy.pathParams("first","api","second","v1","third","employee","fourth",3);

    DummyDataPOJO data=new DummyDataPOJO(3,"Ashton Cox",86000,66,"");
    DummyExpDataPOJO expData=new DummyExpDataPOJO("success",data,"Successfully! Record has been fetched.");

    Response response=given().spec(specDummy).when().get("/{first}/{second}/{third}/{fourth}");
    DummyExpDataPOJO respPOJO= response.as(DummyExpDataPOJO.class);

    assertEquals(expData.getStatus(),respPOJO.getStatus());
    assertEquals(expData.getData().getId(),respPOJO.getData().getId());
    assertEquals(expData.getData().getEmployee_name(),respPOJO.getData().getEmployee_name());
    assertEquals(expData.getData().getEmployee_salary(),respPOJO.getData().getEmployee_salary());
    assertEquals(expData.getData().getEmployee_age(),respPOJO.getData().getEmployee_age());
    assertEquals(expData.getData().getProfile_image(),respPOJO.getData().getProfile_image());
    assertEquals(expData.getMessage(),respPOJO.getMessage());











}




}
