package tests;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;

public class HomeTest extends BaseTest {
    @Test
    public void searchProductWithFilter() throws IOException, ParseException, InterruptedException {
        HomePage homePage = new HomePage();
        homePage.selectPhoneAndAccessoriesCategory()
                .clickOnSearchButton()
                .clickOnPhoneAndAccessories()
                .clickOnSeeAll()
                .selectFilterForSizeAndClickApply()
                .clickOnAllFilters()
                .selectFilterForPriceAndClickApply()
                .clickOnAllFilters()
                .selectFilterForLocationAndClickApply()
                .validateAllFilters();
    }

    @Test
    public void searchMacBook() throws IOException, ParseException, InterruptedException {
        HomePage homePage = new HomePage();
        homePage.selectComputerTabsAndNetworkCategory()
                .enterMacBookInSearchBar("MacBook")
                .clickOnSearchButton()
                .scrollToMacBook()
                .validateMacBook();
    }
}
