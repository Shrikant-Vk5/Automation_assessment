package Automation.clickItem;

import org.openqa.selenium.By;

public class CheckoutPage {

    public static final By PRODUCT_PRICE = By.className("product-price");
    public static final By ADD_IN_CART = By.xpath("//a[@title='Add to cart']");
    public static final By PROCEED_CHECKOUT = By.xpath("//a[@title='Proceed to checkout']");
    public static final By FIRST_PRODUCT = By.cssSelector("ul.product_list > li");
    public static final By PRODUCT_NAME = By.cssSelector(".product-container h5 a.product-name");
    public static final By FINAL_PRODUCT_NAME = By.cssSelector("#cart_summary p.product-name a");
    public static final By FINAL_PRODUCT_PRICE = By.id("total_product");
}
