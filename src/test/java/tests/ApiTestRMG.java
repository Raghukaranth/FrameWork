package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.api.LoginPageRmg;
import pages.api.ProjectPage;

public class ApiTestRMG extends BaseTest {
    @Test
    public void testApiForWeb() {
        String pid = null;
        LoginPageRmg loginPage = new LoginPageRmg();
        loginPage.enterUserNamePasswordAndLogin()
                .checkHeaderAndClickOnProject()
                .validateForCreatedResponse(pid);
    }

    @Test
    public void testApiDeletion() {
        String pid = null;
        LoginPageRmg loginPage = new LoginPageRmg();
        loginPage.enterUserNamePasswordAndLogin()
                .checkHeaderAndClickOnProject()
                .apiDeletedResponse(pid)
                .clickOnLogOutButton()
                .enterUserNamePasswordAndLogin()
                .checkHeaderAndClickOnProject();


    }
}
