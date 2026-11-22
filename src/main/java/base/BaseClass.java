package base;

import config.ConfigReader;
import config.DriverFactory;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void BeforeSuite() {
        String platform = ConfigReader.getProperty("platform");
        String target = ConfigReader.getProperty("target");
        String appiumUrl = ConfigReader.getProperty("appium.server.url");
        String appPath = ConfigReader.getProperty("app.path");

        String apiBaseUrl = ConfigReader.getProperty("api.base.url");
        if (apiBaseUrl != null && !apiBaseUrl.isEmpty()) {
            RestAssured.baseURI = apiBaseUrl;
        }

        // Skip WebDriver initialization if running API-only tests
        if (platform != null && platform.equalsIgnoreCase("api")) {
            return;
        }

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

    @AfterSuite(alwaysRun = true)
    public void AfterSuite() {
        if (getDriver() != null) {
            getDriver().quit();
        }
        driver.remove();
    }
}
