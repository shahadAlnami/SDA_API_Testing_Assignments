package request_week10.Assignment_14;

import Pojos.ContactListAddContactPojo;
import base_urls.ContactListBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R01_CreateContact extends ContactListBaseUrl {

    @Test
    public void CreateContact(){

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjM0ZTZiZDA2YzIwOTAwMTNjMjRkYTEiLCJpYXQiOjE3MTQ3NDM1MTZ9.jih80DoyGHMqmCMNRUX1JzW0lKI5O-fn6rzhB1oebLg";

        specification.pathParams("1","contacts");

        String strJson = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }
                """;

        ContactListAddContactPojo expectedData = convertJsonToJava(strJson, ContactListAddContactPojo.class);

        //send the request and get the response
        Response response = given(specification).header("Authorization", "Bearer " + token).body(expectedData).post("{1}");
        response.prettyPrint();

    }
}
