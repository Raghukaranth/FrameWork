package runner;

import lombok.Setter;
import lombok.Getter;

public class TestCaseCount {
    private static TestCaseCount testCaseCount;

    @Getter
    @Setter
    private int passed;

    @Getter
    @Setter
    private int skipped;

    @Getter
    @Setter
    private int failed;

    public static synchronized TestCaseCount getInstance() {
        if (testCaseCount == null) {
            synchronized (TestCaseCount.class) {
                if (testCaseCount == null) {
                    testCaseCount = new TestCaseCount();
                }
            }
        }
        return testCaseCount;
    }
}
