package tests;

import base.BaseClass;
import interactions.ApiInteractions;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends BaseClass {

    ApiInteractions api = new ApiInteractions();

    @Test(groups = "api")
    public void verifyGetUsers() {
        Response response = api.get("/api/users?page=2");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
