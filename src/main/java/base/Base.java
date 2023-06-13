package base;

import org.testng.annotations.Test;
import runner.TestRunner;

import java.util.Arrays;

public class Base {
    @Test
    public static void mainTest()  {
        TestRunner testRunner = new TestRunner();
        testRunner.runTest(Arrays.asList("./testng.xml"));
    }
}
