package base;

import files.FilePath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseTest {
    public static WebDriver webDriver;
    public static AppiumDriver appiumDriver;

    @BeforeSuite
    public void BeforeSuite() {

    }

    public static AppiumServiceBuilder builder = new AppiumServiceBuilder();
    public static AppiumDriverLocalService AppiumService;
    public static AppiumDriverLocalService setUpServer(String testCase) {
        builder.withIPAddress(FilePath.APPIUM_SERVER_IP)
                .withAppiumJS(new File(FilePath.APPIUM_JS_FILE))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        AppiumService = AppiumDriverLocalService.buildService(builder);
        return AppiumService;
    }
}
