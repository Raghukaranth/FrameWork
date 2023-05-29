package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class ResultPage extends Page {

    @FindBy(xpath = "//button[@aria-label='All Filters']")
    private WebElement btn_allFilters;

    @FindBy(xpath = "//span[contains(text(),'filters applied')]")
    private WebElement btn_appliedFilter;

    @FindBy(xpath = "//span[@class='brm__item-label' and contains(text(),'Price')]")
    private WebElement list_appliedPrice;

    @FindBy(xpath = "//span[@class='brm__item-label' and contains(text(),'Item Location')]")
    private WebElement list_appliedLocation;

    @FindBy(xpath = "//span[@class='brm__item-label' and contains(text(),'Screen Size')]")
    private WebElement list_screenSize;

    public ResultPage() throws IOException, ParseException {
    }

    @Override
    public ResultPage waitForPageToLoad() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(img_logo));
        return this;
    }

    public FilterPage clickOnAllFilters() throws IOException, ParseException {
        Assert.assertTrue(webInteraction.waitForElementToAppearAndClick(btn_allFilters));
        webInteraction.waitForPageToLoad();
        return new FilterPage();
    }

    public ResultPage validateAllFilters() {
        webInteraction.waitForElementToAppearAndClick(btn_appliedFilter);
        Assert.assertTrue(webInteraction.waitForElementToAppear(list_screenSize));
        Assert.assertTrue(webInteraction.waitForElementToAppear(list_appliedPrice));
        Assert.assertTrue(webInteraction.waitForElementToAppear(list_appliedLocation));
        return this;
    }

}
