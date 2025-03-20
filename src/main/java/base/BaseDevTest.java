package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseDevTest {
    public static AppiumDriver appiumDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "13");
        caps.setCapability("deviceName", "d6e1e45f");
        caps.setCapability("appPackage", "com.example.androiddevjava");
            caps.setCapability("appActivity", ".LoginActivity");

        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }


    @AfterTest
    public void tearDown() {
        if (null != appiumDriver) {
            appiumDriver.quit();
        }
    }
}
