package herokuapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;
import pojos.herokuapp.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC01_CreateBooking extends HerokuAppBaseUrl {

    public static int bookingId;

    /*

      Given
          https://restful-booker.herokuapp.com/booking
      And
         {
              "firstname" : "Jim",
              "lastname" : "Brown",
              "totalprice" : 111,
              "depositpaid" : true,
              "bookingdates" : {
                  "checkin" : "2018-01-01",
                  "checkout" : "2019-01-01"
              },
              "additionalneeds" : "Breakfast"
     }'
     When
            Kullanici POST Request gonderir
     Then
            Status Code: 200
      And
            Response body
            {
               "bookingid": 1,
               "booking": {
                   "firstname": "Jim",
                   "lastname": "Brown",
                   "totalprice": 111,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2018-01-01",
                       "checkout": "2019-01-01"
                   },
                   "additionalneeds": "Breakfast"
               }
            }

     */


    @Test
    public void createBooking() {

        spec.pathParam("first", "booking");

        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo payLoad = new BookingPojo("Jim", "Brown", 111, true, bookingDates, "Breakfast");

        Response response = given(spec).body(payLoad).when().post("{first}");
        bookingId = response.jsonPath().getInt("bookingid");


        BookingResponsePojo actualData = response.as(BookingResponsePojo.class);
        assertEquals(200, response.statusCode());
        assertEquals(payLoad.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(payLoad.getLastname(), actualData.getBooking().getLastname());
        assertEquals(payLoad.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(payLoad.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(payLoad.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());
        assertEquals(bookingDates.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());

    }
}
