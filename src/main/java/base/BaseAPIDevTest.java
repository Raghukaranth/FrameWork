package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPIDevTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:9090";
    }
}
