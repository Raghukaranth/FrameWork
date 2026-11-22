package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    public static synchronized ExtentReports getReports(String reportPath) {
        if(extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("TestNG Execution Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static void setTest(ExtentTest test) {
        currentTest.set(test);
    }

    public static ExtentTest getTest() {
        return currentTest.get();
    }

    public static void unload() {
        currentTest.remove();
    }
}
