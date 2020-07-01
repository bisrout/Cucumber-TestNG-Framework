package Steps;


import com.ea.Framework.Utilities.CucumberUtil;
import com.ea.Framework.base.Base;
import Pages.HomePage;
import Pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.sql.SQLException;

public class LoginStep extends Base {
    @And("I ensure application opened")
    public void iEnsureApplicationOpened() {
        currentpage=Getinstanceof(HomePage.class);
        Assert.assertTrue("The login page is not loaded",currentpage.As(HomePage.class).isLogin());
    }

    @Then("I click login link")
    public void iClickLoginLink() {

        currentpage=currentpage.As(HomePage.class).ClickLogin();
    }

    @When("I enter Username and Password")
    public void iEnterUsernameAndPassword(DataTable data) {
        //List<List<String>> table = data.raw();
        CucumberUtil.ConvertDatatableToDict(data);
        //currentpage.As(LoginPage.class).Login(table.get(1).get(0).toString(),table.get(1).get(1).toString());
        //currentpage.As(LoginPage.class).Login(CucumberUtil.GetCellValue("UserName"),CucumberUtil.GetCellValue("Password"));
        currentpage.As(LoginPage.class).Login(CucumberUtil.GetCellValueWithRowIndex("UserName",1),CucumberUtil.GetCellValueWithRowIndex("Password",1));
    }

    @Then("I click login button")
    public void iClickLoginButton() {
        currentpage=currentpage.As(LoginPage.class).clickLogin();
    }

    @Then("I should see username with hello")
    public void iShouldSeeUsernameWithHello() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //ReportingUtil.WriteTestResult(DataBaseUtil.Open(Settings.ReportingConnectionString),Settings.FeatureContext,Settings.ScenarioContext,"Validate user","","PASSED");
        Assert.assertEquals("Home Page is not arrived",currentpage.As(HomePage.class).isLinkUsername(),"Hello biswajit!");

    }

}
