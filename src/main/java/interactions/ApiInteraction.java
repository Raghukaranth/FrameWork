package interactions;

import constant.ConfigProperty;
import constant.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;



import java.io.File;

import static io.restassured.RestAssured.*;
@Slf4j
public class ApiInteraction implements Constants {
    ApiInteraction apiInteraction;
    String getApi = "/projects/{pid}";

    public ApiInteraction(ApiInteraction apiInteraction) {
        this.apiInteraction = apiInteraction;
    }

    public Response callPostMethod() {
        baseURI = ConfigProperty.URL;


        File file = new File("./src/test/resources/data.json");

        Response response = given()
                .body(file)
                .contentType(ContentType.JSON)
                .when()
                .post("/addProject");
        return response;
    }

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
}
