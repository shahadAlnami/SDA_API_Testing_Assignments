package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class DummyApiBaseUrl {

    protected RequestSpecification specification;
    @BeforeMethod
    public void DummyApiBaseUrl(){
        specification = new RequestSpecBuilder()
                        .setBaseUri("https://dummy.restapiexample.com")
                        .build();
    }
}
