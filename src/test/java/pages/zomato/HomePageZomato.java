package pages.zomato;

import constant.Constants;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import base.Page;

import java.io.IOException;
import java.util.List;

public class HomePageZomato extends Page {
    @AndroidFindBy(id = "search_bar_view_flipper")
    private WebElement box_searchBox;

    @AndroidFindBy(id = "profile_image")
    private WebElement btn_profile;

    @AndroidFindBy(id = "auto_suggest_animated_container")
    private List<WebElement> list_FoodStore;


    @AndroidFindBy(id = "edittext")
    public WebElement txt_searchRestaurant;

    public HomePageZomato() throws IOException, ParseException {
        super();
    }


    public HomePageZomato clickOnSearchBox() {
        mobileInteraction.waitForElementToAppearAndClick(box_searchBox);
        return this;
    }

    public CategoryPageZomato enterRestaurant() throws IOException, ParseException {
        mobileInteraction.enterText(txt_searchRestaurant, Constants.Restaurant);
        mobileInteraction.tapByCoordinates(513, 513, 5);
        return new CategoryPageZomato();
    }
}
