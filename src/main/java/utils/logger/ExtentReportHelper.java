package utils.logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import utils.ScreenShotUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import static sun.management.Agent.error;

@Slf4j
public class ExtentReportHelper {
    private static ExtentReports extentReports;
    private static String fileSeparator = System.getProperty("file.separator");
    private static String reportFilePath = System.getProperty("user.dir") + fileSeparator + "TestReport";
    private static String reportFileLocator = reportFilePath + fileSeparator + "report.html";
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static String screenshotsPath = System.getProperty("user.dir") + "/screenshots";

    public static ExtentReports initReport() {
        if(extentReports == null)
            createInstance();
        return extentReports;
    }

    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilePath);
        String gitBranchName = getCurrentGitBranch();

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Test Report: "+ "");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setReportName("Test Report: "+ "");
        extentReports = new ExtentReports();

        if(gitBranchName != null)
            extentReports.setSystemInfo("Git Branch", gitBranchName);
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if(!testDirectory.exists()) {
            if(testDirectory.mkdir()) {
                return reportFileLocator;
            } else return System
                    .getProperty("user.dir");
        }
        return reportFileLocator;
    }

    private static String getCurrentGitBranch() {
        String gitBranchName = null;
        try {
            Process process = Runtime.getRuntime().exec("git rev-parse --abbrev-ref HEAD");
            process.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            gitBranchName = reader.readLine();
            process.destroy();
            reader.close();
        } catch (Exception e) {
            error("Error while executing Command: [git rev-parse --abbrev-ref HEAD] | Exception: " + e.getMessage());
        }
        return gitBranchName;
    }

    public static void flushReport() {
        extentReports.flush();
        extentReports = null;
    }

    public static  void startTest(String testName) {
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return  extentTest.get();
    }

    public static void addScreenshotOnFailure(WebDriver driver, String testname, String testClassName) {
        try {
            ExtentReportHelper.getTest().fail("Screenshot Of Failed Screen", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.takeScreenshotAtEndOfTest(testClassName)).build());
        } catch (Exception e) {
            log.error("Error While Taking Screenshot: " + e.getMessage());
            updateResultInReport(Status.FAIL, null);
        }
    }

    public static void updateResultInReport(Status status, String comment) {
        comment = comment == null ? "" : comment;
        extentTest.get().log(status, comment);
    }
}
