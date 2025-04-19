package pages.myApp;

import base.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevTestSIgnUpPage extends Pages {

    @FindBy(id = "idNameText")
    private WebElement nameTextBox;

    @FindBy(id = "idBtnSignUp")
    private WebElement signUpBtn;

    @FindBy(xpath = "//*[contains(@text, ''Response Code)]")
    private WebElement responeCodeText;

    @Override
    public DevTestSIgnUpPage waitForPageToLoad() {
        mobileInteractions.waitForElementToAppear(nameTextBox);
        return this;
    }

    public void enterNameInTextField(String name) {
        mobileInteractions.enterText(nameTextBox, name);
    }

}
