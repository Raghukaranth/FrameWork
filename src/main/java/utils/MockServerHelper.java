package utils;

import io.restassured.http.ContentType;
import rest.RestRequest;
import routes.ServerRoutes;

public class MockServerHelper {
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
}
