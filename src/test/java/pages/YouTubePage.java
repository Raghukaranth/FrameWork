package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class YouTubePage extends Page {
    @FindBy(id = "logo-icon")
    private WebElement img_logo;

    public YouTubePage() throws IOException, ParseException {
    }

    @Override
    public YouTubePage waitForPageToLoad() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(img_logo));
        return this;
    }


}
