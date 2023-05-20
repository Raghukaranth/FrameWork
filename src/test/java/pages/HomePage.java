package pages;

import interactions.Constants;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class HomePage extends Page {

    @FindBy(id = "gh-cat")
    private WebElement drpdwn_select_Category;

    @FindBy(id = "gh-btn")
    private WebElement btn_search;

    public HomePage() throws IOException, ParseException {
    }

    @Override
    public HomePage waitForPageToLoad() {
        webInteraction.waitForElementToAppear(img_logo);
        return this;
    }

    public HomePage selectPhoneAndAccessoriesCategory() throws InterruptedException {
        webInteraction.selectInteractionsByValue(drpdwn_select_Category, Constants.CELLPHONE_ACCESSORIES);
        return this;
    }

    public CategoryPage clickOnSearchButton() throws IOException, ParseException, InterruptedException {
        webInteraction.waitForElementToAppearAndClick(btn_search);
        return new CategoryPage();
    }

    public HomePage selectComputerTabsAndNetworkCategory() throws InterruptedException {
        webInteraction.selectInteractionsByValue(drpdwn_select_Category, Constants.COMPUTER_TAB_AND_NETWORKS);
        return this;
    }
}
