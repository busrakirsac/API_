package post_request;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.junit.Test;

public class Post03 extends JsonPlaceHolderBaseUrl {

     /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like
        {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
        }
     */

    @Test
    public void test03() {

        //Set the URL
        spec.pathParam("first", "todos");

        //Set the expected data

    }
}
