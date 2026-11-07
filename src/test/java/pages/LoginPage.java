package pages;

import base.Page;
import interactions.WebInteractions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends Page {
    @FindBy(id="customer_login_link")
    private WebElement login_Btn;

    @FindBy(id="customer_email")
    private WebElement email_txtBox;

    @FindBy(id="customer_password")
    private WebElement password_txtBox;

    public void clickOnLoginAndEnterEmailAndPassword() {
        webInteractions.waitForElementToBeClicked(login_Btn);
    }
}
