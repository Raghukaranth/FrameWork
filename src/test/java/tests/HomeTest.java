package tests;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePageZomato;

import java.io.IOException;
import java.sql.SQLException;

public class HomeTest extends BaseTest {
    @Test
    public void bookFoodZomato() throws IOException, ParseException {
        HomePageZomato homePageZomato = new HomePageZomato();
        homePageZomato.clickOnSearchBox()
                .enterRestaurant()
                .addFood();
    }
}
