package serverConfiguration;

import configuration.ConfigProperty;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;
import utils.file.FilePath;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static constant.Constants.TIMEOUT_LONG;
import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

public class serverConfig {
    public static AppiumServiceBuilder builder = new AppiumServiceBuilder();
    public static AppiumDriverLocalService AppiumService;
    public static Logger logger;

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

    public AppiumDriver appiumDriver;
    public DesiredCapabilities setDesiredCapability(String platform) {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
            desiredCaps.setCapability("platform", platform);
            desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            desiredCaps.setCapability(MobileCapabilityType.UDID, "d6e1e45f");
            desiredCaps.setCapability(MobileCapabilityType.NO_RESET, "true");
            desiredCaps.setCapability("appPackage", "com.application.zomato");
            desiredCaps.setCapability("appActivity", ".activities.Splash");
        }
        return desiredCaps;
    }
    public AppiumDriver launchApp(URL url, Platform platForm) {
        DesiredCapabilities capabilities;
        capabilities = setDesiredCapability("android");
        appiumDriver = new AndroidDriver(url, capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(TIMEOUT_LONG, TimeUnit.SECONDS);
        return appiumDriver;
    }
}
