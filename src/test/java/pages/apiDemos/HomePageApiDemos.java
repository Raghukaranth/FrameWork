package pages.apiDemos;

import base.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageApiDemos extends Page {
    @FindBy(id = "Views")
    private WebElement btn_View;


    public HomePageApiDemos clickOnViews() {
        Assert.assertTrue(mobileInteraction.waitForElementToAppearAndClick(btn_View));
        mobileInteraction.swipeUpGesture(0, 100, 10, 10);
        return this;
    }
}
