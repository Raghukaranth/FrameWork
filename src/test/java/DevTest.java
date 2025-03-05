import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DevTest extends JavaDevTest {
    @Test
    public void enterTheData() {
        driver.findElement(By.id("idEdtName")).sendKeys("aa");
        driver.findElement(By.id("idEdtJob")).sendKeys("aa");
    }
}
