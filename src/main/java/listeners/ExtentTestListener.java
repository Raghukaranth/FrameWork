package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import config.ExtentManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class ExtentTestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getReports("target/ExtentReport.html");

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS, "Test passed");
        ExtentManager.unload();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL, result.getThrowable());
        ExtentManager.unload();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP, "Test skipped");
        ExtentManager.unload();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}