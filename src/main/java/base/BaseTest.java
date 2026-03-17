package base;

import constants.ConfigProperty;
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver webDriver;
    public static AppiumDriver appiumDriver;
    ConfigProperty configProperty;
    public Page nakkanPage;

    @BeforeSuite
    public void BeforeSuite() throws MalformedURLException {
        if("web".equals(ConfigProperty.PLATFORM)) {
            ConfigProperty.getInstance();
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.get(ConfigProperty.URL);
            webDriver.manage().window().maximize();
        } else if("mobile".equals(ConfigProperty.PLATFORM)) {
            setCapsAndStartServer();
        }
    }


    @AfterSuite
    public void AfterSuite() {
        if(ConfigProperty.PLATFORM.equals("web")) {
            webDriver.quit();
        } else {
            if(appiumDriver != null) {
                appiumDriver.quit();
            }
        }
    }

    public void setCapsAndStartServer() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13");
        capabilities.setCapability("appPackage", "com.example.androiddevjava");
        capabilities.setCapability("appActivity", ".login.LoginActivity");

        appiumDriver = new AppiumDriver(new URL(ConfigProperty.APPIUM_URL), capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}
