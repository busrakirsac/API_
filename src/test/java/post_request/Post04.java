package post_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static io.restassured.RestAssured.given;

public class Post04 extends HerokuAppBaseUrl {

    /*
        Given
          1)  https://restful-booker.herokuapp.com/booking
          2) {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
              }
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
                 {
                    "bookingid": 16,
                    "booking" :{
                        "firstname": "Ali",
                        "lastname": "Can",
                        "totalprice": 999,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2021-09-21",
                            "checkout": "2021-12-21"
                        },
                        "additionalneeds": "Breakfast"
                     }
                  }
     */


    @Test
    public void test04() {

        //Set the URL
        spec.pathParams("first","booking");

        //Set the expected data
        BookingDatesPojo bookingdates = new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo payload = new BookingPojo("Ali","Can",999,true,bookingdates,"Breakfast");
        System.out.println(payload);

        //Send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}");
      //  response.prettyPrint();

        //Do assertions
        BookingPojo actualData = response.as(BookingPojo.class);

    }
}
