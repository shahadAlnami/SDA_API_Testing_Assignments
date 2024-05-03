package request_week10.Assignment_13;

import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class R03_GetUser extends ContactListBaseUrl {

    @Test
    public void GetUserTest(){

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        //set the url
        specification.pathParams("1","users","2","me");

        //send the request and get the response
        Response response = given(specification).header("Authorization", "Bearer " + token).get("{1}/{2}");

        // do assertion
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
