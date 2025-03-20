package pages.myApp;

import interactions.MobileInteractions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevTestSIgnUpPage extends Pages {

    @FindBy(id = "idNameText")
    private WebElement nameTextBox;

    @FindBy(id = "idBtnSignUp")
    private WebElement signUpBtn;

    @FindBy(xpath = "//*[contains(@text, ''Response Code)]")
    private WebElement responeCodeText;

    public void enterNameInTextField(String name) {
        mobileInteractions.enterText(nameTextBox, name);
    }
}
