package interactions;

import com.google.common.collect.ImmutableMap;
import constant.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
@Slf4j
public class MobileInteraction implements Constants {

    AppiumDriver appiumDriver;

    public MobileInteraction(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public boolean waitForElementToAppear(WebElement element, String elemDetails, long timeOutInSeconds) {
        boolean result;
        try{

            appiumDriver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(TIMEOUT_LONG));
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
            System.out.println("try");
        } catch(Exception e) {
            System.out.println("catch");
            return false;
        }
        finally{
            appiumDriver.manage().timeouts().implicitlyWait(timeOutInSeconds,TimeUnit.SECONDS);
            System.out.println("finally");
        }
          return result;
    }

    public boolean waitForElementToAppear(WebElement element) {
        return waitForElementToAppear(element, "Element details not provided in method");
    }

    public boolean waitForElementToAppear(WebElement element, String elementDetails) {
        return waitForElementToAppear(element, elementDetails, 10);
    }

    public void enterText(WebElement element, String value) {
        waitForElementToAppearAndClick(element);
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
            WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(TIMEOUT_LONG));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            result = true;
        } catch (Exception e) {
            result = false;
        } finally {
            appiumDriver.manage().timeouts().implicitlyWait(TIMEOUT_LONG, TimeUnit.SECONDS);
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

    public void swipe(int startX, int startY, int endX, int endY, int miliseconds) {
        new TouchAction((PerformsTouchActions) appiumDriver)
                .press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(miliseconds))).moveTo(point(endX, endY))
                .release().perform();
    }

    public void swipeUp(int noOfSwipes, int milliSeconds) {
        Dimension size = appiumDriver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int x = (int) (size.width * 0.5);
        for (int i = 1; i <= noOfSwipes; i++) {
            swipe(x, startY, x, endY, milliSeconds);
            log.info("Swiping up with the coordinates : [" + x + ", " + startY + "] [" + x + ", " + endY + "]");
        }
    }

    public void swipeUpGesture(int left,int top,int width, int height) {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("left", left);
        builder.put("top", top);
        builder.put("width", width);
        builder.put("height", height);
        builder.put("direction", "up");
        builder.put("percent", 0.75);

        ImmutableMap<String, Object> parameters = builder.build();
        ((JavascriptExecutor) appiumDriver).executeScript("mobile: swipeGesture", parameters);
    }
}
