package tests.myApp;

import base.AndroidBaseDevTest;
import org.testng.annotations.Test;
import pages.myApp.DevTestLoginPage;

public class DevTestSignUpTest extends AndroidBaseDevTest {
    @Test
    public void enterTextInNameTextBox() {
        DevTestLoginPage devTestLoginPage = new DevTestLoginPage(appiumDriver);

        devTestLoginPage.clickOnSignUpBtn()
                .enterNameInTextField("hi");
    }
}
