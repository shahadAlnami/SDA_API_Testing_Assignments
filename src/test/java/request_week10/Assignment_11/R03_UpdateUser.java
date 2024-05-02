package request_week10.Assignment_11;

import Pojos.userPojo;
import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static request_week10.Assignment_11.R01_CreateUser.username;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R03_UpdateUser  extends SwaggerBaseUrl {


    /**
     * Write an automation test that will create a 'user' then read, update and delete the created user
     * using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
     */

    @Test
    public void CreateUserTest() {

        //set the url
        specification.pathParams("1", "user","2",username);
        //set the expected data
        String strJson = """
                {
                  "id": 2000,
                  "username": "shahad37",
                  "firstName": "shahad",
                  "lastName": "alnami",
                  "email": "shahad@gmail.com",
                  "password": "12345",
                  "phone": "0512345678",
                  "userStatus": 0
                }
                """;

        userPojo expectedData = convertJsonToJava(strJson, userPojo.class);

        //send the request and get the response
        Response response = given(specification).body(expectedData).put("{1}/{2}");

        //Do assertion
        response.then().statusCode(200);
    }
}