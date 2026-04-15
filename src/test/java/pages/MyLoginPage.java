package pages;

import base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLoginPage extends Page {
    @FindBy(xpath = "//p[text()='Please login to your account']")
    private WebElement loginText;

    @Override
    public MyLoginPage waitForPageToLoad() {
        webInteractions.waitForElementToAppear(loginText);
        return this;
    }

    
}
