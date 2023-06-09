package pages.zomato;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import pages.Page;

import java.io.IOException;
import java.util.List;

public class CategoryPageZomato extends Page {

    @AndroidFindBy(id = "secondary_action")
    private WebElement btn_dontSwitch;

    @AndroidFindBy(id = "text_view_title")
    private List<WebElement> btn_addItem;

    @AndroidFindBy(id = "button")
    private WebElement btn_add;

    public CategoryPageZomato() throws IOException, ParseException {
        super();
    }


    public CategoryPageZomato addFood() {
        mobileInteraction.waitForElementToAppearAndClick(btn_addItem.get(0));
        mobileInteraction.waitForElementToAppearAndClick(btn_add);
        mobileInteraction.waitForElementToAppearAndClick(btn_addItem.get(1));
        mobileInteraction.tapByCoordinates(804, 2204, 5);
        return this;
    }
}