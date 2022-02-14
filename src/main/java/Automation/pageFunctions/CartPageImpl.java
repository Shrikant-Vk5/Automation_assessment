package Automation.pageFunctions;

import Automation.pageObj.CartPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPageImpl extends CoreActions{

    public CartPageImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Click on open cart")
    public void openCart() {
        sleep(1);
        click(CartPage.CART_BUTTON);
    }

    @Step("Verify product name added.")
    public boolean verifyProductName(String finalProductName) {
        if(finalProductName.equalsIgnoreCase(readText(CartPage.FIRST_PRODUCT_NAME)))
            return true;
        return false;
    }

    @Step("Checkout the product")
    public void checkoutProduct() {
        sleep(1);
        click(CartPage.CHECKOUT_BUTTON);
    }

    @Step("Check number of Product in cart.")
    public int NumberOfProductsInCart() {
        sleep(1);
        click(CartPage.CART_BUTTON);
        List<WebElement> cartItems= bot.findElements(CartPage.CART_ITEM);
        System.out.println("There are "+cartItems.size()+" items in cart.");
        return cartItems.size();
    }
}
