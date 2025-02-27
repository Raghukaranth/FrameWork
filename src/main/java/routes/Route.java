package routes;

import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Route {
    String uri;
    Method httpMethod;
}
