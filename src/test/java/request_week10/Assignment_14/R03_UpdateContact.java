package request_week10.Assignment_14;

import Pojos.ContactListAddContactPojo;
import Pojos.ContactListAddUserPojo;
import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R03_UpdateContact extends ContactListBaseUrl {

    @Test
    public void UpdateUserTest() {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        //set the url
        specification.pathParams("1", "contacts");

        // set the expected data
        String strJson = """
                {
                    "firstName": "Amy",
                    "lastName": "Miller",
                    "birthdate": "1992-02-02",
                    "email": "amiller@fake.com",
                    "phone": "8005554242",
                    "street1": "13 School St.",
                    "street2": "Apt. 5",
                    "city": "Washington",
                    "stateProvince": "QC",
                    "postalCode": "A1A1A1",
                    "country": "Canada"
                }
                            """;

        ContactListAddContactPojo expectedData = convertJsonToJava(strJson, ContactListAddContactPojo.class);

        //send the request and get the response
        Response response = given(specification).header("Authorization", "Bearer " + token).body(expectedData).put("{1}");

        // do assertion
        response.then().statusCode(200);
        response.prettyPrint();
    }
}