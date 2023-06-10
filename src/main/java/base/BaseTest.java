package base;

import browser.BrowserManager;
import configuration.ConfigProperty;
import database.DataBaseUtil;
import driverManager.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.file.FilePath;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static constant.Constants.TIMEOUT_LONG;


public class BaseTest {
    public static AppiumDriver appiumDriver;
    public static WebDriver webDriver;
    public static ThreadLocal<AppiumDriverLocalService> appiumThread = new ThreadLocal<>();
    ConfigProperty util = new ConfigProperty();
    public AppiumDriverLocalService appiumServer;
    public Page nakkanpage;

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
                nakkanpage = new Page();
        }
        else {
            webDriver = BrowserManager.BrowserSetUp("chrome");
            DriverManager.setWebDriver(webDriver);
            DriverManager.getWebDriver().get(ConfigProperty.URL);
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
                stopServer();
        else webDriver.quit();
    }

    public static AppiumServiceBuilder builder = new AppiumServiceBuilder();
    public static AppiumDriverLocalService AppiumService;
    public static AppiumDriverLocalService setUpServer(String testCase) {
        builder.withIPAddress(FilePath.APPIUM_SERVER_IP)
                .withAppiumJS(new File(FilePath.APPIUM_JS_FILE))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.RELAXED_SECURITY);
        AppiumService = AppiumDriverLocalService.buildService(builder);
        return AppiumService;
    }

    public static void stopServer() {
        if(AppiumService != null)
            AppiumService.stop();
    }

    public AppiumDriverLocalService startAppiumServer(AppiumDriverLocalService service) {
        if (service != null) {
            service.start();
        }
        return  AppiumService;
    }

    public AppiumDriver launchApp(URL url, Platform platForm) {
        DesiredCapabilities capabilities;
        capabilities = setDesiredCapability("android");
        appiumDriver = new AndroidDriver(url, capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(TIMEOUT_LONG, TimeUnit.SECONDS);
        return appiumDriver;
    }

    public DesiredCapabilities setDesiredCapability(String platform) {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
            desiredCaps.setCapability("platform", platform);
            desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigProperty.PLATFORM_VERSION);
            desiredCaps.setCapability(MobileCapabilityType.UDID, ConfigProperty.UDID);
            desiredCaps.setCapability(MobileCapabilityType.NO_RESET, ConfigProperty.NO_RESET);
            desiredCaps.setCapability("appPackage", ConfigProperty.APP_PACKAGE);
            desiredCaps.setCapability("appActivity", ConfigProperty.APP_ACTIVITY);
        }
        return desiredCaps;
    }
}
