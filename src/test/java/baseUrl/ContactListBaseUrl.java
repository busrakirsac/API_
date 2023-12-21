package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ContactListBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTgzZmE5NTMxNjljZjAwMTMwZTZiN2MiLCJpYXQiOjE3MDMxNDk4ODF9.-XSEYKnbrQ_Vt6fWfMIbuclxXMPe2GNoixPXzyTbz7w")
                .build();
    }
}
