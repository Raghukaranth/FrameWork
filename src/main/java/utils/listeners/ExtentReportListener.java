package utils.listeners;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import constant.ConfigProperty;
import lombok.extern.slf4j.Slf4j;
import org.testng.*;
import utils.logger.ExtentReportHelper;

import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class ExtentReportListener implements ISuiteListener, IInvokedMethodListener {

    @Override
    public void onStart(ISuite suite) {
        log.info("Report execution started");
        ExtentReportHelper.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("Report execution closed");
        ExtentReportHelper.flushReport();
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            ExtentReportHelper.startTest(method.getTestMethod().getMethodName());
            ExtentReportHelper.getTest().assignCategory(testResult.getTestClass().getRealClass().getSimpleName());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Throwable throwable = testResult.getThrowable();
        String exceptionComment = throwable == null ? null : throwable.getMessage() == null ? throwable.toString() : throwable.getMessage();

        if (testResult.getStatus() == ITestResult.FAILURE) {
            String getMethodName = testResult.getMethod().getConstructorOrMethod().getName();
            String getClassName = testResult.getTestClass().getName().split("\\.")[1];
            log.info("Test class name: " + getClassName + "Test method name: "+getMethodName+ "got failed");
            ExtentReportHelper.getTest().fail("Test class name: "+getClassName+ "Test method name: "+ getMethodName +" got failed");
            ExtentReportHelper.updateResultInReport(ExtentReportHelper.mapTestngStatusToExtentStatus(testResult.getStatus()), exceptionComment);
            if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android"))
                 ExtentReportHelper.addScreenshotOnFailure(BaseTest.getWebDriver(), getMethodName, getClassName);
            else ExtentReportHelper.addScreenshotOnFailure(BaseTest.appiumDriver, getMethodName, getClassName);
        }
    }
}
