package request;

import base_urls.SwaggerBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Assignment_8 extends SwaggerBaseUrl {
    /** Using the https://petstore.swagger.io/ document,
     * write an automation test that finds the number of "pets" with the status "available"
     * https://petstore.swagger.io/v2/pet/findByStatus?status=available'
     * and asserts that there are more than 100.*/

    @Test
    public void Test(){
        // srt up the url\
        specification.pathParams("1","pet","2","findByStatus","3","status","4","available");

        // send request and get response
        Response response = given(specification).get("{1}/{2}?{3}={4}");

        // Do Assertion
        List<String> actualData = response.as(List.class);
        Assert.assertTrue(actualData.size()>100);
    }
}
