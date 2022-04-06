package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ConfigUtil;
import utilities.TestBase;
import utilities.actions.ElementActions;

public class HomePage extends ElementActions{
	//=============================Locators==================================
    By signIn = By.cssSelector("a[title='Log in to your customer account']");
    //=============================Strings==================================
   
    //===================================Actions===================================
    public void openAutomationPractice() {
        System.out.println(ConfigUtil.Web_URL);
        driver.navigate().to(ConfigUtil.Web_URL);
    }
    
    public void clickSignIn()
    {
    	getElement(signIn).click();
    }
    //-----------------------------------Assertions--------------------------------
   
    //------------------------------Text Assertions----------------------------------
}
