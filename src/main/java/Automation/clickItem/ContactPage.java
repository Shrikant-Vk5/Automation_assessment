package Automation.clickItem;

import org.openqa.selenium.By;

public class ContactPage {
    public static final By SUBMIT= By.id("submitMessage");
    public static final By EMAIL = By.id("email");
    public static final By MESSAGE = By.id("message");
    public static final By ALERT_SUCCESS = By.cssSelector(".alert.alert-success");
    public static final By ALERT_FAIL = By.cssSelector(".alert.alert-danger");
    public static final By SEARCH_LIST = By.id("id_contact");
}