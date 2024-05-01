package request_week9;

import base_urls.SwaggerBaseUrl;
import expectedData.PetCategoryModel;
import expectedData.PetModel;
import expectedData.PetTagsModel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Assignment_10 extends SwaggerBaseUrl {
    /**
     * Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
     (All actions must be done on same pet)
     (Use Pojo)
     */

    @Test
    public void pojoTest(){

        // set up the Url
        specification.pathParams("1","pet");

        //set the expected data
        PetCategoryModel petCategoryModel = new PetCategoryModel(3,"cat");
        PetTagsModel petTagsModel = new PetTagsModel(7,"small cat");
        List<PetTagsModel> tagsModelList = new ArrayList<>();
        tagsModelList.add(petTagsModel);
        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("something");
        PetModel petModel = new PetModel(2007,petCategoryModel,"Lola",photoUrls,tagsModelList,"available");

        //send the request and get the response

        //1. Post
        Response postResponse = given(specification).contentType("application/json").accept(ContentType.JSON).body(petModel).post("/{1}");
        postResponse.then().statusCode(200);
        //response.prettyPrint();

        /**************************************************************************/

        //2. Put
        PetModel petModel2 = new PetModel(2007,petCategoryModel,"Lola",photoUrls,tagsModelList,"sold");
        Response putResponse = given(specification).contentType("application/json").accept(ContentType.JSON).body(petModel2).put("/{1}");
        putResponse.then().statusCode(200);
        //putResponse.prettyPrint();

        /**************************************************************************/

        //3. Get
        specification.pathParams("1","pet","2","2007");
        Response getResponse = given(specification).accept(ContentType.JSON).get("{1}/{2}");
        getResponse.then().statusCode(200);
        //grtResponse.prettyPrint();

        // Do Assertions
        JsonPath jsonPath = getResponse.jsonPath();
        List<String> actualPhotoUrls = jsonPath.getList("photoUrls");
        List<String> actualTags = jsonPath.getList("tags.name");
        List<String> expectedTags = tagsModelList.stream().map(PetTagsModel::getName).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("id"),petModel2.getId());
        softAssert.assertEquals(jsonPath.getInt("category.id"), petCategoryModel.getId());
        softAssert.assertEquals(jsonPath.getString("category.name"), petCategoryModel.getName());
        softAssert.assertEquals(jsonPath.getString("name"),petModel2.getName());
        softAssert.assertEquals(actualPhotoUrls, photoUrls );
        softAssert.assertEquals(actualTags, expectedTags);
        softAssert.assertEquals(jsonPath.getString("status"), petModel2.getStatus());
        softAssert.assertAll();

        /**************************************************************************/

        //4. Delete
        Response deleteResponse = given(specification).accept(ContentType.JSON).delete("{1}/{2}");
        deleteResponse.then().statusCode(200);



    }
}
