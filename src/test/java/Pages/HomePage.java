package Pages;

import com.ea.Framework.Controls.elements.Hyperlink;
import com.ea.Framework.base.BasePage;
import com.ea.Framework.base.DriverContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {


    @FindBy(how= How.LINK_TEXT,using="Login")
    public Hyperlink lnklogin;
    @FindBy(how= How.LINK_TEXT,using="Employee List")
    public Hyperlink linkEmployeeList;
    @FindBy(how= How.XPATH,using="//a [@href=\"/Manage\"]")
    public Hyperlink linkUsername;
    @FindBy(how= How.LINK_TEXT,using="Log off")
    public Hyperlink linkLogoff;
    @FindBy(how= How.XPATH,using="//a[@href=\"/Account/Register\"]")
    public Hyperlink lnkRegister;


    public  LoginPage ClickLogin(){
        lnklogin.ClickLink();
        return Getinstanceof(LoginPage.class);

    }

    public void ClickLogoff() throws InterruptedException {
        linkLogoff.ClickLink();
        Thread.sleep(3000);

    }
    public EmployeeRegistration clickRegister()
    {
        lnkRegister.ClickLink();
        return Getinstanceof(EmployeeRegistration.class);
    }

    public boolean isLogin()

    {
        return lnklogin.isEnabled();

    }
    public String isLinkUsername()

    {
        DriverContext.WaitForElementVisible(linkUsername);
        return linkUsername.getText();
    }

    public String isLoggofftxt()
    {
        DriverContext.WaitForElementVisible(linkLogoff);
        return linkLogoff.getText();

    }
}
