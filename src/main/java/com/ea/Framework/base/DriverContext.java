package com.ea.Framework.base;

import com.ea.Framework.Config.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext{

    public static WebDriver Driver;
    public static Browser Browser;

    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }


    public static void WaitForPageToLoad()
    {
        WebDriverWait wait = new WebDriverWait(Driver,30);
        JavascriptExecutor jsExecuter = (JavascriptExecutor)Driver;
        ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor)Driver)
                .executeScript("return document.readyState").toString().equals("complete");
        //Get js Ready
        boolean jsReady = jsExecuter.executeScript("return document.readyState").toString().equals("complete");
        if(!jsReady)
        {
            wait.until(jsLoad);
        }
        else
        {
            Settings.log.Write("Page is ready");
        }
    }

    public static void WaitForElementVisible(final WebElement elementFindBy)
    {
        WebDriverWait wait = new WebDriverWait(Driver,30);
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));

    }

    public static void WaitForElementTextVisible(final WebElement elementFindBy,String text)
    {
        WebDriverWait wait = new WebDriverWait(Driver,30);
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy,text));

    }
    public static void WaitForElementTextDisplayed(final By elementFindBy,String text)
    {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(textDisplayed(elementFindBy, text));

    }
    private static ExpectedCondition<Boolean> textDisplayed(final By elementFindBy, final String text)
    {
        return webDriver -> webDriver.findElement(elementFindBy).getText().contains(text);
    }
    public static void waitFortheElementEnabled (final By elementFindBy)
    {
        WebDriverWait wait = new WebDriverWait(Driver, 30);
        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
    }
}
