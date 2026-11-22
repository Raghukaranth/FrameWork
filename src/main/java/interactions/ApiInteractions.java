package interactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiInteractions {
    public Response get(String endpoint) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    public Response post(String endpoint, Object payload) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
}
