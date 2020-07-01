package com.ea.Framework.Controls.internals;

import com.ea.Framework.Controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {

}
