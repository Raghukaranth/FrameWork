package base;

import constants.ConfigProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static WebDriver webDriver;
    ConfigProperty configProperty;
    public Page nakkanPage;

    @BeforeSuite
    public void BeforeSuite() {
        ConfigProperty.getInstance();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(ConfigProperty.URL);
        webDriver.manage().window().maximize();
    }

    @AfterSuite
    public void AfterSuite() {
        webDriver.quit();
    }
}
