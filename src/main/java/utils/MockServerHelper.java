package utils;

import io.restassured.http.ContentType;
import rest.RestRequest;
import routes.ServerRoutes;
import utils.file.FileUtils;

public class MockServerHelper {
    private static String MOCK_PATH = "src/test/java/tests/";
    public static void getResponse() {
        new RestRequest()
                .createRequest()
                .setContentType(ContentType.JSON)
                .sendToRoutes(ServerRoutes.API_GET)
                .validateResponseCode(200);
    }
    public static void postRequest() {
        new RestRequest()
                .createRequest()
                .setContentType(ContentType.JSON)
                .sendToRoutes(ServerRoutes.API_CREATE)
                .validateResponseCode(201);
    }

    public static void putRequest() {
        new RestRequest()
                .createRequest()
                .setContentType(ContentType.JSON)
                .sendToRoutes(ServerRoutes.API_PUT)
                .validateResponseCode(200);
    }

    public static void patchRequest() {
        new RestRequest()
                .createRequest()
                .setContentType(ContentType.JSON)
                .sendToRoutes(ServerRoutes.API_PATCH)
                .validateResponseCode(200);
    }

    public static void deleteRequest() {
        new RestRequest()
                .createRequest()
                .setContentType(ContentType.JSON)
                .sendToRoutes(ServerRoutes.API_DELETE)
                .validateResponseCode(204);
    }

    public static void setTransformation(String deviceId, String transformationFilePath) {
        new RestRequest()
                .createRequest()
                .setContentType(ContentType.JSON)
                .bodyContains("deviceId", deviceId)
                .bodyContainsJsonArray("transformations", FileUtils.readFile(MOCK_PATH + transformationFilePath))
                .sendToRoutes(ServerRoutes.SET_TRANSFORMATION)
                .validateResponseCode(200);
    }
}
