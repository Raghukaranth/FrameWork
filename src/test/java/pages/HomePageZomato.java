package pages;

import constant.Constants;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class HomePageZomato extends Page {
    @FindBy(id = "search_bar_view_flipper")
    private WebElement box_searchBox;

    @FindBy(id = "profile_image")
    private WebElement btn_profile;

    @FindBy(id = "auto_suggest_animated_container")
    private List<WebElement> list_FoodStore;


    @FindBy(id = "edittext")
    public WebElement txt_searchRestaurant;


    public HomePageZomato() throws IOException, ParseException {
    }

    @Override
    public HomePageZomato waitForPageToLoad() {
        mobileInteraction.waitForElementToAppear(btn_profile);
        return this;
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
