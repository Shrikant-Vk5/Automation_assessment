package Automation.pageObj;

import org.openqa.selenium.By;

public class CartPage {

    public static final By FIRST_PRODUCT_NAME = By.cssSelector("div.cart_item .inventory_item_name");
    public static final By CART_BUTTON = By.className("shopping_cart_link");
    public static final By CART_ITEM = By.id("cart_item");
    public static final By CHECKOUT_BUTTON = By.id("checkout");

}
