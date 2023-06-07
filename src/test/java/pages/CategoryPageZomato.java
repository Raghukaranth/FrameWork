package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class CategoryPageZomato extends Page {

    @FindBy(id = "secondary_action")
    private WebElement btn_dontSwitch;

    @FindBy(id = "text_view_title")
    private List<WebElement> btn_addItem;

    @FindBy(id = "button")
    private WebElement btn_add;


    public CategoryPageZomato() throws IOException, ParseException {
    }

    @Override
    public CategoryPageZomato waitForPageToLoad() {
        Assert.assertTrue(mobileInteraction.waitForElementToAppearAndClick(btn_dontSwitch));
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
