package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.api.HomePageResReq;

import static io.restassured.RestAssured.given;

public class ApiTestRMG extends BaseTest {

    @Test
    public void testApiPojo() {
        HomePageResReq homePageResReq = new HomePageResReq();
        homePageResReq.validateLogo();
    }
}
