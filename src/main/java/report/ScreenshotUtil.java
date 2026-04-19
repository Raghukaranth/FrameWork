package report;

import constants.ConfigProperty;
import constants.DriverClass;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

@Slf4j
public class ScreenshotUtil {

    public static String capture(String testName) {
        try {
            TakesScreenshot takesScreenshot = resolveDriver();

            if (takesScreenshot == null) {
                log.error("[ScreenshotUtil] No active driver found — skipping screenshot.");
                return null;
            }

            File src = takesScreenshot.getScreenshotAs(OutputType.FILE);

            String dirPath = "reports/screenshots/";
            new File(dirPath).mkdirs(); // Create folder if not exists

            String filePath = dirPath + testName + "_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(src, new File(filePath));

            log.info("[ScreenshotUtil] Screenshot saved: " + filePath);
            return filePath;

        } catch (IOException e) {
            log.error("[ScreenshotUtil] Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }

    /**
     * Resolves the active driver based on ConfigProperty.PLATFORM
     * Supports both Web (WebDriver) and Mobile (AppiumDriver)
     */
    private static TakesScreenshot resolveDriver() {
        String platform = ConfigProperty.PLATFORM.toLowerCase();

        switch (platform) {
            case "android":
            case "ios":
                AppiumDriver appiumDriver = DriverClass.getMobileDriver(platform);
                return (appiumDriver != null) ? appiumDriver : null;

            default:
                // Web: chrome, firefox, edge, safari
                WebDriver webDriver = DriverClass.getWebDriver(ConfigProperty.BROWSER);
                return (webDriver != null) ? (TakesScreenshot) webDriver : null;
        }
    }
}
