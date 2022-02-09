package testClasses;

import Automation.pageFunctions.SaucedemoImpl;
import core.CoreTestSauceDemo;
import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SaucedemoTests extends CoreTestSauceDemo {

    SaucedemoImpl demo;

    @Test
    @Description("creating impl objects before class")
    public void initImpl() {
        demo = new SaucedemoImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("test that the user can launch site and add a item and check the cart")
    public void test_saucedemo_product_checkout() {
        demo.fillDomLogin();
        demo.addFirstProductToCart();
        demo.openCart();
        Assert.assertTrue(demo.verifyProductName(), "Verified Product Name");
        demo.checkoutProduct();
        demo.fillInput();
        demo.clickContinueAndFinishCheckout();
        Assert.assertTrue(demo.NumberOfProductsInCart()==0, "0 items in cart");
    }
}
