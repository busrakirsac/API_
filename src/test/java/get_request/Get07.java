package get_request;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends HerokuAppBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/1192
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
      {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
     */

    @Test
    public void test07() {

        //Set the URL
        spec.pathParams("first", "booking", "second", 1192);

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertions
        //1.yol
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Josh"))
                .body("lastname", equalTo("Allen"))
                .body("totalprice", equalTo(111))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2018-01-01"))
                .body("bookingdates.checkout", equalTo("2019-01-01"))
                .body("additionalneeds", equalTo("super bowls"));


        //JsonPath Alistirmalari
        JsonPath json = response.jsonPath();
        json.getString("firstname");
        int totatPrice = json.getInt("totalprice");
        System.out.println("totalPrice : " +totatPrice);
        json.getString("bookingdates.checkin");
        json.getString("bookingdates.checkout");


        //2.yol
        assertEquals(200,response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("super bowls",json.getString("additionalneeds"));

    }
}
