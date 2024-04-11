package BastTest;

import Utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BastTest
{
    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest Logger;
    @BeforeTest
    public void beforeTestMethod()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String localDateTime = LocalDateTime.now().format(formatter);
          sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "TESTINGREPORT_" + localDateTime + ".html");
          extent = new ExtentReports();
          extent.attachReporter(sparkReporter);
          sparkReporter.config().setTheme(Theme.STANDARD);
          extent.setSystemInfo("HostName", "Kalyan");
          extent.setSystemInfo("Username", "nothing");
          sparkReporter.config().setDocumentTitle("Automation Report");
          sparkReporter.config().setReportName("Test Results of Automation");
    }
    @BeforeMethod
    public void beforeMethodMethod(Method testMethod)
    {
        Logger = extent.createTest(testMethod.getName());
       // setupDriver(Browser);





    }
    @AfterMethod
    public void afterMethod(ITestResult result)
    {

              if(result.getStatus() == ITestResult.FAILURE)
              {
                  Logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" - Test Case Failed", ExtentColor.RED));
                  Logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +" - Test Case Failed", ExtentColor.RED));
              }
              else if(result.getStatus() == ITestResult.SKIP)
              {
                  Logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
              }
              else if(result.getStatus() == ITestResult.SUCCESS) {
                  Logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case Passed", ExtentColor.GREEN));
              }
              driver.quit();
    }
@AfterTest
    public void AfterTest()
{
    extent.flush();
    }

    public WebDriver setupDriver(String Browser)
    {
        if(Browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(Browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(Browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new InternetExplorerDriver();
        }
        return driver;
    }



}
