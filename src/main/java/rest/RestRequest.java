package rest;
import com.github.dzieciou.testing.curl.CurlLoggingRestAssuredConfigFactory;
import com.github.dzieciou.testing.curl.Options;
import com.github.dzieciou.testing.curl.Platform;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import routes.Route;
import utils.file.FileUtils;


@Slf4j
public class RestRequest {
    private Object requestBody;
    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification requestSpecification;
    private Response response;

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public RestRequest setQueryParam(String parameter, String value) {
        requestSpecification.queryParam(parameter, value);
        return this;
    }

    public RestRequest bodyContains(String key, String value) {
        if (requestBody == null)
            requestBody = "{}";
        JSONObject requestBody = new JSONObject(this.requestBody.toString());
        this.requestBody = requestBody.put(key, value);
        return this;
    }

    public RestRequest createRequest() {
        Options options = Options.builder().targetPlatform(Platform.UNIX)
                .updateCurl(curl -> curl.removeHeader("Host").removeHeader("User-Agent").removeHeader("Connection")
                        .setCompressed(false).setInsecure(false).setVerbose(false))
                .useShortForm().build();
        RestAssuredConfig config = CurlLoggingRestAssuredConfigFactory.createConfig(options);
        this.requestSpecification = RestAssured.given().config(config);
        return this;
    }

    public RestRequest setHeader(String key, String value) {
        requestSpecification.header(key, value);
        return this;
    }
    public RestRequest setContentType(ContentType contentType) {
        requestSpecification.contentType(contentType);
        return this;
    }

    public RestRequest setAuthorizationHeader(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
        return this;
    }

    public RestRequest bodyContainsJsonArray(String key, String value) {
        if (requestBody == null)
            requestBody = "{}";
        JSONObject requestBody = new JSONObject(this.requestBody.toString());
        this.requestBody = requestBody.put(key, new JSONArray(value));
        return this;
    }


    public RestResponse sendToRoutes(Route route) {
        RestResponse restResponse = new RestResponse();
        if (requestBody != null) {
            requestSpecification.body(requestBody instanceof JSONObject ? requestBody.toString() : requestBody);
            //log.info("Request Body: " + requestBody.toString());
        }
        Response response = requestSpecification.baseUri(route.getUri()).request(route.getHttpMethod());
        log.debug("Response Status Code: " + response.getStatusCode());
        //log.debug("Response Body: " + response.body().asString().replace("\n", ""));
        restResponse.setResponse(response);
        return restResponse;
    }
}
