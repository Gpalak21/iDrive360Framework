package com.palakgupta.pages.PageObjectModel.applitools;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPages {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
       // WaitHelpers.checkForVisibilityOfElement(10,username);
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By rememberMe = By.className("form-check-input");
    private By signIn = By.id("log-in");



    public HomePage signIn(String ACMEUrl, String name, String pwd){
        openUrl(ACMEUrl);
        WaitHelpers.checkForVisibilityOfElement(10,username);
        enterElement(username,name);
        enterElement(password,pwd);
        clickElement(rememberMe);
        clickElement(signIn);
        return new HomePage(driver);
    }
}
