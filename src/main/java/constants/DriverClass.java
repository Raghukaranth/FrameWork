package constants;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverClass {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    private DriverClass() {}

    public static WebDriver getWebDriver(String browser) {
        WebDriver driver = webDriver.get();
        if (driver == null) {
            switch (ConfigProperty.BROWSER.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
            driver.get(ConfigProperty.URL);
            driver.manage().window().maximize();
            webDriver.set(driver);   // <<< important
        }
        return driver;
    }

    public static AppiumDriver getMobileDriver(String platformName) {
        AppiumDriver driver = appiumDriver.get();
        if (driver == null) {   // you already fixed this part
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (ConfigProperty.PLATFORM.toLowerCase()) {
                case "android":
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("automationName", "UiAutomator2");
                    capabilities.setCapability("platformVersion", "13");
                    capabilities.setCapability("deviceName", "Android Emulator");
                    capabilities.setCapability("appPackage", "com.example.androiddevjava");
                    capabilities.setCapability("appActivity", ".login.LoginActivity");
                    break;

                case "iOS":
                    capabilities.setCapability("platformName", "iOS");
                    capabilities.setCapability("automationName", "XCUITest");
                    capabilities.setCapability("platformVersion", "17.0");
                    capabilities.setCapability("deviceName", "iPhone 15 Pro");
                    capabilities.setCapability("app", "/path/to/your.app");
                    break;
            }

            try {
                driver = new AppiumDriver(new URL(ConfigProperty.APPIUM_URL), capabilities);
                appiumDriver.set(driver);   // <<< important
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL in config: '" + ConfigProperty.APPIUM_URL + "'", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver web = webDriver.get();
        if (web != null) {
            web.quit();
            webDriver.remove();   // clean up thread
        }

        AppiumDriver appium = appiumDriver.get();
        if (appium != null) {
            appium.quit();
            appiumDriver.remove();   // clean up thread
        }
    }
}