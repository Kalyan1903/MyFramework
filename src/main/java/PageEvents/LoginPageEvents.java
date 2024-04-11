package PageEvents;

import PageObjects.LoginPageElements;
import Utils.ElementFetch;
import org.testng.Assert;

public class LoginPageEvents
{
    ElementFetch ele = new ElementFetch();
    public void verifyHomePageDisplayed()
    {

        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.submitButton).size()>0,"ELement not Found");
    }
    public void enterCredentials()
    {
        ele.getWebElement("XPATH",LoginPageElements.userNameLogin).sendKeys("kalyanpabbathi@gamail.com");
        ele.getWebElement("XPATH",LoginPageElements.passwordLogin).sendKeys("12345");
    }


}
