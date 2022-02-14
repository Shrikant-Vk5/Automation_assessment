package Automation.pageFunctions;

import Automation.pageObj.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageImpl extends CoreActions {

    public HomePageImpl(WebDriver bot) {
        super(bot);
    }

    @Step("click on contact us")
    public void clickContact() {
        waitForVisibility(HomePage.CONTACT_US);
        click(HomePage.CONTACT_US);
    }

    @Step("hover on women tab")
    public void hoverWomenTab() {
        waitForVisibility(HomePage.WOMEN_TAB);
        hoverOver(HomePage.WOMEN_TAB);
    }

    @Step("click on casual dresses")
    public void clickCasualDresses() {
        sleep(1);
        waitForVisibility(HomePage.CASUAL_SN);
        click(HomePage.CASUAL_SN);
    }
    @Step("check if the user has arrived on the correct url page")
    public boolean hasArrivedOnPage(String url) {
        return bot.getCurrentUrl().contains(url);
    }

}
