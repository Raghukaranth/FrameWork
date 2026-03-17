package interactions;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class WebInteractions {
    WebDriver webDriver;
    public JavascriptExecutor jsExecutor;

    public WebInteractions(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean waitForElementToAppear(WebElement element, String eleDetails, long timeOutInSeconds) {
        boolean result;
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementToAppear(WebElement element) {
        return waitForElementToAppear(element, "Element details not provided in method");
    }

    public boolean waitForElementToAppear(WebElement element, String elementDetails) {
        return waitForElementToAppear(element, elementDetails, 10);
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public boolean waitForElementToAppearAndClick(WebElement element, String elemDetails, long timeOut) {
        boolean result;

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
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

    public boolean waitForElementToAppearToClickOrActionsClick(WebElement element, String elemDetails, long timeOut) {
        boolean result = false;
        try {
            waitForElementToAppearAndClick(element, elemDetails, timeOut);
        } catch (ElementClickInterceptedException e) {
            Actions actions = new Actions(webDriver);
            waitForElementToAppear(element);
            actions.moveToElement(element).pause(timeOut).click().perform();
            return true;
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    public void switchWindow() {
        Set<String> allWindows = webDriver.getWindowHandles();

        for(String window : allWindows)
            webDriver.switchTo().window(window);
    }

    public void switchToFrame(WebDriver driver, Object frameIdentifier) {
        // Define a Map that stores how to handle each Class type
        Map<Class<?>, Consumer<Object>> frameActions = new HashMap<>();

        frameActions.put(Integer.class, index -> driver.switchTo().frame((Integer) index));
        frameActions.put(String.class, attributes -> driver.switchTo().frame((String) attributes));
        frameActions.put(WebElement.class, element -> driver.switchTo().frame((WebElement) element));
        // Note: Use RemoteWebElement or WebElement.class depending on your implementation

        Consumer<Object> action = frameActions.get(frameIdentifier.getClass());

        if (action != null) {
            action.accept(frameIdentifier);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + frameIdentifier.getClass());
        }
    }

    public void selectFromDropDown(WebElement element, String strategy, Object value) {
        Select select = new Select(element);

        // Map the strategy name to the actual Select method logic
        Map<String, Consumer<Object>> selectionMap = new HashMap<>();

        selectionMap.put("index", val -> select.selectByIndex((Integer) val));
        selectionMap.put("value", val -> select.selectByValue((String) val));
        selectionMap.put("text",  val -> select.selectByVisibleText((String) val));

        if (selectionMap.containsKey(strategy.toLowerCase())) {
            selectionMap.get(strategy.toLowerCase()).accept(value);
        } else {
            throw new IllegalArgumentException("Invalid strategy! Use: index, value, or text");
        }
    }
}