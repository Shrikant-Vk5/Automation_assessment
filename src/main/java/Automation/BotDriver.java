package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BotDriver {

    private final WebDriver driver;

    public BotDriver() {
        this.driver = new ChromeDriver();
    }

    public WebDriver getBot() {
        return driver;
    }
}
