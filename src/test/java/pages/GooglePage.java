package pages;

import base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class GooglePage extends Page {
    @FindBy(xpath = "//textarea[@title = 'Search']")
    private WebElement searchBarTitle;

    @FindBy(xpath = "//span[text()='AI Mode']")
    private WebElement aiButton;

    @Override
    public GooglePage waitForPageToLoad() {
        Assert.assertTrue(webInteractions.waitForElementToAppear(searchBarTitle));
        return this;
    }

    public GooglePage EnterText(String text) {
        webInteractions.enterText(searchBarTitle, text);
        return this;
    }

    public GooglePage ClickOnAIButton() {
        Assert.assertTrue(webInteractions.waitForElementToAppearAndClick(aiButton));
        return this;
    }


}
