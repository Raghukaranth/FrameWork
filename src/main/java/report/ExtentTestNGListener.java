package report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTest test = ExtentReportManager.getInstance()
                .createTest(iTestResult.getMethod().getMethodName());
        ExtentReportManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTest test = ExtentReportManager.getTest();
        test.log(Status.FAIL, "Test Failed");

        try {
            String screenShotPath = ScreenshotUtil.capture(iTestResult.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenShotPath, "Failure ScreenShot");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        ExtentReportManager.flushReports();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
