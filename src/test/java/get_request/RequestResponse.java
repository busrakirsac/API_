package get_request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/2";

       Response response=  given().when().get(url);
       //response.prettyPrint();

        System.out.println("statusCode() = " + response.statusCode());

        System.out.println("contentType() = " + response.contentType());

        System.out.println("statusLine() = " + response.statusLine());

        System.out.println("header(\"Server\") = " + response.header("Server"));

        System.out.println("headers \n = " + response.headers());

        System.out.println("time() = " + response.time());
    }
}
