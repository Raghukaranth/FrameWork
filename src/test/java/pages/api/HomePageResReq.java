package pages.api;

import base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.MockServerHelper;

public class HomePageResReq extends Page {
    @FindBy(xpath = "//img[@src='/img/logo.png']")
    private WebElement img_logo;

    public HomePageResReq validateLogo() {
        MockServerHelper.getResponse();
        MockServerHelper.postRequest();
        MockServerHelper.putRequest();
        MockServerHelper.patchRequest();
        MockServerHelper.deleteRequest();
        return this;
    }
}
