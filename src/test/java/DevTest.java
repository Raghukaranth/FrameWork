import org.testng.annotations.Test;
import pages.myApp.DevTestPage;

public class DevTest extends BaseDevTest {
    @Test
    public void enterTheData() {
        DevTestPage devTestPage = new DevTestPage(driver);
        devTestPage.enterDataForName();
        devTestPage.enterDataForJob();
    }
}
