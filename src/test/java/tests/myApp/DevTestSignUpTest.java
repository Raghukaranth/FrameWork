package tests.myApp;

import base.BaseDevTest;
import org.testng.annotations.Test;
import pages.myApp.DevTestLoginPage;
import pages.myApp.DevTestSIgnUpPage;

public class DevTestSignUpTest extends BaseDevTest {
    @Test
    public void enterTextInNameTextBox() {
        DevTestLoginPage devTestLoginPage = new DevTestLoginPage(appiumDriver);

        devTestLoginPage.clickOnSignUpBtn()
                .enterNameInTextField("hi");
    }
}
