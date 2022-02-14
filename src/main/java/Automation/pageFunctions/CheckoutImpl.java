package Automation.pageFunctions;

import Automation.pageObj.CheckoutPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckoutImpl extends CoreActions{

    public CheckoutImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Fill the user inputs for checkout")
    public void fillInput() {
        sleep(1);
        enterText(CheckoutPage.FIRSTNAME,"John");
        enterText(CheckoutPage.LASTNAME,"Doe");
        enterText(CheckoutPage.POSTAL_CODE,"201202");
    }

    @Step("Click continue and finish the checkout.")
    public void clickContinueAndFinishCheckout() {
        sleep(1);
        click(CheckoutPage.CONTINUE);
        click(CheckoutPage.FINISH);
    }

}
