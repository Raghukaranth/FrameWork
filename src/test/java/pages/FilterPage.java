package pages;

import constant.Constants;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class FilterPage extends Page {
    @FindBy(xpath = "//div[@class='x-overlay__wrapper--right']")
    private WebElement ele_checkboxes;
    @FindBy(xpath = "//span[@class='field']/child::span/child::input[@id='c3-subPanel-Screen%20Size_4.0%20-%204.4%20in_cbx']")
    private WebElement chkbox_size;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    private  WebElement btn_apply;

    @FindBy(xpath = "//span[text()='Screen Size']")
    private WebElement list_selectSize;

    @FindBy(xpath = "//div[@id='c3-mainPanel-price']")
    private WebElement list_price;

    @FindBy(xpath = "//input[@aria-label='Minimum Value, US Dollar']")
    private WebElement txt_min;

    @FindBy(xpath = "//input[@aria-label='Maximum Value, US Dollar']")
    private WebElement txt_max;

    @FindBy(xpath = "//div[@id='c3-mainPanel-location']")
    private WebElement list_location;

    @FindBy(xpath = "//input[@aria-label='US Only']")
    private WebElement radio_Us_Only;

    public FilterPage() throws IOException, ParseException {
    }

    @Override
    public FilterPage waitForPageToLoad() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(ele_checkboxes));
        return this;
    }

    public ResultPage selectFilterForSizeAndClickApply() throws IOException, ParseException {
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(list_selectSize));
        waitForPageToLoad();
        webInteraction.jsClickCheckBox(chkbox_size);
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_apply));
        return new ResultPage();
    }

    public ResultPage selectFilterForPriceAndClickApply() throws IOException, ParseException {
        waitForPageToLoad();
        webInteraction.scrollTillElement(list_price);
        webInteraction.waitForElementToAppearAndClick(list_price);
        waitForPageToLoad();
        webInteraction.arrowUpActions();
        webInteraction.enterText(txt_min, Constants.amount1);
        webInteraction.enterText(txt_max, Constants.amount2);
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_apply));
        return new ResultPage();
    }

    public ResultPage selectFilterForLocationAndClickApply() throws IOException, ParseException {
        waitForPageToLoad();
        webInteraction.scrollTillElement(list_location);
        webInteraction.waitForElementToAppearAndClick(list_location);
        waitForPageToLoad();
        webInteraction.arrowUpActions();
        webInteraction.jsClickCheckBox(radio_Us_Only);
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_apply));
        return new ResultPage();
    }
}
