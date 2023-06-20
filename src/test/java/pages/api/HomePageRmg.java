package pages.api;

import base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePageRmg extends Page {
    @FindBy(xpath = "//h2[normalize-space()='Welcome To Project Management System']")
    private WebElement txt_header;

    @FindBy(xpath = "//a[@href='/dashboard/projects']")
    private WebElement link_project;

    public ProjectPage checkHeaderAndClickOnProject() {
        apiInteraction.callPostMethod();
        Assert.assertTrue(webInteraction.waitForElementToAppear(txt_header));
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(link_project));
        return new ProjectPage();
    }
}
