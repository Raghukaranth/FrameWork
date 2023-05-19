package pages;

import interactions.Constants;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class CategoryPage extends Page {
    @FindBy(xpath = "//a[@href='https://www.ebay.com/b/Cell-Phones-Smartphones/9355/bn_320094' and @class='b-textlink b-textlink--parent']")
    private WebElement lnk_cellPhonesAndSmartPhones;

    @FindBy(xpath = "//section[contains(@class,'b-module b-carousel b-guidance b-display--landscape')]//span[contains(text(),'See All')]")
    private WebElement btn_seeAll;

    @FindBy(xpath = "//span[@class='brm__flyout__btn-label' and contains(text(),'filters applied')]")
    private  WebElement btn_filterApplied;

    @FindBy(xpath = "//span[contains(text(),'Price')]")
    private WebElement list_validatePrice;

    @FindBy(xpath = "//span[contains(text(),'Item Location')]")
    private WebElement list_validateLocation;

    @FindBy(xpath = "//div[text()='MacBooks']")
    private WebElement sel_MacBook;

    public CategoryPage() throws IOException, ParseException {
    }

    @Override
    public CategoryPage waitForPageToLoad() {
        webInteraction.waitForElementToAppear(img_logo);
        return this;
    }

    public CategoryPage clickOnPhoneAndAccessories() throws InterruptedException {
        webInteraction.waitForElementToAppearAndClick(lnk_cellPhonesAndSmartPhones);
        return this;
    }

    public FilterPage clickOnSeeAll() throws InterruptedException, IOException, ParseException {
        webInteraction.waitForElementToAppearAndClick(btn_seeAll);
        return new FilterPage();
    }

    public CategoryPage validateResults() throws InterruptedException {
        webInteraction.waitForElementToAppearAndClick(btn_filterApplied);
        Assert.assertTrue(webInteraction.waitForElementToAppear(list_validatePrice));
        Assert.assertTrue(webInteraction.waitForElementToAppear(list_validateLocation));
        return this;
    }

    public CategoryPage scrollToMacBook() {
        webInteraction.scrollTillElement(sel_MacBook);
        return this;
    }

    public CategoryPage validateMacBook() {
        Assert.assertTrue(webInteraction.waitForElementToAppear(sel_MacBook));
        return this;
    }
}
