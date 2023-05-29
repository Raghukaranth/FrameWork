package runner;

import com.google.inject.Inject;
import configuration.ConfigProperty;
import listeners.ExtentReportListener;
import lombok.extern.slf4j.Slf4j;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import utils.file.FilePath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class TestExecutor {
    private ConfigProperty configProperty;
    private static ThreadLocal<String> currentTestMethod = new ThreadLocal<>();
    private static ThreadLocal<String> currentTestClass = new ThreadLocal<>();
    private static TestCaseCount testCaseCount = TestCaseCount.getInstance();
    public static HashMap<Integer, List<String>> testTimeMap = new HashMap<>();
    public static int retryCount = 0;

    public TestExecutor() throws IOException {
        configProperty = ConfigProperty.getInstance(FilePath.CONFIG_PROPS);
    }

    public void runner(List<String> xmlSuites) {
        TestNG testng = new TestNG();
        TestListenerAdapter testListenerAdapter = new TestListenerAdapter();
        testng.addListener(testListenerAdapter);
        testng.setUseDefaultListeners(false);
        testng.setTestSuites(xmlSuites);
        try {
            testng.run();
        } catch (Exception exception) {
            log.info("Inside catch of TestNG run");
            exception.printStackTrace();
        }
        log.info("TestNG run has finished");

        int passedCases = testListenerAdapter.getPassedTests().size();
        int failedCases = testListenerAdapter.getFailedTests().size();
        int skippedCases = testListenerAdapter.getSkippedTests().size() - retryCount;
        int totalCases = passedCases + failedCases + skippedCases;
       log.info("Passed cases : " + passedCases);
       log.info("Failed cases : " + failedCases);
       log.info("Skipped cases : " + skippedCases);
       log.info("Total cases : " + totalCases);

        boolean isTestExecutionFailed = testng.hasFailure();
        if (isTestExecutionFailed)
            log.info("Some of the test cases have failed, please check the report");
    }

    private ArrayList<String> getListeners() {
        ArrayList<String> listeners = new ArrayList<>();
        listeners.add(ExtentReportListener.class.getName());
        return listeners;
    }

    private List<String> getAllSubPackages(String packageName) {
        Path start = Paths.get(FilePath.TEST_DIR_PATH);
        try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
            return stream
                    .map(Path::toFile)
                    .filter(File::isDirectory)
                    .map(d -> d.getAbsolutePath().replace(FilePath.TEST_DIR_PATH + File.separator, "").replace(File.separator, "."))
                    .filter(p -> p.startsWith(packageName))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.info(String.format("Error while getting sub packages of %s. Error -> %s", packageName, e.getMessage()));
            return null;
        }
    }
}
