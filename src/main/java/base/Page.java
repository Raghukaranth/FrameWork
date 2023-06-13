package base;

import constant.ConfigProperty;
import interactions.MobileInteraction;
import interactions.WebInteraction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static base.BaseTest.appiumDriver;

public  class Page {

    public WebDriver webDriver = BaseTest.webDriver;
    ConfigProperty util = new ConfigProperty();
    protected WebInteraction webInteraction;
    protected MobileInteraction mobileInteraction;

    public Page() {
        util.setData();
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
            PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
            mobileInteraction = new MobileInteraction(appiumDriver);
        }
        else {
            PageFactory.initElements(webDriver, this);
            webInteraction = new WebInteraction(this.webDriver);
        }
    }
}