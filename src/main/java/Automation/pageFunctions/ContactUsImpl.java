package Automation.pageFunctions;

import Automation.pageObj.ContactPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContactUsImpl extends CoreActions{

    public ContactUsImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Fill email input")
    public void fillEmail(String fillString) {
        waitForVisibility(ContactPage.EMAIL);
        enterText(ContactPage.EMAIL, fillString);
    }

    @Step("Fill message input")
    public void fillMessage(String fillString) {
        waitForVisibility(ContactPage.MESSAGE);
        enterText(ContactPage.MESSAGE, fillString);
    }

    @Step("click submit")
    public void clickSubmit() {
        waitForVisibility(ContactPage.SUBMIT);
        click(ContactPage.SUBMIT);
    }

    @Step("click the first option from the search list")
    public void selectOption(String text) {
        sleep(0.50);
        selectByText(ContactPage.SEARCH_LIST, text);
    }
    @Step("Success Shown")
    public boolean verifySuccessAlert() {
        return waitForVisibility(ContactPage.ALERT_SUCCESS);
    }
    @Step("Alert Shown")
    public boolean verifyFailureAlert() {
        return waitForVisibility(ContactPage.ALERT_FAIL);
    }

}
