package utils;

import configuration.ConfigProperty;
import constant.ConfigConstant;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.file.FilePath;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryUtil implements IRetryAnalyzer {
    private ConfigProperty configProperty;
    private AtomicInteger COUNTER;

    public RetryUtil() {
        configProperty = ConfigProperty.getInstance(FilePath.CONFIG_PROPS);
        COUNTER = new AtomicInteger(0);
    }


    @Override
    public boolean retry(ITestResult result) {
        int maxRetryCount = 0;
        try {
            maxRetryCount = ConfigConstant.RETRY_COUNT == null ? 0 : Integer.parseInt(ConfigConstant.RETRY_COUNT);
        } catch (Exception e) { maxRetryCount = 0; }
        boolean value = !result.isSuccess() && COUNTER.incrementAndGet() <= maxRetryCount;
        return value;
    }
}
