package tests.myApp;

import base.AndroidBaseDevTest;
import org.testng.annotations.Test;
import pages.myApp.DevTestDiscoveryPage;
import pages.myApp.DevTestLoginPage;

public class DevTestDiscoveryTest extends AndroidBaseDevTest {
    @Test
    public void findAllElementsInDiscoveryScreen() {
        DevTestLoginPage devTestLoginPage = new DevTestLoginPage(appiumDriver);

        devTestLoginPage.enterIdAndClickOnLoginButton()
                .FindAllElements();
    }
}
