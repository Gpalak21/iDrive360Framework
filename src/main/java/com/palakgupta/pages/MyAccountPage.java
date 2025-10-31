package com.palakgupta.pages;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends CommonToAllPages {

    WebDriver driver;
    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        WaitHelpers.checkForVisibilityOfElement(10,cardNumber);
    }

    private By cardNumber = By.xpath("//input[@name='cardnumber']");
    private By expiry=By.xpath("//input[@name='exp-date']");
    private By cvv = By.xpath("//input[@name='cvc']");
    private By billingAdd = By.id("upgradeaddress");
    private By countryDropdown = By.id("countryname");
    private By stateDropdown = By.xpath("//div[@id='us-state-upgradeAccountForm']/select[contains(@formcontrolname,'state')]");
    private By postalCode = By.id("upgradezipcode");
    private By checkbox = By.className("id-checkmark");
    private By upgradeButton = By.id("frm-btn1");
    private By errorText=By.xpath("//div[@class='id-inp-error']");


    public String upgradeAccount(String cno, String cardExpiry, String cvvNo, String add, String text, String text1, String code){
        enterElement(cardNumber,cno);
        enterElement(expiry,cardExpiry);
        enterElement(cvv,cvvNo);
        enterElement(billingAdd,add);
        selectDropdown(countryDropdown,text);
        selectDropdown(stateDropdown,text1);
        enterElement(postalCode,code);
        clickElement(checkbox);
        clickElement(upgradeButton);
        WaitHelpers.checkForVisibilityOfElement(10,errorText);
       return getText(errorText);
    }

}
