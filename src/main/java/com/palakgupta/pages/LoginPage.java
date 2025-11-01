package com.palakgupta.pages;

import com.palakgupta.base.CommonToAllPages;
import com.palakgupta.util.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPages {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        WaitHelpers.checkForVisibilityOfElement(10,email);
    }

    private By email = By.id("username");
    private By password = By.id("password");
    private By signIn = By.id("frm-btn");

    public HomePage signIn(String emailText, String pwdText){
        enterElement(email,emailText);
        enterElement(password,pwdText);
        clickElement(signIn);
        return new HomePage(driver);
    }
}
