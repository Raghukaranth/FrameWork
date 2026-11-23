package interactions;

import constants.ConstFile;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

@Slf4j
public class WebInteractions extends BaseInteractions<WebDriver> {
    public WebInteractions(WebDriver driver) {
        super(driver);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void selectByVisibleText(WebDriverWait wait, WebElement dropdownElement, String visibleText) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectByValue(WebDriverWait wait, WebElement dropdownElement, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByIndex(WebDriverWait wait, WebElement dropdownElement, int index) {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(dropdownElement));
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectCustomOption(WebDriver driver, WebDriverWait wait, WebElement trigger, By optionsLocator, String optionText) {
        wait.until(ExpectedConditions.visibilityOf(trigger));
        wait.until(ExpectedConditions.elementToBeClickable(trigger)).click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsLocator));
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(optionText.trim())) {
                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
                return;
            }
        }
        throw new IllegalArgumentException("Option not found in dropdown: " + optionText);
    }

    public void switchToFrameByIndex(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        log.info("Switched to frame by index: {}", index);
    }

    public void switchToFrameByNameOrId(String nameOrId) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
        log.info("Switched to frame by name or ID: {}", nameOrId);
    }

    public void switchToFrameByLocator(By frameLocator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        log.info("Switched to frame by locator: {}", frameLocator);
    }

    public void switchToFrameByElement(WebElement frameElement) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
        log.info("Switched to frame by WebElement");
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        log.info("Switched back to default content");
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
        log.info("Switched back to parent frame");
    }
}
