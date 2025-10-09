package interactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class    RestUtils {
    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    public static Response postRequest(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(endpoint);
    }

    public static Response deleteRequest(String endpoint, Object id) {
        return given()
                .pathParams("id", id)
                .delete(endpoint);
    }
}
