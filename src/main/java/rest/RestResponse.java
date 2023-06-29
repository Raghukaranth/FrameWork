package rest;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
@Slf4j
public class RestResponse {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


    public void validateResponseCode(int responseCode) {
        Assert.assertEquals(response.statusCode(), responseCode, "Failed to validate status code");
    }
}
