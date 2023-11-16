package test;

import baseUrl.HerOkuAppBaseURL;
import org.junit.Test;
import pojos.BookingDatesPOJO;
import pojos.BookingPOJO;

public class C24_POST_POJOClas extends HerOkuAppBaseURL {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Data
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){
        specHerOkuApp.pathParam("pp1","booking");
        BookingDatesPOJO bookingdates=new BookingDatesPOJO("2021-06-01","2021-06-10");
        BookingPOJO reqBody=new BookingPOJO("Ali","Bak",500,false,bookingdates,"wi-fi");







    }

}
