package pages.google;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.Page;

import java.io.IOException;

public class HomePageYouTube extends Page {
    @FindBy(xpath = "//div[@id='start']")
    private WebElement logo_YouTube;

    @Override
    public HomePageYouTube waitForPageToLoad() {
        validateYouTube();
        return this;
    }
    public HomePageYouTube validateYouTube() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(logo_YouTube));
        return this;
    }


}
