package Utils;

import BastTest.BastTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import BastTest.BastTest;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener , IAnnotationTransformer
{
    public void onTestFailure(ITestResult result)
    {
        String filename = System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
        File f1 =((TakesScreenshot) BastTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f1, new File(filename+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        annotation.setRetryAnalyzer(RetryAnalyser.class);
    }

}
