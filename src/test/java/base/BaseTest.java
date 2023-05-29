package base;

import browser.BrowserManager;
import capablities.BuildCaps;
import configuration.ConfigProperty;
import driverManager.DriverManager;
import interactions.MobileInteraction;
import interactions.WebInteraction;
import io.appium.java_client.AppiumDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import serverConfiguration.serverConfig;

import java.io.IOException;


public class BaseTest {
    public static WebDriver webDriver;
    public static AppiumDriver appiumDriver;
    public static ThreadLocal<String> deviceId = new ThreadLocal<>();
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    ConfigProperty util = new ConfigProperty();
    BuildCaps caps = new BuildCaps();

    @BeforeSuite
    public void BeforeSuite() throws IOException, ParseException {
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android"));
            serverConfig.startServer();
    }

    @BeforeMethod
    public void BeforeMethod() throws IOException, ParseException {
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
            caps.buildCaps();
            DriverManager.setAppiumDriver(appiumDriver);

        } else {
            webDriver = BrowserManager.BrowserSetUp("chrome");
            DriverManager.setWebDriver(webDriver);
            DriverManager.getWebDriver().get(ConfigProperty.URL);
        }
    }

    @AfterSuite
    public void AfterSuite() throws IOException, ParseException {
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android"))
            serverConfig.stopServer();
        else webDriver.quit();
    }
}
