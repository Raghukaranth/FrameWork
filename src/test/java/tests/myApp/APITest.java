package tests.myApp;

import base.BaseAPIDevTest;
import interactions.RestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APITest extends BaseAPIDevTest {
    @Test
    public void signUpResponse() {
        String newUser = """
                {
                    "name": "Raghavendra"
                }
                """;
        Response response = RestUtils.postRequest("/loginUser/signup", newUser);
        response.then ().statusCode(201);
    }

    @Test
    public void testGetResponse() {
        Response respose = RestUtils.getRequest("/loginUser/login/" + 1);
        respose.then().statusCode(200);
    }
}
