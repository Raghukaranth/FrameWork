import base.BaseTest;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {
    @Test
    public void myTest() {
        System.out.println("current URL: " + webDriver.getCurrentUrl());
    }
}
