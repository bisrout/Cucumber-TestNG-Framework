package Steps;

import Pages.EmployeeRegistration;
import Pages.HomePage;
import com.ea.Framework.base.Base;
import com.ea.Framework.base.DriverContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class EmployyeeReg extends Base {
    @And("^I ensure logged off$")
    public void iEnsureLoggedOff() throws InterruptedException {

        currentpage=Getinstanceof(HomePage.class);


    }

    @Then("^I click Registration Link$")
    public void iClickRegistrationLink() throws InterruptedException {
        currentpage=currentpage.As(HomePage.class).clickRegister();
        DriverContext.WaitForPageToLoad();


    }

    @When("^enter details$")
    public void enterdetails() throws InterruptedException {


        int rand_User = currentpage.As(EmployeeRegistration.class).generateRandom();
        int rand_pwd = currentpage.As(EmployeeRegistration.class).generateRandom();
        int rand_ID = currentpage.As(EmployeeRegistration.class).generateRandom();
        currentpage.As(EmployeeRegistration.class).RegistrationProcess("Ahdfd"+rand_User,"Ldeferf"+"_"+rand_pwd,"cdeded"+rand_ID+"@gmail.com");

    }

    @Then("^I click RegisterButton$")
    public void iClickRegisterButton()
    {
        currentpage=currentpage.As(EmployeeRegistration.class).clickRegisterbtn();
    }

    @Then("^I should get username with hello$")
    public void iShouldGetUsernameWithHello() {
        Assert.assertEquals("Home Page is not arrived",currentpage.As(HomePage.class).isLoggofftxt(),"Log off");

    }

}
