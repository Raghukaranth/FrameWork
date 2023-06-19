package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.api.LoginPageRmg;
import pages.api.ProjectPage;

public class ApiTestRMG extends BaseTest {
    @Test
    public void TestApiForWeb() {
        String pid = null;
        LoginPageRmg loginPage = new LoginPageRmg();
        loginPage.enterUserNamePasswordAndLogin()
                .checkHeaderAndClickOnProject()
                .checkName(pid);
    }
}
