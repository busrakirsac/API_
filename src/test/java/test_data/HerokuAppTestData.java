package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {

    public Map<String, String> getBookingDates(String checkin, String checkout) {

        Map<String, String> bookingdatesData = new HashMap<>();
        bookingdatesData.put("checkin", checkin);
        bookingdatesData.put("checkout", checkout);

        return bookingdatesData;
    }


    public Map<String, Object> getPayLoad(String firstname, String lastname, int totalprice, boolean depositpaid, Map<String, String> bookingdatesData, String additionalneeds) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdatesData);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;
    }


}
