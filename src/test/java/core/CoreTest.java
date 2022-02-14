package core;

import Automation.BotDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CoreTest {

    protected WebDriver bot;

    protected static final String URL = "https://www.saucedemo.com/";


    @BeforeClass
    public void openBrowser() {
        bot = new BotDriver().getBot();
        bot.get(URL);
    }

    protected static void logStep(String step) {
        System.out.println(step);
    }

    @AfterClass
    public void close() {
            bot.quit();
    }

}
