package SeleniumTest;
import Pages.HomePage;
import Pages.LoginPage;
import Steps.TestInitialize;
import com.ea.Framework.Config.ConfigReader;
import com.ea.Framework.Config.Settings;

import com.ea.Framework.Utilities.DataBaseUtil;
import com.ea.Framework.Utilities.ExcelUtil;
import com.ea.Framework.Utilities.LogUtil;
import com.ea.Framework.Utilities.ReportingUtil;
import com.ea.Framework.base.BrowserType;
import com.ea.Framework.base.DriverContext;
import jxl.read.biff.BiffException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginTest extends TestInitialize {
    public ExcelUtil util;
    public Connection conn;




    @Test

    public void Login(){
        /*LoginPage ln = new LoginPage();
        HomePage hp = new HomePage();
        //LoginPage Login =hp.ClickLogin();
        currentpage = hp.ClickLogin();*/
        Settings.log.Write("Home Page logged in");
        currentpage=Getinstanceof(HomePage.class);
        currentpage = currentpage.As(HomePage.class).ClickLogin();
        //((LoginPage)currentpage).Login("Biswajit", "Biswa@789");
        //currentpage.As(LoginPage.class).Login("Biswajit", "Biswa@789");
        currentpage.As(LoginPage.class).Login(util.ReadCell("UserName",1), util.ReadCell("PassWord",1));

        }
    }

