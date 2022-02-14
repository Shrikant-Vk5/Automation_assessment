package Automation.pageFunctions;

import Automation.pageObj.ProductListPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageImpl extends CoreActions{

    private String finalProductName;

    public ProductListPageImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Add the first Product to cart")
    public void addFirstProductToCart() {
        sleep(1);
        List<WebElement> productName=bot.findElements(ProductListPage.PRODUCT_NAME);
        List<WebElement> productAdd=bot.findElements(ProductListPage.PRODUCT_ADDCART);
        finalProductName=productName.get(0).getText();
        System.out.println("Product Name : " + finalProductName);
        click(productAdd.get(0));
    }

    public String getSelectedProductName(){
        return finalProductName;
    }
}
