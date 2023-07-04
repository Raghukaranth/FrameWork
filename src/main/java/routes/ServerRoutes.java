package routes;

import io.restassured.http.Method;

public final class ServerRoutes {
    public static final String SERVER_BASE_URL = "https://reqres.in";
    public static final Route API_GET = Route.builder().httpMethod(Method.GET).uri(getServerUrl()).build();
    public static final Route API_CREATE = Route.builder().httpMethod(Method.POST).uri(getServerUrl() + "/api/users").build();
    public static final Route API_PUT = Route.builder().httpMethod(Method.PUT).uri(getServerUrl() + "/api/users" + "/2").build();
    public static final Route API_PATCH = Route.builder().httpMethod(Method.PATCH).uri(getServerUrl() + "/api/users" + "/2").build();
    public static final Route API_DELETE = Route.builder().httpMethod(Method.DELETE).uri(getServerUrl() + "/api/users" + "/2").build();
    public static final Route SET_TRANSFORMATION = Route.builder().httpMethod(Method.POST).uri(getServerUrl() + "/setTransformation").build();
    private static String getServerUrl() {
        return SERVER_BASE_URL;
    }
}
