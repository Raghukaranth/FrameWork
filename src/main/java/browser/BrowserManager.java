package browser;

import configuration.ConfigProperty;
import constant.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserManager {
    public static WebDriver BrowserSetUp(String browserName) {
        WebDriver webDriver = null;
        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        else {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
            webDriver.manage().window().maximize();
            webDriver.manage()
                    .timeouts()
                    .implicitlyWait(Constants.TIMEOUT_LONG, TimeUnit.SECONDS);
        return webDriver;
    }
}
