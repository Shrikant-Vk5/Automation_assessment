package Automation.pageObj;

import org.openqa.selenium.By;

public class SaucedemoPage {
        public static final By DOM_USERNAME = By.id("login_credentials");
        public static final By DOM_PASSWORD = By.className("login_password");
        public static final By INPUT_USERNAME = By.id("user-name");
        public static final By INPUT_PASSWORD = By.id("password");
        public static final By LOGIN_BUTTON = By.id("login-button");
        public static final By ERROR_DIALOG = By.cssSelector("form > .error-message-container.error");
        public static final By CHECKOUT_BUTTON = By.id("checkout");
        public static final By FIRSTNAME = By.id("first-name");
        public static final By LASTNAME = By.id("last-name");
        public static final By POSTAL_CODE = By.id("postal-code");
        public static final By CONTINUE = By.id("continue");
        public static final By FINISH = By.id("finish");
        public static final By CART_BUTTON = By.className("shopping_cart_link");
        public static final By CART_ITEM = By.id("cart_item");
        public static final By PRODUCT_ADDCART = By.cssSelector("div.inventory_list .inventory_item .btn");
        public static final By PRODUCT_NAME = By.cssSelector("div.inventory_list .inventory_item .inventory_item_name");
        public static final By FIRST_PRODUCT_NAME = By.cssSelector("div.cart_item .inventory_item_name");
}
