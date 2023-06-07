package interactions;

import constant.Constants;
import driverManager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class MobileInteraction implements Constants {

    public AppiumDriver appiumDriver;

    public MobileInteraction(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public void waitForPageToLoad() { appiumDriver.manage().timeouts().implicitlyWait(TIMEOUT_LONG, TimeUnit.SECONDS); }

    public boolean waitForElementToAppear(WebElement element, String elemDetails, long timeOutInSeconds) {
        boolean result;
        try{
            appiumDriver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(appiumDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch(Exception e) { return false; }
        finally{ appiumDriver.manage().timeouts().implicitlyWait(timeOutInSeconds,TimeUnit.SECONDS); }
        return result;
    }

    public boolean waitForElementToAppear(WebElement element) {
        return waitForElementToAppear(element, "Element details not provided in method");
    }

    public boolean waitForElementToAppear(WebElement element, String elementDetails) {
        return waitForElementToAppear(element, elementDetails, 10);
    }

    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public boolean waitForElementToAppearAndClick(WebElement element) {
        if (element == null)
            return false;
        return waitForElementToAppearAndClick(element, "Element details not provided");
    }

    public boolean waitForElementToAppearAndClick(WebElement element, String elemDetails) {
        return waitForElementToAppearAndClick(element, elemDetails, 10);
    }

    public boolean waitForElementToAppearAndClick(WebElement element, String elemDetails, long timeOut) {
        boolean result;
        try {
            appiumDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(appiumDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            result = true;
        } catch (Exception e) {
            result = false;
        } finally {
            appiumDriver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_LONG, TimeUnit.SECONDS);
        }
        return result;
    }

    public void tapByCoordinates(int x, int y, long seconds) {
        new TouchAction((PerformsTouchActions) appiumDriver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }
}
