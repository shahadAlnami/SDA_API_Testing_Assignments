package request;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Assignment_6 {
     /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void requestTest() {

        // Set the URL
        String url = "https://reqres.in/api/users";

        // Set the expected data (Payload) --> Prepare it as Map
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");

        // Send POST Request and get the response
        Response response = given()
                .headers("Content-Type", "application/json")
                .body(expectedData)
                .post(url);

        // Verify the status code is 201
        response.then().statusCode(201);

        // Verify the response body using JsonPath
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("name"), expectedData.get("name"));
        Assert.assertEquals(jsonPath.getString("job"), expectedData.get("job"));
        Assert.assertNotNull(jsonPath.getString("id"));
        Assert.assertNotNull(jsonPath.getString("createdAt"));

    }
}
