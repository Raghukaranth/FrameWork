package tests;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.zomato.HomePageZomato;

import java.io.IOException;

public class ZomatoTest extends BaseTest {
    @Test
    public void bookFoodZomato() {
        HomePageZomato homePageZomato = new HomePageZomato();
        homePageZomato.clickOnSearchBox()
                .enterRestaurant()
                .addFood();
    }
}
