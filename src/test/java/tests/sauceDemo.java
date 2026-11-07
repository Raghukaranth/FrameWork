package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class sauceDemo extends BaseClass {
    @Test
    public void clickOnLoginButtonInApp() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnLoginAndEnterEmailAndPassword();
    }
}
