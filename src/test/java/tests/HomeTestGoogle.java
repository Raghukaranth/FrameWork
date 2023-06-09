package tests;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.google.HomePageGoogle;
import pages.zomato.HomePageZomato;

import java.io.IOException;

public class HomeTestGoogle extends BaseTest {
    @Test
    public void verifyYouTubePageFromFrame() throws IOException, ParseException {
        HomePageGoogle homePageGoogle = new HomePageGoogle();
        homePageGoogle.clickOnApps()
                .clickOnYouTube();

    }
}
