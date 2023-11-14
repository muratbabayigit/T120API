package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class herOkuAppBaseURL {

    protected RequestSpecification specHerOkuApp;

    @Before
    public void setUP(){
        specHerOkuApp= new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }

}
