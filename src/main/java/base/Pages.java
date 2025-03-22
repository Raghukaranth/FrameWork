package base;

import interactions.MobileInteractions;
import org.openqa.selenium.support.PageFactory;

import static base.AndroidBaseDevTest.appiumDriver;

public abstract class Pages {
    public MobileInteractions mobileInteractions;

    public Pages() {
        PageFactory.initElements(appiumDriver, this);
        mobileInteractions = new MobileInteractions(appiumDriver);
    }
    public abstract <T extends Pages> T waitForPageToLoad();
}
