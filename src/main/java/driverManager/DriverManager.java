package driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class DriverManager {

    private static ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static AppiumDriver getAppiumDriver() {
        return appiumDriverThreadLocal.get();
    }
    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    private static AppiumDriverLocalService appiumDriverLocalService;

    public static AppiumDriverLocalService getAppiumDriverLocalService() {
        return appiumDriverLocalService;
    }

    public static void setAppiumDriver(AppiumDriver appiumDriver) {
        appiumDriverThreadLocal.set(appiumDriver);
    }
    public static void setWebDriver(WebDriver webDriver) { webDriverThreadLocal.set(webDriver);}
}
