package base;

import constants.ConfigProperty;
import constants.DriverClass;
import interactions.MobileInteraction;
import interactions.WebInteractions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.net.MalformedURLException;

public abstract class Page {

    protected final WebDriver webDriver;
    protected final AppiumDriver appiumDriver;
    protected WebInteractions webInteractions;
    protected MobileInteraction mobileInteraction;

    public Page() {
        if ("mobile".equals(ConfigProperty.PLATFORM)) {
            this.appiumDriver = DriverClass.getMobileDriver(ConfigProperty.PLATFORM);
            this.webDriver = null;

            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
            mobileInteraction = new MobileInteraction(appiumDriver);
        } else {
            this.appiumDriver = null;
            this.webDriver = DriverClass.getWebDriver(ConfigProperty.BROWSER);

            PageFactory.initElements(webDriver, this);
            webInteractions = new WebInteractions(webDriver);
            waitForPageToLoad();
        }
    }

    public abstract <T extends Page> T waitForPageToLoad();
}