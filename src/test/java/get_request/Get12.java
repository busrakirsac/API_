package get_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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
        BookingDatesPojo bookingdates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jane", "Doe", 111, true, bookingdates, "Extra pillows please");

        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertions
        BookingPojo actualData = response.as(BookingPojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());
        assertEquals(bookingdates.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(), actualData.getBookingdates().getCheckout());




    }
}
