package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.apiDemos.HomePageApiDemos;

public class ApiDemos extends BaseTest {
    @Test
    public void apiDemosTest() {
        HomePageApiDemos homePageApiDemos = new HomePageApiDemos();
        homePageApiDemos.clickOnViews();
    }
}
