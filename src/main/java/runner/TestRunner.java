package runner;

import java.util.List;

public class TestRunner {
    private TestExecutor testExecutor;
    public TestRunner()  throws Exception {
        testExecutor = new TestExecutor();
    }

    public void runTest(List<String> xmlSuites) {
        testExecutor.runner(xmlSuites);
    }
}
