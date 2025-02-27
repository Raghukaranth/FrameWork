package utils.logger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.aventstack.extentreports.ExtentTest;

public class ExtentLogAppender extends AppenderBase<ILoggingEvent> {
    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        ExtentTest extentTest = ExtentReportHelper.getTest();
        String log = iLoggingEvent.getFormattedMessage();

        if (extentTest == null || log == null || log.trim().isEmpty())
            return;

        switch (iLoggingEvent.getLevel().toInt()) {
            case Level.ERROR_INT:
                extentTest.fail(log);
                return;
            default:
                extentTest.info(log);
        }
    }
}
