package tests;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.GooglePage;

@Slf4j
public class MyTest extends BaseTest {
    @Test
    public void myTest() {
        GooglePage page = new GooglePage();

        page.EnterText("US Iran War Updates")
                .ClickOnAIButton();
    }
}
