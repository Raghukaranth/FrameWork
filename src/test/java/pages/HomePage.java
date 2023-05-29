package pages;

import constant.Constants;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends Page {

    @FindBy(id = "gh-cat")
    private WebElement drpdwn_select_Category;

    @FindBy(id = "gh-ac")
    private WebElement txt_search;

    @FindBy(id = "gh-btn")
    private WebElement btn_search;

    @FindBy(xpath = "//a[@aria-label='Google apps']")
    private WebElement btn_GoogleApps;

    @FindBy(xpath = "//span[@data-text='YouTube']")
    private WebElement btn_youTube;

    @FindBy(xpath = "//iframe[@name='app']")
    private WebElement frame_apps;
    public HomePage() throws IOException, ParseException {
    }

    @Override
    public HomePage waitForPageToLoad() {
        webInteraction.waitForElementToAppear(img_logo);
        return this;
    }


    public HomePage selectPhoneAndAccessoriesCategory() throws InterruptedException {
        webInteraction.selectInteractionsByValue(drpdwn_select_Category, Constants.CELLPHONE_ACCESSORIES);
        return this;
    }

    public HomePage enterMacBookInSearchBar(String value) {
        webInteraction.enterText(txt_search, value);
        return this;
    }
    public CategoryPage clickOnSearchButton() throws IOException, ParseException, InterruptedException {
        webInteraction.waitForElementToAppearAndClick(btn_search);
        return new CategoryPage();
    }

    public HomePage selectComputerTabsAndNetworkCategory() throws InterruptedException {
        webInteraction.selectInteractionsByValue(drpdwn_select_Category, Constants.COMPUTER_TAB_AND_NETWORKS);
        return this;
    }

      public HomePage clickOnApp() {
          Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_GoogleApps));
          webInteraction.actionsForFrames(frame_apps);
          return this;
      }

      public HomePage checkYouTube() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(btn_youTube));
        return this;
      }

      public YouTubePage clickOnYouTube() throws IOException, ParseException {
        Assert.assertTrue(webInteraction.clickActions(btn_youTube));
        return new YouTubePage();
      }
}
