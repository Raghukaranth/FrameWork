package interactions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Direction;
import utils.FilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
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

    public void swipeGesture(int left, int top, int width, int height, Direction direction, double percent) {
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: swipeGesture",
                ImmutableMap.<String, Object>builder()
                        .put("left", left)
                        .put("top", top)
                        .put("width", width)
                        .put("height", height)
                        .put("direction", direction.name().toLowerCase())
                        .put("percent", percent)
                        .build()
        );
    }

    public void switchToWeb() {
        Set<String> contexts = appiumDriver.getContextHandles();

        for(String context : contexts) {
            if(!"NATIVE_APP".equals(context)) {
                appiumDriver.context(context);
                log.info("switching to web view");
                return;
            }
        }
        throw new RuntimeException("No WebView found");
    }

    public String  getCurrentContext() {
        return appiumDriver.getContext();
    }

    public void switchToNative() {
        appiumDriver.context("NATIVE_APP");
        log.info("Switched to Native View");
    }
}
