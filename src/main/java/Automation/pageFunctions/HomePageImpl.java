package Automation.pageFunctions;

import Automation.pageObj.HomePage;
import Automation.pageObj.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePageImpl extends CoreActions {

    public HomePageImpl(WebDriver bot) {
        super(bot);
    }

    @Step("Try filling different given login credentials")
    public void fillDomLogin() {
        List<String> usern=getListItems(HomePage.DOM_USERNAME);
        List<String> passw=getListItems(HomePage.DOM_PASSWORD);
        for(int i=0;i<usern.size();i++){
            for(int j=0;j<passw.size();j++){
                enterText(HomePage.INPUT_USERNAME,usern.get(i));
                enterText(HomePage.INPUT_PASSWORD,passw.get(j));

                click(HomePage.LOGIN_BUTTON);
                if(isVisible(HomePage.LOGIN_BUTTON)){
                    if(!waitForVisibility(HomePage.ERROR_DIALOG)){
                        System.out.println("Username "+usern.get(i)+"\t"+"Password "+passw.get(j));
                        break;
                    }
                }
            }
            if(!isVisible(HomePage.LOGIN_BUTTON)){
                break;
            }
        }
    }

}
