package interactions;

import base.BaseTest;
import constant.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static base.BaseTest.*;

public class WebInteraction implements Constants {
    WebDriver webDriver;

    public JavascriptExecutor jsExecutor;

    public WebInteraction(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean waitForElementToAppear(WebElement element, String elemDetails, long timeOutInSeconds) {
        boolean result;
        try{
            webDriver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch(Exception e) { return false; }
        finally{ webDriver.manage().timeouts().implicitlyWait(timeOutInSeconds,TimeUnit.SECONDS); }
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
            webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            result = true;
        } catch (Exception e) {
            result = false;
        } finally {
            webDriver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_LONG, TimeUnit.SECONDS);
        }
        return result;
    }

    public void selectInteractionsByValue(WebElement element, String value) throws InterruptedException {
        waitForElementToAppearAndClick(element);
        Select selectInteraction = new Select(element);
        selectInteraction.selectByVisibleText(value);
    }

    public void scrollTillElement(WebElement element) {
        jsExecutor = (JavascriptExecutor)webDriver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClickCheckBox(WebElement element) {
        jsExecutor = (JavascriptExecutor)webDriver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void arrowUpActions() {
        Actions act = new Actions(webDriver);
        act.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP).perform();
    }

    public boolean clickActions(WebElement element) {
        Actions act = new Actions(webDriver);
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_LONG);
            wait.until(ExpectedConditions.visibilityOf(element));
            act.moveToElement(element).click().perform();
            return true;
        } catch (Exception e) { return false; }
    }

    public void actionsForFrames(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_LONG);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    public void actionsForFrames(int index) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_LONG);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void actionsForFrames(String name) {
        WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT_LONG);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
    }
}
