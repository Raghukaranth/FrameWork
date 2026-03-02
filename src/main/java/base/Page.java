package base;

import org.openqa.selenium.support.PageFactory;

import static base.BaseTest.webDriver;

public abstract class Page {
    public Page () {
        PageFactory.initElements(webDriver, this);
        this.waitForPageToLoad();
    }
    public abstract <T extends Page> T waitForPageToLoad();
}
