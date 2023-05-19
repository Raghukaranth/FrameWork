package base;

import configuration.ConfigProperty;
import driverManager.AppiumDriverManager;
import interactions.MobileInteraction;
import interactions.WebInteraction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import serverConfiguration.serverConfig;

import java.io.IOException;

public class  BaseUtils {
    public AppiumDriver appiumDriver;
    public WebDriver webDriver = BaseTest.webDriver;
    ConfigProperty util = new ConfigProperty();
    protected WebInteraction webInteraction;
    protected MobileInteraction mobileInteraction;

    @FindBy(id = "gh-logo")
    public WebElement img_logo;

    public BaseUtils() throws IOException, ParseException {
       appiumDriver = AppiumDriverManager.getAppiumDriver();
       util.setData();
       if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
           PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
           mobileInteraction = new MobileInteraction(this.appiumDriver);
       }
       else {
           PageFactory.initElements(webDriver, this);
           webInteraction = new WebInteraction(this.webDriver);
       }
    }
    public static void initializeServer() {
        serverConfig.startServer();
    }
}
