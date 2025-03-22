package interactions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileInteractions implements Constants {
    AppiumDriver appiumDriver;

    public MobileInteractions(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
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
            WebDriverWait wait = new WebDriverWait(appiumDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public void enterText(WebElement element, String value) {
        waitForElementToAppearAndClick(element);
        element.sendKeys(value);
    }

    public boolean waitForElementToAppear(WebElement element, String elemDetails, long timeOutInSeconds) {
        boolean result;

        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean waitForElementToAppear(WebElement element) {
        return waitForElementToAppear(element, "Element details not provided in method");
    }

    public boolean waitForElementToAppear(WebElement element, String elementDetails) {
        return waitForElementToAppear(element, elementDetails, 10);
    }
}
