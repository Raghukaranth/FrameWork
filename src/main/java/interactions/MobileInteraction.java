package interactions;

import constant.Constants;
import io.appium.java_client.AppiumDriver;

import java.util.concurrent.TimeUnit;

public class MobileInteraction implements Constants {

    AppiumDriver appiumDriver;

    public MobileInteraction(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public void waitForPageToLoad() { appiumDriver.manage().timeouts().implicitlyWait(TIMEOUT_LONG, TimeUnit.SECONDS); }

}
