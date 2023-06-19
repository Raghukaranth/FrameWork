package pages.api;

import base.Page;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProjectPage extends Page {
    @FindBy(xpath = "//td[text()='Raghavendra']")
    private WebElement txt_name;

    @FindBy(xpath = "//td[contains(text(), 'TY_PROJ')]")
    private WebElement txt_project;

    public ProjectPage checkName(String pid) {
        pid = txt_project.getText();
        Response response = apiInteraction.callGetMethod(pid);
        Assert.assertTrue(webInteraction.waitForElementToAppear(txt_name));
        apiInteraction.verifyResponseCode(response, Integer.parseInt("200"));
        return this;
    }
}
