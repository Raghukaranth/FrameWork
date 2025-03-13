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


    public void enterDataForName() {
        NameTextBox.sendKeys(DevData.NAME_TEXT_BOX);
    }

    public void enterDataForJob() {
        JobTextBox.sendKeys(DevData.JOB_TEXT_BOX);
    }

}
