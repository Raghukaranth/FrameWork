package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver DriverInstance(String platform, String target, String appiumUrl) {
        if (platform == null) platform = "web";
        if (target == null) target = "chrome";

        switch (platform.toLowerCase().trim()) {
            case "web":
                return webInstance(target);
            case "mobile":
                return mobileInstance(target, appiumUrl);
            default:
                throw new IllegalArgumentException("Unknown platform: " + platform);
        }
    }

    private static WebDriver webInstance(String browser) {
        // Captures system property flag passed from workflow configuration
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        switch (browser.toLowerCase().trim()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                return new ChromeDriver(chromeOptions);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("-headless");
                }
                return new FirefoxDriver(firefoxOptions);

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("--no-sandbox");
                    edgeOptions.addArguments("--disable-dev-shm-usage");
                    edgeOptions.addArguments("--window-size=1920,1080");
                }
                return new EdgeDriver(edgeOptions);

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    private static AppiumDriver mobileInstance(String os, String appiumUrl) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL url;

        try {
            url = new URL(appiumUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium Server URL configuration!", e);
        }

        switch (os.toLowerCase().trim()) {
            case "android":
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                return new AndroidDriver(url, capabilities);
            default:
                throw new IllegalArgumentException("Unsupported mobile target OS: " + os);
        }
    }
}
