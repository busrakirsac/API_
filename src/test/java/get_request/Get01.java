package get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

     /*
        Given
            https://petstore.swagger.io/v2/pet/5
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */


    @Test
    public void get1a() {

        String url = "https://petstore.swagger.io/v2/pet/5";

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        RestAssured.basePath = "/pet/5";

        Response response= given().when().get();
        response.prettyPrint();
        /*
        {
    "id": 5,
    "category": {
        "id": 0,
        "name": "string"
    },
    "name": "doggie",
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "string"
}
         */

        response.
                then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().statusLine("HTTP/1.1 200 OK");

    }


    @Test
    public void get01b() {

            String url = "https://petstore.swagger.io/v2/pet/5";

            RestAssured.baseURI = "https://petstore.swagger.io/v2";

            RestAssured.basePath = "/pet/5";

          given()
                  .when()
                  .get()
                  .then()
                  .statusCode(200)
                  .contentType("application/json")
                  .statusLine("HTTP/1.1 200 OK");

    }
}
