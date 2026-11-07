package interactions;

import base.Page;
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
public class WebInteractions {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebInteractions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConstFile.Default_timeout));
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed(), "element is displayed");
    }

    public void waitForElementToBeClicked(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            log.info("Clicked on Element");
        } catch (Exception e) {
            throw new ElementClickInterceptedException("Element was not clickable",e);
        }
    }
}
