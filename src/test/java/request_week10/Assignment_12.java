package request_week10;

import base_urls.DummyApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Assignment_12 extends DummyApiBaseUrl {
    /**
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */

    @Test
    public void Assignment12Test(){

        //set up the url
        specification.pathParams("1","api","2","v1","3","employees");

        // send the request and get the response
        Response response = given(specification).get("{1}/{2}/{3}");

       // response.prettyPrint();
        assertEquals(response.statusCode(),200);

        List<Object> employees = response.jsonPath().getList("data");

        // Assert there are 24 employees
        response.then().body("data", hasSize(24));

        // Assert "Tiger Nixon" and "Garrett Winters" are among the employees
        response.then().body("data.employee_name", hasItems("Tiger Nixon","Garrett Winters"));

        // Find the greatest age
        int maxAge = response.then().extract().path("data.employee_age.max()");
        assertEquals(maxAge, 66);

        // Find the name of the lowest age
        String lowestAgeName = response.then().extract().path("data.min { it.employee_age }.employee_name");
        assertEquals(lowestAgeName, "Tatyana Fitzpatrick");

        // Calculate the total salary of all employees
        int totalSalary = response.then().extract().path("data.employee_salary.sum()");
        assertEquals(totalSalary, 6644770);

    }
}
