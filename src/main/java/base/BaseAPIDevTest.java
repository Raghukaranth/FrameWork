package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPIDevTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://192.168.215.108:9090";
    }
}
