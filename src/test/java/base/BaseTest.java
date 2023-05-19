package base;

import capablities.BuildCaps;
import configuration.ConfigProperty;
import interactions.MobileInteraction;
import interactions.WebInteraction;
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import serverConfiguration.serverConfig;

import java.io.IOException;


public class BaseTest {
    public static WebDriver webDriver;
    public static AppiumDriver appiumDriver;
    public static ThreadLocal<String> deviceId = new ThreadLocal<>();
    ConfigProperty util = new ConfigProperty();
    BuildCaps caps = new BuildCaps();
    MobileInteraction mobileInteraction = new MobileInteraction(appiumDriver);
    WebInteraction webInteraction = new WebInteraction(webDriver);

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
            caps.buildURL();
        } else {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.get("https://www.ebay.com/");
            webDriver.manage().window().maximize();
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
