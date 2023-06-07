package base;

import browser.BrowserManager;
import configuration.ConfigProperty;
import database.DataBaseUtil;
import driverManager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import serverConfiguration.serverConfig;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;




public class BaseTest extends serverConfig {
    public static WebDriver webDriver;
    public static ThreadLocal<AppiumDriverLocalService> appiumThread = new ThreadLocal<>();

    ConfigProperty util = new ConfigProperty();
    public AppiumDriverLocalService appiumServer;


    @BeforeSuite
    public void BeforeSuite(ITestContext result) throws IOException, ParseException, SQLException {
        DataBaseUtil.createConnection();
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
            this.appiumServer = startAppiumServer(setUpServer(result.getName()));
            appiumThread.set(this.appiumServer);
        }
    }

    @BeforeMethod
    public void BeforeMethod() throws IOException, ParseException, SQLException {
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
                appiumDriver = launchApp(appiumThread.get().getUrl(), Platform.ANDROID);
        }
        else {
            webDriver = BrowserManager.BrowserSetUp("chrome");
            DriverManager.setWebDriver(webDriver);
            DriverManager.getWebDriver().get("https://www.google.com");
        }

    }

    @AfterMethod
    public void AfterMethod() throws SQLException {
        DataBaseUtil.closeConnection();
    }

    @AfterSuite
    public void AfterSuite() throws IOException, ParseException {
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android"))
            serverConfig.stopServer();
        else webDriver.quit();
    }
}
