package request_week10.Assignment_11;

import Pojos.userPojo;
import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static request_week10.Assignment_11.R01_CreateUser.username;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R02_GetUser extends SwaggerBaseUrl {
    /**
     * Write an automation test that will create a 'user' then read, update and delete the created user
     * using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
     */

    @Test
    public void GetUser() {
        //set the url
        specification.pathParams("1", "user","2",username);

        //set the expected data
        String strJson = """
                {
                  "id": 2006,
                  "username": "shahad37",
                  "firstName": "shahad",
                  "lastName": "alnami",
                  "email": "shahad@gmail.com",
                  "password": "12345",
                  "phone": "0512345678",
                  "userStatus": 0
                }
                """;

        Map expectedData = convertJsonToJava(strJson, Map.class);

        //send the request and get the response
        Response response = given(specification).get("{1}/{2}");
        Map actualData = convertJsonToJava(response.asString(), Map.class);

        //Do assertion
        response.then().statusCode(200);
        assertEquals(actualData.get("id"), expectedData.get("id"));
        assertEquals(actualData.get("username"), expectedData.get("username"));
        assertEquals(actualData.get("firstName"), expectedData.get("firstName"));
        assertEquals(actualData.get("lastName"), expectedData.get("lastName"));
        assertEquals(actualData.get("email"), expectedData.get("email"));
        assertEquals(actualData.get("password"), expectedData.get("password"));
        assertEquals(actualData.get("phone"), expectedData.get("phone"));
        assertEquals(actualData.get("userStatus"), expectedData.get("userStatus"));
    }
}

