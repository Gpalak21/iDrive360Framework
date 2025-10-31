package com.palakgupta.pages;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.PropertiesReader;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends CommonToAllPages {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        WaitHelpers.checkForVisibilityOfElement(10,firstName);
    }

    private By firstName= By.id("fname");
    private By lastName=By.id("lname");
    private By emailAdd = By.id("email");
    private By password = By.id("password");
    private By companyName = By.id("cname");
    private By phone = By.id("telnumSignup");
    private By createMyAcc = By.id("frm-btn");
    private By dropdown = By.xpath("//div[@class='selected-dial-code']");
    private By dropdownSearchBox= By.id("country-search-box");
    private By selectCountry = By.xpath("//li[@id='iti-0__item-in']//span[contains(text(),'"+ PropertiesReader.readKey("countryName")+"')]");


    public HomePage createAccount(String fname, String lname, String add, String pwd, String cname, String countryName, String phoneNumber){
        enterElement(firstName,fname);
        enterElement(lastName,lname);
        enterElement(emailAdd,add);
        enterElement(password,pwd);
        enterElement(companyName, cname);
        clickElement(dropdown);
        WaitHelpers.checkForVisibilityOfElement(5,dropdownSearchBox);
        enterElement(dropdownSearchBox,countryName);
        WaitHelpers.checkForVisibilityOfElement(5,selectCountry);
        clickElement(selectCountry);
        enterElement(phone,phoneNumber);
        clickElement(createMyAcc);
        return new HomePage(driver);
    }

}
