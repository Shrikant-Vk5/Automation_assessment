package testClasses;

import Automation.pageFunctions.*;
import Automation.pageObj.CheckoutPage;
import core.CoreTest;
import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SaucedemoTests extends CoreTest {

    HomePageImpl home;
    ProductListPageImpl product;
    CartPageImpl cart;
    CheckoutImpl check;

    @Test
    @Description("creating impl objects before class")
    public void initImpl() {
        home = new HomePageImpl(bot);
        product =new ProductListPageImpl(bot);
        cart=new CartPageImpl(bot);
        check=new CheckoutImpl(bot);
    }

    @Test(dependsOnMethods = "initImpl")
    @Description("test that the user can launch site and add a item and check the cart")
    public void test_saucedemo_product_checkout() {
        home.fillDomLogin();
        product.addFirstProductToCart();
        cart.openCart();

        String productName=product.getSelectedProductName();
        Assert.assertTrue(cart.verifyProductName(productName), "Verified Product Name");

        cart.checkoutProduct();
        check.fillInput();
        check.clickContinueAndFinishCheckout();
        Assert.assertTrue(cart.NumberOfProductsInCart()==0, "No items in cart");
    }
}
