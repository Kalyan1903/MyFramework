package qa.tests;

import BastTest.BastTest;
import PageEvents.HomePageEvents;
import PageEvents.LoginPageEvents;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 extends BastTest

{
    HomePageEvents HomePage = new HomePageEvents();
    LoginPageEvents LoginPage = new LoginPageEvents();
    @Test
    @Parameters("browser")
    public void methodForEnteringCredentials(String browser)
    {
        WebDriver driver = super.setupDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.Seconds));
        Logger.info("Signin into LoginPage");
        HomePage.signInButton();
        Logger.info("Verify into LoginPage");

        Logger.info("Enter the details");
        LoginPage.enterCredentials();
    }

    @Test
    public void test2(){
        System.out.println("test 2 ran");
        WebDriver driver = super.setupDriver("chrome");
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }


}