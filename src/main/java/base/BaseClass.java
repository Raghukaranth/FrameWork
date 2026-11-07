package base;

import config.ConfigReader;
import config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite
    public void BeforeSuite() {
        String platform = ConfigReader.getProperty("platform");
        String target = ConfigReader.getProperty("target");
        String appiumUrl = ConfigReader.getProperty("appium.server.url");
        String appPath = ConfigReader.getProperty("app.path");

        WebDriver rawDriver = DriverFactory.DriverInstance(platform, target, appiumUrl);

        String waitTime = ConfigReader.getProperty("implicit.wait");
        int seconds = (waitTime != null) ? Integer.parseInt(waitTime) : 10;
        rawDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.set(rawDriver);
        if (platform != null && platform.equalsIgnoreCase("web")) {
            getDriver().manage().window().maximize();

            String appUrl = ConfigReader.getProperty("url");
            if (appUrl != null) {
                getDriver().get(appUrl);
            } else {
                throw new RuntimeException("Target web URL missing from application.properties configuration!");
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @AfterSuite
    public void AfterSuite() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        driver.remove();
    }
}
