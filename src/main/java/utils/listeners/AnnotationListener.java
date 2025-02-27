package utils.listeners;

import constant.ConfigConstant;
import lombok.extern.slf4j.Slf4j;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import utils.RetryUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Slf4j
public class AnnotationListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //Set the invocation count for tests
        int invocationCount = ConfigConstant.INVOCATION_COUNT.isEmpty() ? 1 : Integer.parseInt(ConfigConstant.INVOCATION_COUNT);
        annotation.setInvocationCount(invocationCount);

        //Sets the retry analyzer
        IRetryAnalyzer retry = null;
        try {
            retry = annotation.getRetryAnalyzerClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if (retry == null) {
            annotation.setRetryAnalyzer(RetryUtil.class);
        }

//        if (!classes.isEmpty()) {
//            String classPath[] = testMethod.getDeclaringClass().getName().split("\\.");
//            if (testMethod != null && !classes.contains(classPath[classPath.length - 1])) {
//                annotation.setEnabled(false);
//            }
//        }
    }
}
