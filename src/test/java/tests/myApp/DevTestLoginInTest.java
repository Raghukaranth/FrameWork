package tests.myApp;

import base.BaseDevTest;
import org.testng.annotations.Test;
import pages.myApp.DevTestLoginPage;

public class DevTestLoginInTest extends BaseDevTest {
    @Test
    public void clickOnSignInBtn() {
        DevTestLoginPage devTestLoginPage = new DevTestLoginPage(appiumDriver);

        devTestLoginPage.clickOnSignUpBtn();
    }
}
