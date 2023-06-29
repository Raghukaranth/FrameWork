package interactions;

import constant.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;


import java.util.HashMap;

import static io.restassured.RestAssured.*;
@Slf4j
public class ApiInteraction implements Constants {
    ApiInteraction apiInteraction;
    String getApi = "/user";
    int id;

    public void verifyResponseCode(Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }
    
    public Response callGetMethod(String pid) {
        Response response = given()
                .pathParam("pid", pid)
                .when().log().all()
                .get(getApi);
        return response;
    }

    public Response callDeleteMethod(String pid) {
        Response response = given()
                .pathParam("pid", pid)
                .when().log().all()
                .delete(getApi);
        return  response;
    }

    public Response callUpdateMethod() {
        HashMap data=new HashMap();
        data.put("Name","Darshan");
        data.put("Job","Null");
        Response response = given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .put(baseURI + getApi + "/id");
        verifyResponseCode(response, 200);
        return response;
    }
}
