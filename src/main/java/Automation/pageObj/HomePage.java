package Automation.pageObj;

import org.openqa.selenium.By;

public class HomePage {

    public static final By DOM_USERNAME = By.id("login_credentials");
    public static final By DOM_PASSWORD = By.className("login_password");
    public static final By INPUT_USERNAME = By.id("user-name");
    public static final By INPUT_PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_DIALOG = By.cssSelector("form > .error-message-container.error");

}
