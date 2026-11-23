package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SauceDemoTest extends BaseClass {
    @Test(groups = "web")
    public void clickOnLoginButtonInApp() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnLoginAndEnterEmailAndPassword();
    }
}
