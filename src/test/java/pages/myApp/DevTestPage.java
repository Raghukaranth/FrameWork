package pages.myApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevTestPage {
    @FindBy(id = "idEdtName")
    private WebElement NameTextBox;

    @FindBy(id = "idEdtJob")
    private WebElement JobTextBox;

    @FindBy(id = "idBtnPost")
    private WebElement PostBtn;

    public DevTestPage(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }




    public WebElement getNameTextBox() {
        return NameTextBox;
    }

    public void setNameTextBox(WebElement nameTextBox) {
        NameTextBox = nameTextBox;
    }

    public WebElement getJobTextBox() {
        return JobTextBox;
    }

    public void setJobTextBox(WebElement jobTextBox) {
        JobTextBox = jobTextBox;
    }

    public WebElement getPostBtn() {
        return PostBtn;
    }

    public void setPostBtn(WebElement postBtn) {
        PostBtn = postBtn;
    }




    public void enterDataForName() {
        NameTextBox.sendKeys("aa");
    }

    public void enterDataForJob() {
        JobTextBox.sendKeys("aa");
    }

}
