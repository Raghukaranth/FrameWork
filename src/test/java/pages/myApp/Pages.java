package pages.myApp;

import interactions.MobileInteractions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

import static base.BaseDevTest.appiumDriver;

public class Pages {
    MobileInteractions mobileInteractions;

    public Pages() {
        PageFactory.initElements(appiumDriver, this);
        mobileInteractions = new MobileInteractions(appiumDriver);
    }
}
