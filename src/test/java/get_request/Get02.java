package get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class Get02 {
      /*
        Given
            https://petstore.swagger.io/v2/pet/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Pet not found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Jetty(9.2.9.v20150224)" olmalı
    */

    @Test
    public void test01() {

        //Set the URL
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.basePath ="/pet/0";

        //Set the expected data

        //Send the request and get the response
        Response response= given().when().get();
        response.prettyPrint();

        /*
        {
    "code": 1,
    "type": "error",
    "message": "Pet not found"
}
         */
        //Do assertions

        response.then().assertThat()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))
                .body(not(containsString("TechProEd")))
                .header("Server","Jetty(9.2.9.v20150224)");

    }
}
