package interactions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FilePath;

import java.util.HashMap;
import java.util.Map;

public class MobileInteraction {
    AppiumDriver appiumDriver;

    public MobileInteraction(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public boolean waitForElementToAppear(WebElement element, String elemDetails, long timeOut) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    public boolean waitForElementToAppear(WebElement element) {
        return waitForElementToAppear(element, "Element details not provided in method");
    }

    public boolean waitForElementToAppear(WebElement element, String elementDetails) {
        return waitForElementToAppear(element, elementDetails, 10);
    }

    public boolean waitForElementToAppearAndClick(WebElement element, String elementDetails, long timeOut) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(appiumDriver, timeOut);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementToAppearAndClick(WebElement element) {
        if (element == null)
            return false;
        return waitForElementToAppearAndClick(element, "Element details not provided");
    }

    public boolean waitForElementToAppearAndClick(WebElement element, String elemDetails) {
        return waitForElementToAppearAndClick(element, elemDetails, 10);
    }

    public void tapByCoordinates(String x, String y) {
        Map<String, String> coordinates = new HashMap<>();
        coordinates.put("x", x);
        coordinates.put("y", y);
        appiumDriver.executeScript("mobile: clickGesture", coordinates);
    }


}
