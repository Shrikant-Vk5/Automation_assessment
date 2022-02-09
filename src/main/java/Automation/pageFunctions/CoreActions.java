package Automation.pageFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreActions {

    protected final WebDriver bot;
    protected final WebDriverWait waiter;

    protected CoreActions(WebDriver bot) {
        this.bot = bot;
        this.waiter = new WebDriverWait(bot, 5);
    }

    protected boolean waitForVisibility(By element) {
        boolean isVisible = true;
        try {
            waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isVisible = false;
        }
        return isVisible;
    }
    protected Boolean isVisible(By element) {
        try {
            bot.findElement(element);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected List<String> getListItems(By element){
        String el=bot.findElement(element).getText();
        List<String> items= new ArrayList<>(Arrays.asList(el.split("\\r?\\n|\\r")));
        //items.remove(0);
        return items;
    }

    protected void click(By element) {
        bot.findElement(element).click();
    }
    protected void click(WebElement element) {
        element.click();
    }

    protected String readText(By element){
        return (String)(bot.findElement(element).getText());
    }

    protected void selectByText(By element, String str) {
        new Select(bot.findElement(element)).selectByVisibleText(str);
    }

    protected void hoverOver(By element){
        Actions actions = new Actions(bot);
        WebElement ele=bot.findElement(element);
        actions.moveToElement(ele).build().perform();
    }

    protected void enterText(By element, String text) {
        bot.findElement(element).clear();
        bot.findElement(element).sendKeys(text);
    }

    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
