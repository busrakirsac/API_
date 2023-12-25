package get_request;

import baseUrl.HerokuAppBaseUrl;
import org.junit.Test;

public class Get12 extends HerokuAppBaseUrl {

     /*
     Given
         https://restful-booker.herokuapp.com/booking/535
     When
         I send GET Request to the URL
     Then
         Status code is 200
     And
         Response body is like:
            {
                "firstname" : "Jane",
                "lastname" : "Doe",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
                    "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
                },
                "additionalneeds" : "Extra pillows please"
            }
  */


    @Test
    public void test12() {

        //Set the URL
        spec.pathParams("first", "booking", "second", 535);

        //Set the expected data

    }
}
