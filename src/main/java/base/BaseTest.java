package base;

import constants.ConfigProperty;
import constants.DriverClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    ConfigProperty configProperty;
    public Page nakkanPage;

    @BeforeSuite
    public void BeforeSuite() {
        ConfigProperty.getInstance();
        if("web".equals(ConfigProperty.PLATFORM)) {
            DriverClass.getWebDriver(ConfigProperty.BROWSER);
        } else if("mobile".equals(ConfigProperty.PLATFORM)) {
            DriverClass.getMobileDriver(ConfigProperty.PLATFORM_NAME);
        }
    }


    @AfterSuite
    public void AfterSuite() {
        DriverClass.quitDriver();
    }
}
