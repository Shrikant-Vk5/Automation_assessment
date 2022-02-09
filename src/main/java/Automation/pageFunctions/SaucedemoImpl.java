package Automation.pageFunctions;

import Automation.pageObj.SaucedemoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaucedemoImpl extends CoreActions{

    String finalProductName;

    public SaucedemoImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Try filling different given login credentials")
    public void fillDomLogin() {
        List<String> usern=getListItems(SaucedemoPage.DOM_USERNAME);
        List<String> passw=getListItems(SaucedemoPage.DOM_PASSWORD);
        for(int i=0;i<usern.size();i++){
            for(int j=0;j<passw.size();j++){
                enterText(SaucedemoPage.INPUT_USERNAME,usern.get(i));
                enterText(SaucedemoPage.INPUT_PASSWORD,passw.get(j));

                click(SaucedemoPage.LOGIN_BUTTON);
                if(isVisible(SaucedemoPage.LOGIN_BUTTON)){
                    if(!waitForVisibility(SaucedemoPage.ERROR_DIALOG)){
                        System.out.println("Username "+usern.get(i)+"\t"+"Password "+passw.get(j));
                        break;
                    }
                }
            }
            if(!isVisible(SaucedemoPage.LOGIN_BUTTON)){
                break;
            }
        }
    }
    @Step("Add the first Product to cart")
    public void addFirstProductToCart() {
        sleep(1);
        List<WebElement> productName=bot.findElements(SaucedemoPage.PRODUCT_NAME);
        List<WebElement> productAdd=bot.findElements(SaucedemoPage.PRODUCT_ADDCART);
        finalProductName=productName.get(0).getText();
        System.out.println("Product Name : " + productName.get(0).getText());
        click(productAdd.get(0));
    }

    @Step("Click on open cart")
    public void openCart() {
        sleep(1);
        click(SaucedemoPage.CART_BUTTON);
    }

    @Step("Verify product name added.")
    public boolean verifyProductName() {
        if(finalProductName.equalsIgnoreCase(readText(SaucedemoPage.FIRST_PRODUCT_NAME)))
            return true;
        return false;
    }

    @Step("Checkout the product")
    public void checkoutProduct() {
        sleep(1);
        click(SaucedemoPage.CHECKOUT_BUTTON);
    }
    @Step("Fill the user inputs for checkout")
    public void fillInput() {
        sleep(1);
        enterText(SaucedemoPage.FIRSTNAME,"John");
        enterText(SaucedemoPage.LASTNAME,"Doe");
        enterText(SaucedemoPage.POSTAL_CODE,"201202");
    }
    @Step("Click continue and finish the checkout.")
    public void clickContinueAndFinishCheckout() {
        sleep(1);
        click(SaucedemoPage.CONTINUE);
        click(SaucedemoPage.FINISH);
    }

    @Step("Check number of Product in cart.")
    public int NumberOfProductsInCart() {
        sleep(1);
        click(SaucedemoPage.CART_BUTTON);
        List<WebElement> cartItems= bot.findElements(SaucedemoPage.CART_ITEM);
        System.out.println("There are "+cartItems.size()+" items in cart.");
        return cartItems.size();
    }
}
