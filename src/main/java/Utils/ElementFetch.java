package Utils;

import BastTest.BastTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch
{
    public WebElement getWebElement(String identifierType, String IdentifierValue)
    {
        switch (identifierType)
        {
            case "XPATH":
            return BastTest.driver.findElement(By.xpath(IdentifierValue));
            case "CSS":
                return  BastTest.driver.findElement(By.cssSelector(IdentifierValue));
            case "ID":
                return  BastTest.driver.findElement(By.id(IdentifierValue));
            case "NAME":
                return  BastTest.driver.findElement(By.name(IdentifierValue));
            case "TAGNAME":
                    return  BastTest.driver.findElement(By.tagName(IdentifierValue));
            default:
                return null;

        }

    }
    public List<WebElement> getWebElements(String identifierType, String IdentifierValue)
    {
        switch (identifierType)
        {
            case "XPATH":
                return BastTest.driver.findElements(By.xpath(IdentifierValue));
            case "CSS":
                return  BastTest.driver.findElements(By.cssSelector(IdentifierValue));
            case "ID":
                return  BastTest.driver.findElements(By.id(IdentifierValue));
            case "NAME":
                return  BastTest.driver.findElements(By.name(IdentifierValue));
            case "TAGNAME":
                return  BastTest.driver.findElements(By.tagName(IdentifierValue));
            default:
                return null;

        }

    }



}
