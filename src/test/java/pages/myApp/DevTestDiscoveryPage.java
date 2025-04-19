package pages.myApp;

import base.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DevTestDiscoveryPage extends Pages {
    @FindBy(id = "textBox")
    private WebElement HomeTextBox;

    @FindBy(id = "navigation_bar_item_large_label_view")
    private WebElement HomeBottomNavButton;

    @FindBy(xpath = "//android.widget.TextView[text()='Google']")
    private WebElement GoogleBottomNavButton;

    @FindBy(xpath = "//android.widget.TextView[text()='Perplexity']")
    private WebElement PerplexityBottomNavButton;

    @Override
    public DevTestDiscoveryPage waitForPageToLoad() {
        mobileInteractions.waitForElementToAppear(HomeTextBox);
        mobileInteractions.waitForElementToAppear(HomeBottomNavButton);
        mobileInteractions.waitForElementToAppear(GoogleBottomNavButton);
        mobileInteractions.waitForElementToAppear(PerplexityBottomNavButton);
        return new DevTestDiscoveryPage();
    }

    public DevTestDiscoveryPage FindAllElements() {
        waitForPageToLoad();
        return new DevTestDiscoveryPage();
    }

}
