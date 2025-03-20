package pages.myApp;

import interactions.MobileInteractions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static base.BaseDevTest.appiumDriver;

public class DevTestLoginPage {
    public MobileInteractions mobileInteractions;

    @FindBy(id = "idNumberTextBox")
    private WebElement idTextBox;

    @FindBy(id = "idLoginButton")
    private WebElement idLoginBtn;

    @FindBy(id = "idLoginSignButton")
    private WebElement idSignUpBtn;

    public DevTestLoginPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
        mobileInteractions = new MobileInteractions(appiumDriver);
    }

    public DevTestSIgnUpPage clickOnSignUpBtn() {
        mobileInteractions.waitForElementToAppearAndClick(idSignUpBtn);
        return new DevTestSIgnUpPage();
    }
}
