package pages.google;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.Page;

import java.io.IOException;

public class HomePageGoogle extends Page {
    @FindBy(xpath = "//a[@aria-label='Google apps']")
    private WebElement btn_googleApps;

    @FindBy(xpath = "//span[normalize-space()='YouTube']")
    private WebElement btn_youTubeApp;

    @FindBy(xpath = "//iframe[@name='app']")
    private WebElement frame_apps;

    @Override
    public HomePageGoogle waitForPageToLoad() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(btn_googleApps));
        return this;
    }

    public HomePageGoogle clickOnApps() {
        webInteraction.waitForElementToAppearAndClick(btn_googleApps);
        return this;
    }

    public HomePageYouTube clickOnYouTube() {
        webInteraction.actionsForFrames(frame_apps);
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_youTubeApp));
        return new HomePageYouTube();
    }
}
