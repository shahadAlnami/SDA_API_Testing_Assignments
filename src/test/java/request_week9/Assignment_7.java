package request_week9;

import base_urls.SwaggerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Assignment_7 extends SwaggerBaseUrl {
    /*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

    @Test
    public void postRequestTest(){

        // set up the url
        specification.pathParams("first","user");

        //set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("id",2);
        expectedData.put("username","Sha37");
        expectedData.put("firstName","Shahad");
        expectedData.put("lastName","Alnami");
        expectedData.put("email","Shahad@gmail.com");
        expectedData.put("password","1234");
        expectedData.put("phone","05123456");
        expectedData.put("userStatus",3);

        //send the request and send the response
        Response response = given(specification).contentType(ContentType.JSON).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do Assertion
        Assert.assertEquals(response.statusCode(),200);
    }
}
