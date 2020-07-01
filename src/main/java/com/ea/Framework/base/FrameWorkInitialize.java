package com.ea.Framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FrameWorkInitialize extends Base {

    public void InitializeBrowser(BrowserType browserType) {
        WebDriver driver = null;
        {
            switch (browserType) {

                case Chrome: {
                    driver = new ChromeDriver();
                    break;
                }
                case FireFox: {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\bisrout\\Documents\\Selenium\\Driver\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                }
                case IE: {
                    driver = new InternetExplorerDriver();
                    break;
                }
            }
            //Set Driver
            DriverContext.setDriver(driver);
            //Browser
            DriverContext.Browser = new Browser(driver);
        }
    }
}
