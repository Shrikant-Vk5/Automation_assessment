package testClasses;

import Automation.pageFunctions.CheckoutImpl;
import core.CoreTest;
import Automation.pageFunctions.HomePageImpl;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends CoreTest {

    HomePageImpl home;
    CheckoutImpl check;

    @Test
    @Description("creating impl objects before class")
    public void initImpl() {
        home = new HomePageImpl(bot);
        check = new CheckoutImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("test that the user can launch site, choose product and checkout product")
    public void test_checkout_product() {
        logStep("Site is opened");
        logStep("clicked women section");
        home.hoverWomenTab();
        logStep("clicked casual dress section");
        home.clickCasualDresses();
        logStep("add first dress visible to cart");
        check.clickAddFirstDress();
        logStep("proceed to card");
        check.clickToCart();
        Assert.assertTrue(check.verifyDressAdded(),"Dress is same chosen one");
        Assert.assertTrue(check.verifyCartPrice(),"Cart total price matches to dress price");
    }
}
