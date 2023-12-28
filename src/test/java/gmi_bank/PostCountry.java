package gmi_bank;

import baseUrl.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.gmibank.CountryPojo;
import pojos.gmibank.StatesPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostCountry extends GmiBankBaseUrl {

       /*
        https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dokümanını kullanarak en az 3 "state"
        içeren bir "country" oluşturan bir otomasyon testi yazınız.
        Not : Autherization için headers'a "Authorization" = ""Bearer abc123"  şeklinde Bearer token giriniz.
     */

    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "Muz Cumhuriyeti",
          "states": [
            {
              "id": 1,
              "name": "Elma"
            },
            {
              "id": 2,
              "name": "Armut"
            },
            {
              "id": 3,
              "name": "Portakal"
            }
          ]
        }
    When
        Kullanıcı POST Request gönderir
    Then
        Status Code: 201
    And
        {
            "id": 194115,
            "name": "Muz Cumhuriyeti",
            "states": [
                {
                    "id": 1,
                    "name": "Elma",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Armut",
                    "tpcountry": null
                },
                {
                    "id": 3,
                    "name": "Portakal",
                    "tpcountry": null
                }
            ]
        }
    */

    @Test
    public void postCountry() {

        spec.pathParams("first", "api", "second", "tp-countries");

        StatesPojo states1 = new StatesPojo(1, "Elma");
        StatesPojo states2 = new StatesPojo(2, "Armut");
        StatesPojo states3 = new StatesPojo(3, "Portakal");

        List<StatesPojo> statesList = new ArrayList<>();
        statesList.add(states1);
        statesList.add(states2);
        statesList.add(states3);


        CountryPojo payLoad = new CountryPojo("Muz Cumhuriyeti", statesList);

        Response response = given(spec).body(payLoad).when().post("{first}/{second}");
        response.prettyPrint();


        CountryPojo actualData = response.as(CountryPojo.class);
        assertEquals(payLoad.getName(), actualData.getName());
        assertEquals(states1.getId(), actualData.getStates().get(0).getId());
        assertEquals(states1.getName(), actualData.getStates().get(0).getName());
        assertEquals(states2.getId(), actualData.getStates().get(1).getId());
        assertEquals(states2.getName(), actualData.getStates().get(1).getName());
        assertEquals(states3.getId(), actualData.getStates().get(2).getId());
        assertEquals(states3.getName(), actualData.getStates().get(2).getName());



    }
}
