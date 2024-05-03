package request_week10.Assignment_13;

import Pojos.ContactListAddUserPojo;
import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R04_UpdateUser extends ContactListBaseUrl {

    @Test
    public void UpdateUserTest() {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        //set the url
        specification.pathParams("1", "users", "2", "me");

        // set the expected data
        String strJson = """
            {
                "firstName": "Updated Name",
                "lastName": "Updated lastname",
                "email": "UpdatedEmail@fake.com",
                "password": "myPassword"
            }
            """;

        ContactListAddUserPojo expectedData = convertJsonToJava(strJson, ContactListAddUserPojo.class);

        //send the request and get the response
        Response response = given(specification).header("Authorization", "Bearer " + token).body(expectedData).patch("{1}/{2}");

        // do assertion
        response.then().statusCode(200);
        response.prettyPrint();
    }
}