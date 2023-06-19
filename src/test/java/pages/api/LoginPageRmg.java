package pages.api;

import base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPageRmg extends Page {
    @FindBy(id = "usernmae")
    private WebElement txt_username;

    @FindBy(id = "inputPassword")
    private WebElement txt_password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btn_login;

    public HomePageRmg enterUserNamePasswordAndLogin() {
        webInteraction.enterText(txt_username,"rmgyantra");
        webInteraction.enterText(txt_password, "rmgy@9999");
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_login));
        return new HomePageRmg();
    }
}
