package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import utils.file.FilePath;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

    private static WebDriver webDriver = BaseTest.getWebDriver();

    public static String takeScreenshotAtEndOfTest(String testcaseName) {
        String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)webDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = FilePath.SCREEN_SHOT_PATH + testcaseName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileHandler.copy(source, finalDestination);
        } catch(IOException e) { }
        return destination;
    }
}
