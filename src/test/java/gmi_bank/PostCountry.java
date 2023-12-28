package gmi_bank;

import baseUrl.GmiBankBaseUrl;

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


}
