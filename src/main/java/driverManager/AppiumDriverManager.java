package driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppiumDriverManager {

    private static ThreadLocal<AppiumDriver> appiumDriverThreadLocal = new ThreadLocal<>();

    public static AppiumDriver getAppiumDriver() {
        return appiumDriverThreadLocal.get();
    }

    private static AppiumDriverLocalService appiumDriverLocalService;

    public static AppiumDriverLocalService getAppiumDriverLocalService() {
        return appiumDriverLocalService;
    }

    public void setAppiumDriverLocalService(AppiumDriverLocalService appiumDriverLocalService) {
        this.appiumDriverLocalService = appiumDriverLocalService;
    }
}
