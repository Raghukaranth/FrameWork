package base;

import constants.ConfigProperty;
import constants.DriverClass;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ExtentReportManager;
import report.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    // ThreadLocal to store browser/platform per thread
    protected static ThreadLocal<String> currentBrowser = new ThreadLocal<>();
    protected static ThreadLocal<String> currentPlatform = new ThreadLocal<>();

    // ─────────────────────────────────────────
    // SUITE LEVEL — runs once
    // ─────────────────────────────────────────
    @BeforeSuite
    public void beforeSuite() {
        ConfigProperty.getInstance();
        ExtentReportManager.getInstance(); // ✅ Init report once
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReports(); // ✅ Flush once after all threads finish
    }

    // ─────────────────────────────────────────
    // METHOD LEVEL — runs per thread
    // ─────────────────────────────────────────
    @Parameters({"platform", "browser"})
    @BeforeMethod
    public void beforeMethod(
            @Optional("web") String platform,
            @Optional("chrome") String browser,
            Method method) {

        // Store per-thread values
        currentPlatform.set(platform);
        currentBrowser.set(browser);

        // Initialize driver per thread
        if ("web".equalsIgnoreCase(platform)) {
            DriverClass.getWebDriver(browser);
        } else if ("mobile".equalsIgnoreCase(platform)) {
            DriverClass.getMobileDriver(ConfigProperty.PLATFORM_NAME);
        }

        // Create test node — thread-safe via ThreadLocal
        ExtentTest test = ExtentReportManager.getInstance()
                .createTest(
                        "[" + browser.toUpperCase() + "] " + method.getName()
                );
        ExtentReportManager.setTest(test);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        ExtentTest test = ExtentReportManager.getTest();

        if (test == null) {
            System.err.println("[BaseTest] ExtentTest is null for: "
                    + result.getMethod().getMethodName());
            return;
        }

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                test.pass("✅ Test Passed");
                break;

            case ITestResult.FAILURE:
                test.fail("❌ Test Failed: " + result.getThrowable());
                String screenshotPath = ScreenshotUtil.capture(
                        result.getMethod().getMethodName()
                );
                if (screenshotPath != null) {
                    try {
                        test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
                    } catch (Exception e) {
                        test.warning("⚠️ Could not attach screenshot: " + e.getMessage());
                    }
                }
                break;

            case ITestResult.SKIP:
                test.skip("⏭️ Test Skipped: " + result.getThrowable());
                break;
        }

        // ✅ Quit driver per thread after each method
        DriverClass.quitDriver();
    }
}