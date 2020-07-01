package Steps;

import com.ea.Framework.Config.ConfigReader;
import com.ea.Framework.Config.Settings;
import com.ea.Framework.Utilities.DataBaseUtil;
import com.ea.Framework.Utilities.ExcelUtil;
import com.ea.Framework.Utilities.LogUtil;
import com.ea.Framework.Utilities.ReportingUtil;
import com.ea.Framework.base.BrowserType;
import com.ea.Framework.base.DriverContext;
import com.ea.Framework.base.FrameWorkInitialize;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import jxl.read.biff.BiffException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestInitialize extends FrameWorkInitialize {
    public ExcelUtil util;
    public Connection conn;


    @Before
    public void Initialize() throws IOException, BiffException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //Initializing Config
        ConfigReader.PopulateSettings();
        //Logging
        Settings.log = new LogUtil();
        Settings.log.CreateLogFile();
        Settings.log.Write("FrameWork Initialize");
        //Create Test cycle for reporting
        //Settings.ReportingConnection =DataBaseUtil.Open(Settings.ReportingConnectionString);
        ReportingUtil.CreateTestCycle(DataBaseUtil.Open(Settings.ReportingConnectionString));
        String statement ="SELECT * FROM Employees";
        try
        {
            DataBaseUtil.ExecuteQuery(statement,DataBaseUtil.Open(Settings.AUTConnectionString));
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        Settings.log.Write("Browser Started");
        InitializeBrowser(BrowserType.FireFox);
        Settings.log.Write("Navigated to URL");
        DriverContext.Browser.GoToUrl(Settings.URL);
        ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);


    }
    @After
    public void killBrowser(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)DriverContext.Driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        DriverContext.Driver.close();

    }

}
