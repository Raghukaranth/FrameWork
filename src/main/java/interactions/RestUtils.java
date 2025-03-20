package interactions;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RestUtils {
    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    public static Response postRequest(String endpoint, Object body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }
}
