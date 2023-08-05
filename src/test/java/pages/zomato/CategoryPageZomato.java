package pages.zomato;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import base.Page;
import pages.apiDemos.HomePageApiDemos;

import java.io.IOException;
import java.util.List;

public class CategoryPageZomato extends Page {

    @AndroidFindBy(id = "secondary_action")
    private WebElement btn_dontSwitch;

    @AndroidFindBy(id = "text_view_title")
    private List<WebElement> btn_addItem;

    @AndroidFindBy(id = "button")
    private WebElement btn_add;

    @Override
    public CategoryPageZomato waitForPageToLoad() {
        org.testng.Assert.assertTrue(webInteraction.waitForElementToAppear(btn_dontSwitch));
        return this;
    }

    public CategoryPageZomato addFood() {
        mobileInteraction.waitForElementToAppearAndClick(btn_addItem.get(0));
        mobileInteraction.waitForElementToAppearAndClick(btn_add);
        mobileInteraction.waitForElementToAppearAndClick(btn_addItem.get(1));
        mobileInteraction.tapByCoordinates(804, 2204, 5);
        return this;
    }
}
