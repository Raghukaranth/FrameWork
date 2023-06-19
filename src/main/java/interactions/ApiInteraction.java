package interactions;

import genericUtility.RestAssuredLibrary;
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
    public RestAssuredLibrary restAssuredLibrary = new RestAssuredLibrary();

    public ApiInteraction(ApiInteraction apiInteraction) {
        this.apiInteraction = apiInteraction;
    }

    public void createUserUsingAPI() {
        apiInteraction.apiCreateUser();
    }

    public void apiCreateUser() {
        baseURI = ConfigProperty.URL;


        File file = new File("./src/test/resources/data.json");

        given()
                .body(file)
                .contentType(ContentType.JSON)
                .when()
                .post("/addProject");
    }

    public void verifyResponseCode(Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }
    
    public Response callGetMethod(String pid) {
        Response response = given()
                .pathParam("pid", pid)
                .when().log().all()
                .get("/projects/{pid}");
        return response;
    }

}
