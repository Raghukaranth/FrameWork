package interactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiClient {
    private final String baseURI;
    private final String basePath;

    public ApiClient(String baseURI, String basePath) {
        this.baseURI = baseURI;
        this.basePath = basePath;
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
    }

    private RequestSpecification givenRequest() {
        return given().log().all();
    }

    public <T> T request(String httpMethod, String endpoint,
                         Map<String, Object> pathParams, Map<String, Object> queryParams,
                         Object requestBody, Class<T> responseType, int expectedStatus) {

        RequestSpecification request = givenRequest();

        // ✅ Path Parameters
        if (pathParams != null && !pathParams.isEmpty()) {
            request.pathParams(pathParams);
        }

        // ✅ Query Parameters
        if (queryParams != null && !queryParams.isEmpty()) {
            request.params(queryParams);
        }

        // ✅ Request Body + Content-Type
        if (requestBody != null) {
            request.contentType(ContentType.JSON).body(requestBody);
        }

        // 🔥 ALL HTTP METHODS SUPPORTED
        Response response = switch (httpMethod.toUpperCase()) {
            case "GET" -> request.when().get(endpoint);
            case "POST" -> request.when().post(endpoint);
            case "PUT" -> request.when().put(endpoint);
            case "PATCH" -> request.when().patch(endpoint);  // ✅ ADDED PATCH
            case "DELETE" -> request.when().delete(endpoint);
            default -> throw new IllegalArgumentException("Unsupported method: " + httpMethod);
        };

        return response.then()
                .log().all()
                .statusCode(expectedStatus)
                .extract()
                .as(responseType);
    }

}
