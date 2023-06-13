package runner;

import java.util.List;

public class TestRunner {
    private TestExecutor testExecutor;
    public TestRunner() {
        try {
            testExecutor = new TestExecutor();
        } catch(Exception e) { }
    }

    public void runTest(List<String> xmlSuites) {
        testExecutor.runner(xmlSuites);
    }
}
