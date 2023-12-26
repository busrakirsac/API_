package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationHerokuApp {

   // public static void main(String[] args) {
   //     System.out.println(generateToken());
   // }

    public static String generateToken(){ //post request

        String body = "{\n" +
                "    \"email\": \"zixuan.kayveon@falkcia.com\",\n" +
                "    \"password\": \"1234567\"\n" +
                "}";

       Response response =  given().body(body).contentType(ContentType.JSON).when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");


      return response.jsonPath().getString("token");
    }
}
