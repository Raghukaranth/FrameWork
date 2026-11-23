package interactions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Map;

@Slf4j
public class ApiInteractions {

    // --- Base Request Builder ---

    private RequestSpecification baseRequest() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().ifValidationFails();
    }

    private RequestSpecification withHeaders(RequestSpecification spec, Map<String, String> headers) {
        if (headers != null && !headers.isEmpty()) {
            spec.headers(headers);
        }
        return spec;
    }

    // --- GET ---

    public Response get(String endpoint) {
        log.info("GET {}", endpoint);
        return baseRequest()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response get(String endpoint, Map<String, ?> queryParams, Map<String, String> headers) {
        log.info("GET {} with queryParams={}", endpoint, queryParams);
        RequestSpecification spec = withHeaders(baseRequest(), headers);
        if (queryParams != null && !queryParams.isEmpty()) {
            spec.queryParams(queryParams);
        }
        return spec.when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response getByPathParam(String endpoint, String paramName, Object paramValue, Map<String, String> headers) {
        log.info("GET {} with {}={}", endpoint, paramName, paramValue);
        return withHeaders(baseRequest(), headers)
                .pathParam(paramName, paramValue)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    // --- POST ---

    public Response post(String endpoint, Object payload) {
        log.info("POST {}", endpoint);
        return baseRequest()
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response post(String endpoint, Object payload, Map<String, String> headers) {
        log.info("POST {} with custom headers", endpoint);
        return withHeaders(baseRequest(), headers)
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response postFormUrlEncoded(String endpoint, Map<String, ?> formParams, Map<String, String> headers) {
        log.info("POST form data to {}", endpoint);
        return withHeaders(RestAssured.given().contentType(ContentType.URLENC), headers)
                .formParams(formParams)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response postMultipart(String endpoint, String controlName, File file, Map<String, ?> formParams, Map<String, String> headers) {
        log.info("POST multipart file {} to {}", file.getName(), endpoint);
        RequestSpecification spec = withHeaders(RestAssured.given(), headers)
                .multiPart(controlName, file);
        if (formParams != null && !formParams.isEmpty()) {
            spec.formParams(formParams);
        }
        return spec.when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    // --- PUT ---

    public Response put(String endpoint, Object payload) {
        log.info("PUT {}", endpoint);
        return baseRequest()
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response put(String endpoint, Object payload, Map<String, String> headers) {
        log.info("PUT {} with custom headers", endpoint);
        return withHeaders(baseRequest(), headers)
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    // --- PATCH ---

    public Response patch(String endpoint, Object payload) {
        log.info("PATCH {}", endpoint);
        return baseRequest()
                .body(payload)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response patch(String endpoint, Object payload, Map<String, String> headers) {
        log.info("PATCH {} with custom headers", endpoint);
        return withHeaders(baseRequest(), headers)
                .body(payload)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    // --- DELETE ---

    public Response delete(String endpoint) {
        log.info("DELETE {}", endpoint);
        return baseRequest()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response delete(String endpoint, Map<String, String> headers) {
        log.info("DELETE {} with custom headers", endpoint);
        return withHeaders(baseRequest(), headers)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response deleteWithBody(String endpoint, Object payload, Map<String, String> headers) {
        log.info("DELETE {} with payload", endpoint);
        return withHeaders(baseRequest(), headers)
                .body(payload)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    // --- HEAD & OPTIONS ---

    public Response head(String endpoint, Map<String, String> headers) {
        log.info("HEAD {}", endpoint);
        return withHeaders(baseRequest(), headers)
                .when()
                .head(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response options(String endpoint, Map<String, String> headers) {
        log.info("OPTIONS {}", endpoint);
        return withHeaders(baseRequest(), headers)
                .when()
                .options(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response getWithBearerToken(String endpoint, String token) {
        return baseRequest()
                .auth().oauth2(token)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response getWithBasicAuth(String endpoint, String username, String password) {
        return baseRequest()
                .auth().preemptive().basic(username, password)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public String getJsonValue(Response response, String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

    public <T> T deserialize(Response response, Class<T> targetClass) {
        return response.as(targetClass);
    }
}