package interactions;

import constants.ConstFile;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Slf4j
public abstract class BaseInteractions<T extends WebDriver> {
    protected final T driver;
    protected final WebDriverWait wait;

    protected BaseInteractions(T driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConstFile.Default_timeout));
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(visibleElement.isDisplayed(), "Element is not displayed");
    }

    public void waitForElementToBeClicked(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            log.info("Successfully clicked on target element");
        } catch (Exception e) {
            throw new ElementClickInterceptedException("Element was not clickable in the current context", e);
        }
    }
}
