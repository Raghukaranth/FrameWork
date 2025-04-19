package tests.myApp;

import base.AndroidBaseDevTest;
import org.testng.annotations.Test;
import pages.myApp.DevTestLoginPage;

public class DevTestLoginInTest extends AndroidBaseDevTest {
    @Test
    public void clickOnSignInBtn() {
        DevTestLoginPage devTestLoginPage = new DevTestLoginPage(appiumDriver);

        devTestLoginPage.clickOnSignUpBtn();
    }
}
