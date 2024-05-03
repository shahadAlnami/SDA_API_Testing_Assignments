package request_week10.Assignment_13;

import Pojos.ContactListAddUserPojo;
import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R02_loginUser extends ContactListBaseUrl {

    /**
     * Write an automation test that will create a 'user' then read, update and delete the created user
     * using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.
     */

    public static String ttoken;

    @Test
    public void loginUserTest() {

        //set the url
        specification.pathParams("1", "users", "2", "login");

        // set the expected data
        String strJson = """
                {
                    "email": "sha@fake.com",
                    "password": "myPassword"
                }
                        """;

        ContactListAddUserPojo expectedData = convertJsonToJava(strJson, ContactListAddUserPojo.class);

        //send the request and get the response
        Response response = given(specification).body(expectedData).post("{1}/{2}");
        response.prettyPrint();

        // do assertion
        ttoken = response.jsonPath().getString("token");
        response.then().statusCode(200);
    }
}
