package testClasses;

import Automation.pageFunctions.ContactUsImpl;
import core.CoreTest;
import Automation.pageFunctions.HomePageImpl;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends CoreTest {

    HomePageImpl home;
    ContactUsImpl cont;

    @Test
    @Description("creating impl objects before class")
    public void initImpl() {
        home = new HomePageImpl(bot);
        cont = new ContactUsImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("test that the user can launch site and enter valid credential")
    public void test_enter_valid_credentials() {
        logStep("Site is opened");
        logStep("clicked contact us");
        home.clickContact();

        logStep("select option");
        cont.selectOption("Customer service");

        logStep("fill mail");
        cont.fillEmail("Strix@gmail.com");

        logStep("fill message");
        cont.fillMessage("Hello");

        logStep("click submit");
        cont.clickSubmit();
        Assert.assertTrue(cont.verifySuccessAlert(), "Submission is Successful");
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("test that the user can launch site and enter invalid credential")
    public void test_enter_invalid_credentials() {
        logStep("Site is opened");
        logStep("clicked contact us");
        home.clickContact();

        logStep("select option");
        cont.selectOption("Customer service");

        logStep("fill mail");
        cont.fillEmail("Strixgmail.com");

        logStep("fill message");
        cont.fillMessage("Hello");

        logStep("click submit");
        cont.clickSubmit();
        Assert.assertTrue(cont.verifyFailureAlert(), "Submission is not Successful");
    }
}
