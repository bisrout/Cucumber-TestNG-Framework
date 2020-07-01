package com.ea.Framework.base;

import com.ea.Framework.Controls.api.ControlFactory;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public  static BasePage currentpage;

    public <TPage extends BasePage>TPage Getinstanceof(Class<TPage> Page){
        //Object obj = PageFactory.initElements(DriverContext.Driver,Page);
        //CustomControl PageFactory Initialization
        Object obj = ControlFactory.initElements(DriverContext.Driver,Page);
        return Page.cast(obj);
    }

}
