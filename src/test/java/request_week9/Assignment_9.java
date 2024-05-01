package request_week9;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Assignment_9 {

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
    @Test
    public void getRequestTest(){
        //send the request and get the response
        Response response = given().get("https://automationexercise.com/api/productsList");

        //print
        JsonPath jsonPath = response.jsonPath();
        response.jsonPath().prettyPrint();

        //assertion
        List<String> actualData = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}");
        assertEquals(actualData.size(),12);
    }


}
