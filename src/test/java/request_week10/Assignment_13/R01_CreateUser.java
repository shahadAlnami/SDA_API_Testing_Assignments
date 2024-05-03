package request_week10.Assignment_13;

import Pojos.ContactListAddUserPojo;
import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R01_CreateUser extends ContactListBaseUrl {

    /**Write an automation test that will create a 'user' then read, update and delete the created user
     * using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.*/


    @Test
    public void CreateUserTest(){

        //set the url
        specification.pathParams("1","users");

        // set the expected data
        String strJson = """
            {
                "firstName": "Shahad",
                "lastName": "sh",
                "email": "sha@fake.com",
                "password": "myPassword"
            }
            """;

        ContactListAddUserPojo expectedData = convertJsonToJava(strJson, ContactListAddUserPojo.class);

        //send the request and get the response
        Response response = given(specification).body(expectedData).post("{1}");
        response.prettyPrint();

        // do assertion
        response.then().statusCode(201);
    }
}
