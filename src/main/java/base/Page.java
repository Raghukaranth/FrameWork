package base;

import config.ConfigReader;
import interactions.WebInteractions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class Page {
    protected WebDriver driver;
    protected WebInteractions webInteractions;

    public Page() {
        // Safe now because WebInteractions no longer extends Page!
        this.driver = BaseClass.getDriver();
        this.webInteractions = new WebInteractions(driver);

        String waitTime = ConfigReader.getProperty("implicit.wait");
        int seconds = (waitTime != null) ? Integer.parseInt(waitTime) : 10;

        // Initializes elements for Web and Appium contexts safely
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(seconds)), this);
    }
}
