package Automation.actions;

import Automation.clickItem.CheckoutPage;
import Automation.clickItem.ContactPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutImpl extends CoreActions{

    protected String productName="";
    protected String productPrice="";

    public CheckoutImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Adding first Product")
    public void clickAddFirstDress() {
        waitForVisibility(CheckoutPage.ADD_IN_CART);
        hoverOver(CheckoutPage.FIRST_PRODUCT);
        click(CheckoutPage.ADD_IN_CART);
        productName=readText(CheckoutPage.PRODUCT_NAME);
        productPrice=readText(CheckoutPage.PRODUCT_PRICE);
    }

    @Step("Proceeding to cart")
    public void clickToCart() {
        waitForVisibility(CheckoutPage.PROCEED_CHECKOUT);
        click(CheckoutPage.PROCEED_CHECKOUT);
    }

    @Step("Verify Dress is same as added")
    public boolean verifyDressAdded() {
//        System.out.println(productName+"--"+readText(CheckoutPage.FINAL_PRODUCT_NAME));
        if(productName.equalsIgnoreCase(readText(CheckoutPage.FINAL_PRODUCT_NAME)))
            return true;
        return false;
    }

    @Step("Verify final Price is same as chosen product")
    public boolean verifyCartPrice() {
//        System.out.println(productPrice+"--"+readText(CheckoutPage.FINAL_PRODUCT_PRICE));
        if(productPrice.equalsIgnoreCase(readText(CheckoutPage.FINAL_PRODUCT_PRICE)))
            return true;
        return false;
    }
}
