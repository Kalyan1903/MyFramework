package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    int count = 0;
    int retrycount = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        while(count<retrycount)
        {
            count++;
            return true;
        }
        return false;
    }
}
