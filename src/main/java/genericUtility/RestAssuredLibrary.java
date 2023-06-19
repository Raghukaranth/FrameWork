package genericUtility;

import io.restassured.response.Response;

public class RestAssuredLibrary {
    public String getJSONData(Response resp, String path)
    {
        return resp.jsonPath().get(path);
    }
}
