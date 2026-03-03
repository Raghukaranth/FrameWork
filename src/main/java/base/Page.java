package base;

import constants.ConfigProperty;
import interactions.MobileInteraction;
import interactions.WebInteractions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static base.BaseTest.appiumDriver;
import static base.BaseTest.webDriver;

public abstract class Page {
    ConfigProperty property = new ConfigProperty();
    protected WebInteractions webInteractions;
    protected MobileInteraction mobileInteraction;

    public Page () {
        if(ConfigProperty.PLATFORM.equals("mobile")) {
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
            mobileInteraction = new MobileInteraction(appiumDriver);
        } else {
            PageFactory.initElements(webDriver, this);
            webInteractions = new WebInteractions(webDriver);
            this.waitForPageToLoad();
        }
    }
    public abstract <T extends Page> T waitForPageToLoad();
}
