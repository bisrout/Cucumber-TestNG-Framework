package com.ea.Framework.base;

import org.openqa.selenium.WebDriver;

public class Browser {

    private WebDriver _Driver;

    public Browser(WebDriver _Driver) {
        this._Driver = _Driver;
    }

    //public BrowserType Type;
    public void GoToUrl(String url)
    {
        _Driver.get(url);
    }
    public void Maximize()
    {
        _Driver.manage().window().maximize();
    }

}
