package constant;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import javafx.beans.NamedArg;

public class ConfigConstant {
    private static  String INCLUDE_TEST_GROUPS;
    public static String RETRY_COUNT;
    public static String PLATFORM;
    public static String TEST_CLASSES;
    public static String PACKAGE_NAME;
    public static String INVOCATION_COUNT;

    @Inject
    public ConfigConstant(
            @Named("platform")String platform,
            @Named("retryCount") String retryCount,
            @Named("classes") String classes,
            @Named("packageName") String packageName,
            @Named("includedTestGroups") String includedTestGroups,
            @Named("invocationCount") String invocationCount
    ) {
        ConfigConstant.PLATFORM = platform;
        ConfigConstant.RETRY_COUNT = retryCount;
        ConfigConstant.TEST_CLASSES = classes;
        ConfigConstant.PACKAGE_NAME = packageName;
        ConfigConstant.INCLUDE_TEST_GROUPS = includedTestGroups;
        ConfigConstant.INVOCATION_COUNT = invocationCount;
    }
}
